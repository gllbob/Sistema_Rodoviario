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
        String sql = "CALL cadastrarpassagem(?, ?, '?', ?, '?', '?', ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dataSaidaFormatted = dateFormat.format(passagem.getDatasaida());
        
            System.out.println("Passagem.getCidadeorigem().getIdCidade(): " + passagem.getCidadeorigem().getIdCidade());
            System.out.println("Passagem.getCidadedestino().getIdCidade(): " + passagem.getCidadedestino().getIdCidade());
            System.out.println("Passagem.getVeiculo().getPlaca(): " + passagem.getVeiculo().getPlaca());
            System.out.println("Passagem.getPoltrona(): " + passagem.getPoltrona());
            System.out.println("Passagem.getDatasaida(): " + dataSaidaFormatted);
            System.out.println("Passagem.getHorasaida(): " + passagem.getHorasaida());
            System.out.println("Passagem.getValorpassagem(): " + passagem.getValorpassagem());
            
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
        String sql = "SELECT * FROM passagem WHERE idpassagem = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, idPassagem);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int idpassagem = resultSet.getInt("idpassagem");
                    int poltrona = resultSet.getInt("poltrona");
                    Date datasaida = resultSet.getDate("datasaida");
                    String horasaida = resultSet.getString("horasaida");
                    int cidadeOrigemId = resultSet.getInt("cidadeorigem_id");
                    Cidade cidadeOrigem = consultarCidade(cidadeOrigemId);

                    int cidadeDestinoId = resultSet.getInt("cidadedestino_id");
                    Cidade cidadeDestino = consultarCidade(cidadeDestinoId);

                    double valorpassagem = resultSet.getDouble("valorpassagem");
                    String desplaca = resultSet.getString("placa");
                    Veiculo placa = consultarVeiculo(desplaca);


                    return new Passagem(idpassagem, poltrona, datasaida, horasaida, cidadeOrigem, cidadeDestino, valorpassagem, placa);
                }
            }
        }
        return null; // Retorna null se a passagem não for encontrada.
    }
    
    @Override
    public List<Passagem> listarTodasPassagens() throws SQLException {
        List<Passagem> passagems = new ArrayList<>();
        try {
            connection = Conexao.getConnection();
            pst = connection.prepareStatement("SELECT idepassagem, idecidadeorigem, idecidadedestino, ideveiculo, nropoltrona, dtcsaida, deshorasaida, nrovalorpassagem FROM passagem");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Passagem passagem = new Passagem();
                passagem.setIdpassagem(rs.getInt("idepassagem"));
                
                int cidadeOrigemId = rs.getInt("idecidadeorigem");
                Cidade cidadeOrigem = consultarCidade(cidadeOrigemId);
                passagem.setCidadeorigem(cidadeOrigem);
                
                int cidadeDestinoId = rs.getInt("idecidadedestino");
                Cidade cidadeDestino = consultarCidade(cidadeDestinoId);
                passagem.setCidadedestino(cidadeDestino);
                
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
        String sql = "SELECT * FROM cidade WHERE idCidade = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, cidadeId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer idCidade = resultSet.getInt("idCidade");
                    String nomeCidade = resultSet.getString("nomeCidade");
                    String uf = resultSet.getString("uf");
                    return new Cidade(idCidade, nomeCidade, uf);
                }
            }
        }
        return null; // Retorna null se a cidade não for encontrada.
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
        return null; // Retorna null se a cidade não for encontrada.
    }

    

    @Override
    public void excluirPassagem(Integer idPassagem) throws SQLException {
        String sql = "DELETE FROM passagem WHERE idpassagem = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, idPassagem);
            preparedStatement.executeUpdate();
        }
    }
}
