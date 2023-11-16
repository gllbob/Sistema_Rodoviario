package modal.dao;


import conectabd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import domain.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gllbo
 */
public class Usuariodao {
    Connection con;
    PreparedStatement pst;

    public Usuariodao() {
    }
    
    
    public void cadastro(Usuario obj){
        try { con = Conexao.getConnection();
            pst = con.prepareStatement("call cadastrarusuario(?,?,?,?,?);");
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCargo());
            pst.setString(3, obj.getLogin());
            pst.setString(4, obj.getSenha());
            pst.setString(5, obj.getEmail());
            pst.executeUpdate();
        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(Usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
