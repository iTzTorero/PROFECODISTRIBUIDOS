/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dbadmin.ProductoConnection;
import entidades.Producto;
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
@Path("producto")
public class ProductoFacadeREST extends AbstractFacade<Producto> {

    ProductoConnection db = new ProductoConnection();
    @PersistenceContext(unitName = "AccesoDatosMercadoPU")
    private EntityManager em;

    public ProductoFacadeREST() {
        super(Producto.class);
        this.em = Persistence.createEntityManagerFactory("AccesoDatosMercadoPU").createEntityManager();

    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public void create(String json) {
        JSONObject jsonentity = new JSONObject(json);
        Producto entity = new Producto();
        entity.setCategoria(jsonentity.getInt("categoria"));
        entity.setDescripcion(jsonentity.getString("descripcion"));
        entity.setIdmercado(jsonentity.getInt("idmercado"));
        entity.setPrecio((float) jsonentity.getDouble("precio"));
        entity.setNombre(jsonentity.getString("nombre"));
        db.insertarProducto(entity);
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Producto entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        db.eliminarProducto(id);
        
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producto find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
