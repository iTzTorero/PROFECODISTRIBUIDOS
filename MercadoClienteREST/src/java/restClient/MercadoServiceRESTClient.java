/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restClient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:MercadoServiceREST
 * [/mercado]<br>
 * USAGE:
 * <pre>
 *        MercadoServiceRESTClient client = new MercadoServiceRESTClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Juan Pablo
 */
public class MercadoServiceRESTClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/MercadoService/webresources";

    public MercadoServiceRESTClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("mercado");
    }

    public void registrarUsuario(Object requestEntity) throws ClientErrorException {
        webTarget.path("registrar").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN));
    }

    public String eliminarProducto(String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("eliminar/{0}", new Object[]{id})).request().delete(String.class);
    }

    public String actualizarProducto(Object requestEntity, String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("actualizar/{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.TEXT_PLAIN).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN), String.class);
    }

    public String consultarProductos() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("consultarproductos");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void registrarProducto(Object requestEntity) throws ClientErrorException {
        webTarget.path("registrarproducto").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN));
    }

    public String login(Object requestEntity) throws ClientErrorException {
        return webTarget.path("login").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN), String.class);
    }

    public String consultarProducto(String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("consultarproductos/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.close();
    }
    
}
