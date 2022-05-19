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
 * Jersey REST client generated for REST resource:ConsumidorServiceREST
 * [/consumidor]<br>
 * USAGE:
 * <pre>
 *        ConsumidorServiceRESTClient client = new ConsumidorServiceRESTClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Juan Pablo
 */
public class ConsumidorServiceRESTClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ConsumidorService/webresources";

    public ConsumidorServiceRESTClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("consumidor");
    }

    public void registrarUsuario(Object requestEntity) throws ClientErrorException {
        webTarget.path("registrar").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN));
    }

    public void registrarReview(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("review/{0}", new Object[]{id})).request().delete();
    }

    public void registrarReporte(Object requestEntity) throws ClientErrorException {
        webTarget.path("reportar").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN));
    }

    public void eliminarReporte(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("eliminar/reporte/{0}", new Object[]{id})).request().delete();
    }

    public String consultarReviews() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("review");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public String login(Object requestEntity) throws ClientErrorException {
        return webTarget.path("login").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN), String.class);
    }

    public String consultarReportes() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("reportes");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.close();
    }
    
}
