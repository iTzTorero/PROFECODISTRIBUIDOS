/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbadmin;

import db.DatabaseConnection;
import entidades.Producto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Pablo
 */
public class ProductoConnection extends DatabaseConnection {

    DatabaseConnection db = new DatabaseConnection();

    public ProductoConnection() {
        super();
    }

    public void insertarProducto(Producto prod) {
        try {
            String sql = "INSERT INTO `producto` (`idproducto`, `nombre`, `precio`, `descripcion`, `imagen`, `categoria`, `idmercado`) VALUES (NULL,?,?,?, NULL,?,?);";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getNombre());
            ps.setFloat(2, prod.getPrecio());
            ps.setString(3, prod.getDescripcion());
            ps.setInt(4, prod.getCategoria());
            ps.setInt(5, prod.getIdmercado());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarProducto(int id) {
        String sql = String.format("DELETE FROM `producto` WHERE `producto`.`idproducto` = %d", id);
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
