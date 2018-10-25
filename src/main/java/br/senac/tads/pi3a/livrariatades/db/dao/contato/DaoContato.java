/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.contato;

import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.contato.Contato;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raul de Paula
 */
public class DaoContato {
    public static void inserirContato(Contato contato, int ultimaChavePessoa)
            throws SQLException, Exception {
        String sql = "INSERT INTO Contato VALUES (0, ?, ?, ?,?)";
        
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ultimaChavePessoa);
            preparedStatement.setString(2, contato.getEmail());
            preparedStatement.setLong(3, contato.getTelefone());
            preparedStatement.setLong(4, contato.getCelular());
            
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
    
    public static void atualizar(Contato contato, int idPessoa)
            throws SQLException, Exception {

        String sql = "UPDATE Cliente SET email=?, telefone=?,celular=? "
                + "WHERE (idPessoa=?)";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, contato.getEmail());
            preparedStatement.setLong(2, contato.getTelefone());
            preparedStatement.setLong(3, contato.getCelular());
            preparedStatement.setLong(4, idPessoa);
            
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
    
    public static List<Cliente> listar(List<Cliente> listaPessoa)
            throws SQLException, Exception {
        String sql = "SELECT * FROM Contato";
        
        int contador = 0;
        Cliente cliente;
        Contato contato = new Contato();
        List<Cliente> listaClientes = null;
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                int idPessoa;
                idPessoa = result.getInt("idPessoa");
                cliente = listaPessoa.get(contador);
                
                if (idPessoa == cliente.getIdPessoa()){
                    contato.setEmail(result.getString("email"));
                    contato.setTelefone(result.getLong("telefone"));
                    contato.setCelular(result.getLong("celular"));
                    cliente.setContato(contato);
                    
                    listaClientes.add(cliente);
                }
                contador++;
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaClientes;
    }

}
