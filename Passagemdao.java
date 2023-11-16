package modal.dao;

import conectabd.Conectabanco;
import domain.Passagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class Passagemdao {
    private Connection con;
    private PreparedStatement pst;

    public Passagemdao() {
    }

    public void cadastrarPassagem(Passagem passagem) {
        try {
            con = Conectabanco.getConnection();
            pst = con.prepareStatement("CALL cadastrarpassagem(?, ?, ?, ?, ?, ?, ?)");
            pst.setLong(1, passagem.getCidadeorigem().getId());
            pst.setLong(2, passagem.getCidadedestino().getId());
            pst.setLong(3, passagem.getVeiculo().getId());
            pst.setInt(4, passagem.getPoltrona());
            pst.setDate(5, new java.sql.Date(passagem.getDatasaida().getTime()));
            pst.setString(6, passagem.getHorasaida());
            pst.setDouble(7, passagem.getValorpassagem());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
