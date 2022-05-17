package dbadmin;


import db.DatabaseConnectionUsuarios;
import entidades.Usuarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juan Pablo
 */
public class UsuariosConnection extends DatabaseConnectionUsuarios{

    DatabaseConnectionUsuarios db = new DatabaseConnectionUsuarios();

    public UsuariosConnection() {
        super();
    }

    public void insertarUsuario(Usuarios usr){
        try {
            String sql = "INSERT INTO `usuarios` (`idusuario`, `tipoUsuario`, `nombre`, `email`, `telefono`, `contrasenia`) VALUES (NULL, ?, ?, ?, ?, ?)";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getTipoUsuario());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getEmail());
            ps.setString(4, usr.getTelefono());
            ps.setString(5, usr.getContrasenia());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
