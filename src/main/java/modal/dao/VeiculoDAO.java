package modal.dao;

import conectabd.Conexao; // Importe a classe de conexão apropriada com base no seu projeto
import domain.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeiculoDAO implements VeiculoDAOListener {
    private Connection con;
    private PreparedStatement pst;

    public VeiculoDAO() {
    }
    
    public ResultSet listarVeiculos() throws SQLException {
        List<Veiculo> veiculos = new ArrayList<>();
        try {
            con = Conexao.getConnection();
            pst = con.prepareStatement("SELECT desplaca FROM veiculo;");
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pst.executeQuery();
    }
    
    /**
     *
     * @param veiculo
     * @throws SQLException
     */
    @Override
    public void cadastrarVeiculo(Veiculo veiculo) throws SQLException {
        try {
            con = Conexao.getConnection(); 
            pst = con.prepareStatement("CALL cadastrarveiculo(?, ?, ?, ?, ?, ?);");
            pst.setString(1, veiculo.getNumero());
            pst.setString(2, veiculo.getPlaca());
            pst.setString(3, veiculo.getMotorista());
            pst.setString(4, veiculo.getModelo());
            pst.setInt(5,veiculo.getAnomodelo());
            pst.setInt(6, veiculo.getQtdpoltronas());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param placa
     * @return
     * @throws SQLException
     */
    @Override
    public Veiculo consultarVeiculoPorPlaca(String placa) throws SQLException {
        Veiculo veiculo = null;
        try {
            con = Conexao.getConnection(); 
            pst = con.prepareStatement("CALL consultarveiculo(?);");
            pst.setString(1, placa);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                veiculo = new Veiculo();
                veiculo.setPlaca(rs.getString("desplaca"));
                veiculo.setMotorista(rs.getString("nommotorista"));
                veiculo.setModelo(rs.getString("desmodelo"));
                veiculo.setAnomodelo(rs.getInt("nroanomodelo"));
                veiculo.setQtdpoltronas(rs.getInt("nropoltronas"));
                veiculo.setNumero(rs.getString("numero"));
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return veiculo;
    }

    @Override
    public List<Veiculo> listarTodosVeiculos() throws SQLException {
        List<Veiculo> veiculos = new ArrayList<>();
        try {
            con = Conexao.getConnection();
            pst = con.prepareStatement("SELECT desplaca, nommotorista, desmodelo, nroanomodelo, nropoltronas, numero FROM veiculo");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(rs.getString("desplaca"));
                veiculo.setMotorista(rs.getString("nommotorista"));
                veiculo.setModelo(rs.getString("desmodelo"));
                veiculo.setAnomodelo(rs.getInt("nroanomodelo"));
                veiculo.setQtdpoltronas(rs.getInt("nropoltronas"));
                veiculo.setNumero(rs.getString("numero"));
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiculos;
    }

    @Override
    public void excluirVeiculoPorPlaca(String placa) throws SQLException {
        try {
            con = Conexao.getConnection(); 
            pst = con.prepareStatement("CALL excluirveiculo(?);");
            pst.setString(1, placa);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
