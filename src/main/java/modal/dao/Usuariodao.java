package modal.dao;


import conectabd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import domain.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.views.Menu;

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
        try {
            this.con = Conexao.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void login(String login, String senha) throws SQLException {
        try {
            pst = con.prepareStatement("call spdeslogin(?,?);");
            pst.setString(1, login);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Menu menu = new Menu();
                menu.setVisible(true);
            } else {
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
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
