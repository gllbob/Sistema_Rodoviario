package modal.dao;

import domain.Veiculo;

import java.sql.SQLException;

public interface VeiculoDAOListener {
    void cadastrarVeiculo(Veiculo veiculo) throws SQLException;

    Veiculo consultarVeiculoPorPlaca(String placa) throws SQLException;
}
