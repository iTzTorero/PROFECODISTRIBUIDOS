/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dbadmin.ReviewConnection;
import entidades.Review;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
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
import org.json.JSONObject;

/**
 *
 * @author Juan Pablo
 */
@javax.ejb.Stateless
@Path("review")
public class ReviewFacadeREST extends AbstractFacade<Review> {

    @PersistenceContext(unitName = "AccesoDatosConsumidorPU")
    ReviewConnection  db = new ReviewConnection();
    private EntityManager em;

    public ReviewFacadeREST() {
        super(Review.class);
        this.em = Persistence.createEntityManagerFactory("AccesoDatosConsumidorPU").createEntityManager();

    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void create(String entity) {
        Review review = new Review();
        JSONObject json = new JSONObject(entity);
        review.setContenido(json.getString("contenido"));
        review.setCalificacion(json.getInt("calificacion"));
        review.setIdmercado(json.getInt("idmercado"));
        review.setIdconsumidor(json.getInt("idconsumidor"));
        db.insertarReview(review);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Review entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        db.eliminarReporte(id);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Review find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Review> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Review> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
