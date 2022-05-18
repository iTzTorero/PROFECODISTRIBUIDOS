/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbadmin;

import db.DatabaseConnection;
import entidades.Oferta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carmi
 */
public class OfertaConnection extends DatabaseConnection {
    DatabaseConnection db = new DatabaseConnection();

    public OfertaConnection() {
        super();
    }
    
    public void insertarOferta(Oferta of) {
        try {
            String sql = "INSERT INTO `oferta` (`idoferta`, `descuento`, `duracion`, `descripcion`, `idMercado`) VALUES (NULL,?,?,?,?);";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setFloat(1,of.getDescuento());
            ps.setInt(2, of.getDuracion());
            ps.setString(3, of.getDescripcion());
            ps.setInt(4, of.getIdmercado());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarOferta(int id) {
        String sql = String.format("DELETE FROM `oferta` WHERE `oferta`.`idoferta` = %d", id);
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
}
