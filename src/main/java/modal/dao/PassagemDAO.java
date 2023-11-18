package modal.dao;

import conectabd.Conexao;
import domain.Cidade;
import domain.Passagem;
import domain.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PassagemDAO implements PassagemDAOListener {
    private Connection connection;
    private PreparedStatement pst;
    
    public PassagemDAO() {
    }

    public PassagemDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void cadastrarPassagem(Passagem passagem) throws SQLException {
        String sql = "CALL cadastrarpassagem(?, ?, ?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dataSaidaFormatted = dateFormat.format(passagem.getDatasaida());

            preparedStatement.setLong(1, passagem.getCidadeorigem().getIdCidade());
            preparedStatement.setLong(2, passagem.getCidadedestino().getIdCidade());
            preparedStatement.setString(3, passagem.getVeiculo().getPlaca()); 
            preparedStatement.setInt(4, passagem.getPoltrona());
            preparedStatement.setString(5, dataSaidaFormatted);
            preparedStatement.setString(6, passagem.getHorasaida());
            preparedStatement.setDouble(7, passagem.getValorpassagem());

            preparedStatement.executeUpdate();
        }
    }
    
    @Override
    public Passagem obterPassagemPorId(Integer idPassagem) throws SQLException {
        String sql = "CALL consultarpassagem(?)";
        
        try {
            connection = Conexao.getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, idPassagem);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int idpassagem = resultSet.getInt("idepassagem");
                        int poltrona = resultSet.getInt("nropoltrona");
                        java.sql.Date sqlDataSaida = resultSet.getDate("dtcsaida");
                        Date datasaida = new Date(sqlDataSaida.getTime());
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String dataSaidaFormatted = dateFormat.format(datasaida);

                        String horasaida = resultSet.getString("deshorasaida");
                        int cidadeOrigemId = resultSet.getInt("idecidadeorigem");
                        Cidade cidadeOrigem = consultarCidade(cidadeOrigemId);

                        int cidadeDestinoId = resultSet.getInt("idecidadedestino");
                        Cidade cidadeDestino = consultarCidade(cidadeDestinoId);

                        double valorpassagem = resultSet.getDouble("nrovalorpassagem");
                        String desplaca = resultSet.getString("desplaca");
                        Veiculo placa = consultarVeiculo(desplaca);

                        return new Passagem(idpassagem, poltrona, datasaida, horasaida, cidadeOrigem, cidadeDestino, valorpassagem, placa);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PassagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    @Override
    public List<Passagem> listarTodasPassagens() throws SQLException {
        List<Passagem> passagems = new ArrayList<>();
        try {
            connection = Conexao.getConnection();
            pst = connection.prepareStatement("SELECT p.idepassagem, p.idecidadeorigem, c.nomcidade AS cidadeorigem, p.idecidadedestino, c2.nomcidade AS cidadedestino, p.ideveiculo, v.desplaca, p.nropoltrona, p.dtcsaida, p.deshorasaida, p.nrovalorpassagem FROM passagem p, cidade c, cidade c2, veiculo v WHERE c.idecidade = p.idecidadeorigem AND v.ideveiculo = p.ideveiculo AND c2.idecidade = p.idecidadedestino order by p.idepassagem desc;");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Passagem passagem = new Passagem();
                passagem.setIdpassagem(rs.getInt("idepassagem"));
                passagem.setDatasaida(rs.getDate("dtcsaida"));
                passagem.setHorasaida(rs.getString("deshorasaida"));
                passagem.setPoltrona(rs.getInt("nropoltrona"));
                passagem.setValorpassagem(rs.getDouble("nrovalorpassagem"));
                
                int cidadeOrigemId = rs.getInt("idecidadeorigem");
                Cidade cidadeOrigem = consultarCidade(cidadeOrigemId);
                passagem.setCidadeorigem(cidadeOrigem);
                
                int cidadeDestinoId = rs.getInt("idecidadedestino");
                Cidade cidadeDestino = consultarCidade(cidadeDestinoId);
                passagem.setCidadedestino(cidadeDestino);
                
                String desplaca = rs.getString("desplaca");
                Veiculo veiculo = consultarVeiculo(desplaca);
                passagem.setVeiculo(veiculo);
                
                passagems.add(passagem);
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(PassagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passagems;
    }

    private Cidade consultarCidade(Integer cidadeId) throws SQLException {
        String sql = "SELECT idecidade, nomcidade, desuf FROM cidade WHERE idecidade = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, cidadeId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer idCidade = resultSet.getInt("idecidade");
                    String nomeCidade = resultSet.getString("nomcidade");
                    String uf = resultSet.getString("desuf");
                    return new Cidade(idCidade, nomeCidade, uf);
                }
            }
        }
        return null;
    }
    
    private Veiculo consultarVeiculo(String placa) throws SQLException {
        String sql = "SELECT desplaca FROM veiculo WHERE desplaca = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, placa);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String desplaca = resultSet.getString("desplaca");
                    return new Veiculo(desplaca);
                }
            }
        }
        return null;
    }

    

    @Override
    public void excluirPassagem(Integer idPassagem) throws SQLException {
        String sql = "CALL excluirpassagem(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, idPassagem);
            preparedStatement.executeUpdate();
        }
    }
    
    public boolean verificarPoltronaVendida(Passagem passagem) throws SQLException {
        String sql = "CALL spstspassagem(?,?,?);";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, passagem.getVeiculo().getPlaca());
            statement.setInt(2, passagem.getPoltrona());
            statement.setDate(3, new java.sql.Date(passagem.getDatasaida().getTime()));

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("nro");
                    System.out.println("Count: " + count);
                    return count > 0; 
                }
            }
        } catch (SQLException e) {
            throw e;
        }

        return false;
    }
    
    public List<Passagem> faturamento(Date dtcinicio, Date dtcfinal) throws SQLException {
        List<Passagem> passagems = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            connection = Conexao.getConnection();
            pst = connection.prepareStatement("CALL spdesfaturamento(?,?);");
            pst.setString(1, format.format(dtcinicio));
            pst.setString(2, format.format(dtcfinal));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Passagem passagem = new Passagem();
                passagem.setIdpassagem(rs.getInt("idepassagem"));
                passagem.setDatasaida(rs.getDate("dtcsaida"));
                passagem.setHorasaida(rs.getString("deshorasaida"));
                passagem.setPoltrona(rs.getInt("nropoltrona"));
                passagem.setValorpassagem(rs.getDouble("nrovalorpassagem"));
                
                int cidadeOrigemId = rs.getInt("idecidadeorigem");
                Cidade cidadeOrigem = consultarCidade(cidadeOrigemId);
                passagem.setCidadeorigem(cidadeOrigem);
                
                int cidadeDestinoId = rs.getInt("idecidadedestino");
                Cidade cidadeDestino = consultarCidade(cidadeDestinoId);
                passagem.setCidadedestino(cidadeDestino);
                
                String desplaca = rs.getString("desplaca");
                Veiculo veiculo = consultarVeiculo(desplaca);
                passagem.setVeiculo(veiculo);
                
                passagems.add(passagem);
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(PassagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passagems;
    }
}