/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dbadmin.ReporteConnection;
import entidades.Reporte;
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
@Path("reporte")
public class ReporteFacadeREST extends AbstractFacade<Reporte> {

    ReporteConnection db = new ReporteConnection();
    @PersistenceContext(unitName = "AccesoDatosConsumidorPU")
    private EntityManager em;

    public ReporteFacadeREST() {
        super(Reporte.class);
        this.em = Persistence.createEntityManagerFactory("AccesoDatosConsumidorPU").createEntityManager();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void create(String entity) {
        Reporte rep = new Reporte();
        JSONObject json = new JSONObject(entity);
        rep.setIdmercado(json.getInt("idmercado"));
        rep.setIdproducto(json.getInt("idproducto"));
        rep.setDescripcion(json.getString("descripcion"));
        db.insertarReporte(rep);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Reporte entity) {
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
    public Reporte find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reporte> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reporte> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
