/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.dao;

import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import br.senac.tads.pi3a.livrariatades.utils.ConnectionUtils;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raul de Paula
 */
public class DaoCliente {
    public static void inserir(Cliente cliente) throws SQLException, Exception {
               Cliente c1 = cliente;

        String sql = "INSERT INTO cliente VALUES (0, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getNome());

            preparedStatement.setString(2, cliente.getSobrenome());
            preparedStatement.setString(3, cliente.getCpf());
           
//            String cpf = "";
//            cpf += cliente.getCpf().substring(0, 3)
//                    + cliente.getCpf().substring(4, 7)
//                    + cliente.getCpf().substring(8, 11)
//                    + cliente.getCpf().substring(12, 14);
//
//            preparedStatement.setString(5,""+ cliente.getTelefone());
//            preparedStatement.setString(6,""+ cliente.getCelular());
//            preparedStatement.setString(7, cliente.getEmail());
            
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
        
        String sql = "UPDATE cliente SET NomeCliente=?, CPF=?, DataNasc=?, Email=?, Telefone1=?, Telefone2=?, Endereço=? WHERE (cliente_id=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.setString(3, cliente.getCpf());
//            Timestamp t = new Timestamp(cliente.getDataNascimento().getTime());
//            preparedStatement.setTimestamp(4, t);
            preparedStatement.setString(5, cliente.getEmail());
            preparedStatement.setInt(6, cliente.getTelefone());
            preparedStatement.setInt(7, cliente.getCelular());
            preparedStatement.setString(8, cliente.getEndereco());
            
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


    public static void excluir(Integer id) throws SQLException, Exception {

        String sql = "UPDATE cliente SET enabled=? WHERE (cliente_id=?)";

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
