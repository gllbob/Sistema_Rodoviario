package modal.dao;

import conectabd.Conectabanco;
import domain.Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cidadedao {
    private Connection con;
    private PreparedStatement pst;

    public Cidadedao() {
    }

    public void cadastrarCidade(Cidade cidade) {
        try {
            con = Conectabanco.getConnection();
            pst = con.prepareStatement("call cadastrarcidade(?,?,?);");
            pst.setLong(1, cidade.getIdCidade());
            pst.setString(2, cidade.getNomeCidade());
            pst.setString(3, cidade.getUf());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public Cidade obterCidadePorId(Long idCidade) {
        Cidade cidade = null;
        try {
            con = Conectabanco.getConnection();
            pst = con.prepareStatement("call consultarcidade(?);");
            pst.setLong(1, idCidade);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cidade = new Cidade(
                    rs.getLong("idecidade"),
                    rs.getString("nomcidade"),
                    rs.getString("desuf")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return cidade;
    }
    
    
}
