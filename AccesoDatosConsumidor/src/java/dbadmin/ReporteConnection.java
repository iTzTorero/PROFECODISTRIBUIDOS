/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbadmin;

import db.DatabaseConnection;
import entidades.Reporte;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Pablo
 */
public class ReporteConnection extends DatabaseConnection {

    DatabaseConnection db = new DatabaseConnection();

    public ReporteConnection() {
        super();
    }

    public void insertarReporte(Reporte rep) {
        try {
            String sql = "INSERT INTO `reporte` (`idreporte`, `descripcion`, `idproducto`, `idmercado`) VALUES (NULL, ?, ?, ?);";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, rep.getDescripcion());
            ps.setInt(2, rep.getIdproducto());
            ps.setInt(3, rep.getIdmercado());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReporteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarReporte(int id) {
        String sql = String.format("DELETE FROM `reporte` WHERE `reporte`.`idreporte` = %d", id);
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
