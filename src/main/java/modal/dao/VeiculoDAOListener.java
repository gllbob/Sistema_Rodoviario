package modal.dao;

import domain.Veiculo;

import java.sql.SQLException;
import java.util.List;

public interface VeiculoDAOListener {
    void cadastrarVeiculo(Veiculo veiculo) throws SQLException;

    Veiculo consultarVeiculoPorPlaca(String placa) throws SQLException;
    
    public List<Veiculo> listarTodosVeiculos() throws SQLException;
    
    public void excluirVeiculoPorPlaca(String placa) throws SQLException;
}
