/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ejb.Stateless;
import dto.UsuariosDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.FormParam;
import org.json.JSONObject;
import rabbit.Producer;
import restClients.ConsumidorRESTClient;
import restClients.UsuariosRESTClient;
import restClients.MultaRESTClient;

/**
 *
 * @author Juan Pablo
 */
@Stateless
@Path("/profeco")
public class ProfecoServiceREST {

    private UsuariosRESTClient clienteUsuario = new UsuariosRESTClient();
    private MultaRESTClient clienteMulta = new MultaRESTClient();
    private ConsumidorRESTClient clienteConsumidor = new ConsumidorRESTClient();
    public ProfecoServiceREST() {

    }

    //JALA AL 100
    @POST
    @Path("login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String login(@FormParam("email") String email, @FormParam("contrasenia") String psw) {

        ObjectMapper objectMapper = new ObjectMapper();

        List<UsuariosDTO> list = new ArrayList();
        String jsonString = clienteUsuario.findAll(String.class).toString();
        try {
            list = objectMapper.readValue(jsonString, new TypeReference<List<UsuariosDTO>>() {
            });
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ProfecoServiceREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (UsuariosDTO user : list) {
            if (user.getEmail().equals(email) && user.getContrasenia().equals(psw) && user.getTipoUsuario().equalsIgnoreCase("Profeco")) {
                JSONObject json = new JSONObject();
                json.put("email", user.getEmail());
                json.put("idusuario", user.getIdusuario());
                json.put("telefono", user.getTelefono());
                json.put("contrasenia", user.getContrasenia());
                json.put("tipoUsuario", user.getTipoUsuario());
                json.put("nombre", user.getNombre());
                return json.toString();
            }
        }
        return null;
    }

    @POST
    @Path("registrar")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String registrarUsuario(String usuariojson) {
        clienteUsuario.create(usuariojson);
        return usuariojson;
    }

    @POST
    @Path("registrar/multa")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String registrarMulta(String multajson) {
        clienteMulta.create(multajson);
        JSONObject json = new JSONObject(multajson);
        String jsonmercado = clienteUsuario.find(String.class, "" + json.getInt("idmercado"));
        JSONObject jsonMercado = new JSONObject(jsonmercado);
        JSONObject jsonnotificacion = new JSONObject();
        jsonnotificacion.put("email", jsonMercado.get("email"));
        jsonnotificacion.put("importe", json.get("importe"));
        jsonnotificacion.put("descripcion", json.get("descripcion"));
        Producer prod = new Producer();
        try {
            prod.enviarAvisoMulta(jsonnotificacion);
        } catch (Exception ex) {
            Logger.getLogger(ProfecoServiceREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonnotificacion.toString();
    }

    @GET
    @Path("reportes")
    @Produces(MediaType.APPLICATION_JSON)
    public String consultarReportes(){
       return clienteConsumidor.consultarReportes();
    }
}
