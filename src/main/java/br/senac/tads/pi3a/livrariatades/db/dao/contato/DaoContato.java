/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.contato;

import br.senac.tads.pi3a.livrariatades.db.dao.endereco.DaoEndereco;
import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raul de Paula
 */
public class DaoContato {
    public static void inserirContato(Cliente cliente, int ultimaChavePessoa)
            throws SQLException, Exception {
        String sql = "INSERT INTO Contato VALUES (0, ?, ?, ?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ultimaChavePessoa);
            preparedStatement.setString(2, cliente.getContato().getEmail());
            preparedStatement.setLong(3, cliente.getContato().getTelefone());
            preparedStatement.setLong(4, cliente.getContato().getCelular());
            
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

        String sql = "UPDATE Cliente SET email=?, telefone=?,celular=? "
                + "WHERE (idPessoa=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cliente.getContato().getEmail());
            preparedStatement.setLong(2, (int) cliente.getContato().getTelefone());
            preparedStatement.setLong(3, cliente.getContato().getCelular());
            preparedStatement.setLong(4, cliente.getContato().getCelular());
            
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
