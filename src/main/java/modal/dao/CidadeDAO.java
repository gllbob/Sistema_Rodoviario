package modal.dao;

import conectabd.Conexao;
import domain.Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CidadeDAO implements CidadeDAOListener {
    private Connection con;
    private PreparedStatement pst;

    public CidadeDAO() {
    }
    
    public ResultSet listarCidades() throws SQLException {
        List<Cidade> cidades = new ArrayList<>();
        try {
            con = Conexao.getConnection();
            pst = con.prepareStatement("SELECT idecidade, nomcidade, desuf FROM cidade;");
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pst.executeQuery();
    }

    @Override
    public void cadastrarCidade(Cidade cidade) throws SQLException {
        try {
            con = Conexao.getConnection();
            pst = con.prepareStatement("CALL cadastrarcidade(?, ?, ?);");
            pst.setLong(1, cidade.getIdCidade());
            pst.setString(2, cidade.getNomeCidade());
            pst.setString(3, cidade.getUf());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cidade obterCidadePorId(Integer idCidade) throws SQLException {
        Cidade cidade = null;
        try {
            con = Conexao.getConnection();
            pst = con.prepareStatement("CALL consultarcidade(?);");
            pst.setLong(1, idCidade);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cidade = new Cidade(
                    rs.getInt("idecidade"),
                    rs.getString("nomcidade"),
                    rs.getString("desuf")
                );
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cidade;
    }

    @Override
    public List<Cidade> listarTodasCidades() throws SQLException {
        List<Cidade> cidades = new ArrayList<>();
        try {
            con = Conexao.getConnection();
            pst = con.prepareStatement("SELECT idecidade, nomcidade, desuf FROM cidade;");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade(
                    rs.getInt("idecidade"),
                    rs.getString("nomcidade"),
                    rs.getString("desuf")
                );
                cidades.add(cidade);
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cidades;
    }

    @Override
    public void excluirCidade(Integer idCidade) throws SQLException {
        try {
            con = Conexao.getConnection();
            pst = con.prepareStatement("DELETE FROM cidade WHERE idecidade = ?;");
            pst.setInt(1, idCidade);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
