/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UsuariosDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;
import rabbit.Producer;
import restClients.MercadoRESTClient;
import restClients.ReporteRESTClient;
import restClients.UsuariosRESTClient;
import restClients.ReviewRESTClient;

/**
 *
 * @author Juan Pablo
 */
@Stateless
@Path("/consumidor")
public class ConsumidorServiceREST {

    UsuariosRESTClient clienteUsuario = new UsuariosRESTClient();
    ReporteRESTClient clienteReporte = new ReporteRESTClient();
    MercadoRESTClient clienteMercado = new MercadoRESTClient();
    ReviewRESTClient clienteReview = new ReviewRESTClient();

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
            Logger.getLogger(ConsumidorServiceREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (UsuariosDTO user : list) {
            if (user.getEmail().equals(email) && user.getContrasenia().equals(psw) && user.getTipoUsuario().equalsIgnoreCase("Consumidor")) {
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
    public void registrarUsuario(String usuariojson) {
        clienteUsuario.create(usuariojson);
    }

    @POST
    @Path("reportar")
    @Consumes(MediaType.TEXT_PLAIN)
    public void registrarReporte(String reportejson) {

        clienteReporte.create(reportejson);
        JSONObject json = new JSONObject(reportejson);
        String jsonproducto = clienteMercado.consultarProducto("" + json.getInt("idproducto"));
        String jsonmercado = clienteUsuario.find(String.class, "" + json.getInt("idmercado"));
        JSONObject jsonMercado = new JSONObject(jsonmercado);
        JSONObject jsonProducto = new JSONObject(jsonproducto);
        JSONObject jsonnotificacion = new JSONObject();
        jsonnotificacion.put("email", jsonMercado.get("email"));
        jsonnotificacion.put("nombre", jsonProducto.get("nombre"));
        jsonnotificacion.put("descripcion", json.get("descripcion"));
        Producer prod = new Producer();
        try {
            prod.enviarAvisoReporte(jsonnotificacion);
        } catch (Exception ex) {
            Logger.getLogger(ConsumidorServiceREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("eliminar/reporte/{id}")
    public void eliminarReporte(@PathParam("id") Integer id) {
        clienteReporte.remove(id + "");
    }

    @GET
    @Path("reportes")
    @Produces(MediaType.APPLICATION_JSON)
    public String consultarReportes() {
        return clienteReporte.findAll(String.class);
    }

    @POST
    @Path("review")
    public void registrarReview(String reviewjson) {
        clienteReview.create(reviewjson);
    }

    @DELETE
    @Path("review/{id}")
    public void registrarReview(@PathParam("id") Integer id) {
        clienteReview.remove(id + "");
    }

    @GET
    @Path("review")
    @Produces(MediaType.APPLICATION_JSON)
    public String consultarReviews() {
        return clienteReview.findAll(String.class);
    }

}
