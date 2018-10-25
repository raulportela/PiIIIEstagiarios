/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.pessoa;

import br.senac.tads.pi3a.livrariatades.db.dao.contato.DaoContato;
import br.senac.tads.pi3a.livrariatades.db.dao.endereco.DaoEndereco;
import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.cliente.DaoCliente;
import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.funcionario.DaoFuncionario;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.pessoa.Pessoa;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Raul de Paula
 */
public class DaoPessoa {

    private static boolean isClient;

    public static void inserirPessoa(Cliente cliente, Funcionario funcionario)
            throws SQLException, Exception {
        Pessoa pessoa = new Pessoa() {
        };
        if (cliente != null && funcionario == null) {
            pessoa = cliente;
        } else if (funcionario != null && cliente == null) {
            pessoa = funcionario;
        }

        String sql = "INSERT INTO Pessoa VALUES (0, ?, ?, ?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getSobrenome());
            preparedStatement.setLong(3, pessoa.getCpf());
            Timestamp t = new Timestamp(pessoa.getDataNascimento().getTime());
            preparedStatement.setTimestamp(4, t);

            preparedStatement.execute();
            int ultimaChave = 0;
            ResultSet chaveGeradaVenda = preparedStatement.getGeneratedKeys();
            if (chaveGeradaVenda.next()) {
                ultimaChave = chaveGeradaVenda.getInt(1);
            }
            if (isClient) {
                DaoCliente.inserir(cliente, ultimaChave);
            } else {
                DaoFuncionario.inserir(funcionario, ultimaChave);
            }

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void atualizar(Cliente cliente, Funcionario funcionario)
            throws SQLException, Exception {
        Pessoa pessoa = new Pessoa() {
        };
        if (cliente != null && funcionario == null) {
            pessoa = cliente;
        } else if (funcionario != null && cliente == null) {
            pessoa = funcionario;
        }

        String sql = "UPDATE cliente SET nome=?, sobrenome=?, cpf=?, dataNascimento=?"
                + "WHERE (id=?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getSobrenome());
            preparedStatement.setLong(3, pessoa.getCpf());
            Timestamp t = new Timestamp(pessoa.getDataNascimento().getTime());
            preparedStatement.setTimestamp(4, t);

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
//ACHO QUE NAO PRECISA DESSE TRECHO, PRECISO DEFINIR COM O GRUPO DEPOIS
//    public static void excluir(int id)
//            throws SQLException, Exception {
//
//        String sql = "UPDATE funcionarioLista SET disponivel=? "
//                + "WHERE (idPessoa=?)";
//
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//
//            connection = ConnectionUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setBoolean(1, false);
//            preparedStatement.setInt(2, id);
//
//            DaoCliente.excluir(id);
//            preparedStatement.execute();
//
//        } finally {
//
//            if (preparedStatement != null && !preparedStatement.isClosed()) {
//                preparedStatement.close();
//            }
//            if (connection != null && !connection.isClosed()) {
//                connection.close();
//            }
//        }
//    }

    public static List<Cliente> listarCliente()
            throws SQLException, Exception {
        String sql = "SELECT * FROM Pessoa";
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

                Cliente clienteLista = new Cliente();

                clienteLista.setIdPessoa(result.getInt("id"));
                clienteLista.setNome(result.getString("nome"));
                clienteLista.setSobrenome(result.getString("sobrenome"));
                clienteLista.setCpf(result.getLong("cpf"));
                Date datanasc = new Date(result.getTimestamp("dataNascimento").getTime());
                clienteLista.setDataNascimento(datanasc);

                listaClientes.add(clienteLista);
            }
            DaoCliente.listar(listaClientes);
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

    public static List<Funcionario> listarFuncionario()
            throws SQLException, Exception {
        String sql = "SELECT * FROM Pessoa";
        List<Funcionario> listaFuncionarios = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaFuncionarios == null) {
                    listaFuncionarios = new ArrayList<Funcionario>();
                }

                Funcionario funcionarioLista = new Funcionario();

                funcionarioLista.setIdPessoa(result.getInt("id"));
                funcionarioLista.setNome(result.getString("nome"));
                funcionarioLista.setSobrenome(result.getString("sobrenome"));
                funcionarioLista.setCpf(result.getLong("cpf"));
                Date datanasc = new Date(result.getTimestamp("dataNascimento").getTime());
                funcionarioLista.setDataNascimento(datanasc);

                listaFuncionarios.add(funcionarioLista);
            }
            DaoFuncionario.listar(listaFuncionarios);
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
        return listaFuncionarios;
    }

    
    public boolean isIsClient() {
        return isClient;
    }

    public void setIsClient(boolean isClient) {
        this.isClient = isClient;
    }
    
    public static Cliente procurarCliente(int cpf)
            throws SQLException, Exception {
        String sql = "SELECT * FROM Pessoa"
                + "WHERE cpf=?";

        Cliente cliente = new Cliente();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cpf);

            result = preparedStatement.executeQuery();

            if (result.next()) {
                cliente.setIdPessoa(result.getInt("id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                cliente.setCpf(result.getLong("cpf"));
                Date datanasc = new Date(result.getTimestamp("dataNascimento").getTime());
                cliente.setDataNascimento(datanasc);
                
                cliente = DaoCliente.procurar(cliente);
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
        return cliente;
    }
    
    public static Funcionario procurarFuncionario(int cpf)
            throws SQLException, Exception {
        String sql = "SELECT * FROM Pessoa"
                + "WHERE cpf=?";

        Funcionario funcionario = new Funcionario();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cpf);

            result = preparedStatement.executeQuery();

            if (result.next()) {
                funcionario.setIdPessoa(result.getInt("id"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setSobrenome(result.getString("sobrenome"));
                funcionario.setCpf(result.getLong("cpf"));
                Date datanasc = new Date(result.getTimestamp("dataNascimento").getTime());
                funcionario.setDataNascimento(datanasc);
                
                funcionario = DaoFuncionario.procurar(funcionario);
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
        return funcionario;
    }
    
}
