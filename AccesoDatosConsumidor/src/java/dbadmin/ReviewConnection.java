/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbadmin;

import db.DatabaseConnection;
import entidades.Review;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Pablo
 */
public class ReviewConnection extends DatabaseConnection{
    
DatabaseConnection db = new DatabaseConnection();
    public ReviewConnection() {
        super();
    }

    public void insertarReview(Review review) {
        try {
            String sql = "INSERT INTO `review` (`idreview`, `contenido`, `calificacion`, `idconsumidor`, `idmercado`) VALUES (NULL,?,?,?,?);";
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);
            ps.setString(1, review.getContenido());
            ps.setInt(2, review.getCalificacion());
            ps.setInt(3, review.getIdconsumidor());
            ps.setInt(4, review.getIdmercado());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarReporte(int id) {
        String sql = String.format("DELETE FROM `review` WHERE `review`.`idreview` = %d", id);
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ReviewConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
