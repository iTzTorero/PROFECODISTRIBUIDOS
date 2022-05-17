/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbadmin;

import db.DatabaseConnection;
import entidades.Multa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Pablo
 */
public class MultaConnection extends DatabaseConnection {

    DatabaseConnection db = new DatabaseConnection();

    public MultaConnection() {
        super();
    }

    public void insertarMulta(Multa multa) {
        try {
            String sql = "INSERT INTO `multa` (`idmulta`, `descripcion`, `importe`, `idmercado`) VALUES (NULL,?,?,?);";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, multa.getDescripcion());
            ps.setFloat(2, multa.getImporte());
            ps.setInt(3, multa.getIdmercado());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MultaConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarMulta(int id) {
        String sql = String.format("DELETE FROM `multa` WHERE `multa`.`idmulta` = %d", id);
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MultaConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
