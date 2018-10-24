/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.endereco;

import br.senac.tads.pi3a.livrariatades.db.dao.contato.DaoContato;
import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raul de Paula
 */
public class DaoEndereco {
        public static void inserirEndereco(Cliente cliente, int ultimaChavePessoa)
            throws SQLException, Exception {
        String sql = "INSERT INTO Contato VALUES (0, ?, ?, ?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ultimaChavePessoa);
            preparedStatement.setString(2, cliente.getEndereco().getRua());
            preparedStatement.setInt(3, cliente.getEndereco().getNumero());
            preparedStatement.setString(4, cliente.getEndereco().getBairro());
            preparedStatement.setInt(5, cliente.getEndereco().getCep());
            preparedStatement.setString(6, cliente.getEndereco().getComplemento());
            
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
        
    public static void atualizar(Cliente cliente)
            throws SQLException, Exception {

        String sql = "UPDATE Endereco SET rua=?, numero=?, bairro=?, cep=?, complemento=? "
                + "WHERE (idPessoa=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cliente.getEndereco().getRua());
            preparedStatement.setInt(2, cliente.getEndereco().getNumero());
            preparedStatement.setString(3, cliente.getEndereco().getBairro());
            preparedStatement.setInt(3, cliente.getEndereco().getCep());
            preparedStatement.setString(3, cliente.getEndereco().getComplemento());
            preparedStatement.setInt(3, cliente.getIdPessoa());
                        
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
