/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Usuarios;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.DELETE;
import static javafx.scene.input.KeyCode.T;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import restClients.ProductoRESTClient;
import restClients.UsuariosRESTClient;
import sun.net.www.http.HttpClient;

/**
 *
 * @author Juan Pablo
 */
@Stateless
@Path("/mercado")
public class MercadoServiceREST {

    UsuariosRESTClient clienteUsuario = new UsuariosRESTClient();
    ProductoRESTClient clienteProducto = new ProductoRESTClient();

    @POST
    @Path("login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String login(String jsonlogin) {

        JSONObject jsondatos = new JSONObject(jsonlogin);
        String email = jsondatos.getString("email");
        String psw = jsondatos.getString("contrasenia");
        ObjectMapper objectMapper = new ObjectMapper();

        List<Usuarios> list = new ArrayList();
        String jsonString = clienteUsuario.findAll(String.class).toString();
        try {
            list = objectMapper.readValue(jsonString, new TypeReference<List<Usuarios>>() {
            });
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MercadoServiceREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Usuarios user : list) {
            if (user.getEmail().equals(email) && user.getContrasenia().equals(psw) && user.getTipoUsuario().equalsIgnoreCase("Mercado")) {
                JSONObject json = new JSONObject();
                json.put("email", user.getEmail());
                json.put("idusuario", user.getIdusuario());
                json.put("telefono", user.getTelefono());
                json.put("contrasenia", user.getContrasenia());
                json.put("tipoUsuario", user.getTipoUsuario());
                json.put("nombre", user.getNombre());
                json.put("token", crearToken(user.getEmail()));
                return json.toString();
            }
        }
        return null;
    }

    @POST
    @Path("registrar")
    @Consumes(MediaType.TEXT_PLAIN)
    public void registrarUsuario(String usuariojson) {
        clienteUsuario.create(usuariojson);
    }

    @POST
    @Path("registrarproducto")
    @Consumes(MediaType.TEXT_PLAIN)
    public void registrarProducto(String productojson) {

        clienteProducto.create(productojson);
    }

    @DELETE
    @Path("eliminar/{id}")
    public String eliminarProducto(@PathParam("id") Integer id) {
        clienteProducto.remove(id + "");
        return id + "";
    }

    //Pendiente
    @PUT
    @Path("actualizar/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public String actualizarProducto(@PathParam("id") Integer id) {
        clienteProducto.remove(id + "");
        return id + "";
    }

    @GET
    @Path("consultarproductos")
    @Produces(MediaType.APPLICATION_JSON)
    public String consultarProductos() {
        return clienteProducto.findAll(String.class).toString();
    }

    @GET
    @Path("consultarproductos/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String consultarProducto(@PathParam("id") Integer id) {
        return clienteProducto.find(String.class, id + "").toString();
    }

    public String crearToken(String email) {
        String token = null;
        try {
            com.auth0.jwt.algorithms.Algorithm alg = com.auth0.jwt.algorithms.Algorithm.HMAC256("porfabor");
            token = JWT.create().withIssuer("auth0").withClaim("email", email).sign(alg);
        } catch (JWTCreationException exception) {
        }
        return token;
    }
}
