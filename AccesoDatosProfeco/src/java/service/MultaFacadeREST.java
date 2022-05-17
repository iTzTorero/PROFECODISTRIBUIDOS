/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dbadmin.MultaConnection;
import entidades.Multa;
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
@Path("multa")
public class MultaFacadeREST extends AbstractFacade<Multa> {

    MultaConnection db = new MultaConnection();
    @PersistenceContext(unitName = "AccesoDatosProfecoPU")
    private EntityManager em;

    public MultaFacadeREST() {
        super(Multa.class);
        this.em = Persistence.createEntityManagerFactory("AccesoDatosProfecoPU").createEntityManager();

    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void create(String multajson) {
        JSONObject json = new JSONObject(multajson);
        Multa multa = new Multa();
        multa.setDescripcion(json.getString("descripcion"));
        multa.setIdmercado(json.getInt("idmercado"));
        multa.setImporte((float) json.getDouble("importe"));
        db.insertarMulta(multa);

    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Multa entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        db.eliminarMulta(id);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Multa find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Multa> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Multa> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
