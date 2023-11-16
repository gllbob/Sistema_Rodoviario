package modal.dao;

import domain.Passagem;
import java.sql.SQLException;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gllbo
 */
public interface PassagemDAOListener {
    void cadastrarPassagem(Passagem passagem) throws SQLException;

    Passagem obterPassagemPorId(Integer idPassagem) throws SQLException;

    List<Passagem> listarTodasPassagens() throws SQLException;

    void excluirPassagem(Integer idPassagem) throws SQLException;
}
