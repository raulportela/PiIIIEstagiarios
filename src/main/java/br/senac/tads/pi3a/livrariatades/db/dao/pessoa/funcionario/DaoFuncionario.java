/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.pessoa.funcionario;

import br.senac.tads.pi3a.livrariatades.db.dao.contato.DaoContato;
import br.senac.tads.pi3a.livrariatades.db.dao.endereco.DaoEndereco;
import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raul de Paula
 */
public class DaoFuncionario {
    public static void inserir(Funcionario funcionario, int ultimaChavePessoa)
            throws SQLException, Exception {
        String sql = "INSERT INTO cliente VALUES (0, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ultimaChavePessoa);
            preparedStatement.setInt(2, funcionario.getCodFuncionario());
            preparedStatement.setBoolean(3, funcionario.isDisponivel());
            preparedStatement.setString(4, funcionario.getNomeUsuario());
            preparedStatement.setInt(5, funcionario.getSenha());
            preparedStatement.setInt(6, funcionario.getNivelFuncao());
            preparedStatement.setString(7, funcionario.getRg());
            
            DaoContato.inserirContato(funcionario.getContato(), ultimaChavePessoa);
            DaoEndereco.inserirEndereco(funcionario.getEndereco(), ultimaChavePessoa);
            
            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    public static void atualizar(Funcionario funcionario)
            throws SQLException, Exception {

        String sql = "UPDATE Funcionario SET disponivel=?, nomeUsuario=?, senha=?, nivelFuncao=?,rg=? "
                + "WHERE (idPessoa=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setBoolean(1, funcionario.isDisponivel());
            preparedStatement.setString(2, funcionario.getNomeUsuario());
            preparedStatement.setInt(3, funcionario.getSenha());
            preparedStatement.setInt(3, funcionario.getNivelFuncao());
            preparedStatement.setString(3, funcionario.getRg());

            DaoContato.atualizar(funcionario.getContato(), funcionario.getIdPessoa());
            DaoEndereco.atualizar(funcionario.getEndereco(), funcionario.getIdPessoa());
            preparedStatement.execute();

        } finally {

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    public static void excluir(Integer id)
            throws SQLException, Exception {

        String sql = "UPDATE Funcionario SET dispinivel=? "
                + "WHERE (idPessoa=?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
