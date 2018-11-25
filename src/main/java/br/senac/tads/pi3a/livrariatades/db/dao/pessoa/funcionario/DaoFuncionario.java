/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.pessoa.funcionario;

import br.senac.tads.pi3a.livrariatades.db.dao.contato.DaoContato;
import br.senac.tads.pi3a.livrariatades.db.dao.endereco.DaoEndereco;
import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Raul de Paula
 */
public class DaoFuncionario {

    public static void inserir(Funcionario funcionario, int ultimaChavePessoa)
            throws SQLException, Exception {
        String sql = "INSERT INTO FUNCIONARIO VALUES (0, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ultimaChavePessoa);
            preparedStatement.setInt(2, funcionario.getCodFuncionario());
            preparedStatement.setBoolean(3, funcionario.isDisponivel());
            preparedStatement.setString(4, funcionario.getNomeUsuario());
            preparedStatement.setString(5, funcionario.getHashSenha());
            preparedStatement.setInt(6, funcionario.getNivelFuncao());
            preparedStatement.setString(7, funcionario.getRg());

            DaoContato.inserirContato(funcionario.getContato(), ultimaChavePessoa);
            DaoEndereco.inserir(funcionario.getEndereco(), ultimaChavePessoa);

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

    public static void atualizar(Funcionario funcionario, String cpf)
            throws SQLException, Exception {

        String sql = "UPDATE FUNCIONARIO SET codFuncionario=?"
                + ", disponivel=?, nomeUsuario=?, senha=?, nivelFuncao=?, rg=?\n"
                + "WHERE id = (SELECT ID FROM PESSOA\n"
                + "						WHERE cpf=?);";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, funcionario.getCodFuncionario());
            preparedStatement.setBoolean(2, funcionario.isDisponivel());
            preparedStatement.setString(3, funcionario.getNomeUsuario());
            preparedStatement.setString(4, funcionario.getHashSenha());
            preparedStatement.setInt(5, funcionario.getNivelFuncao());
            preparedStatement.setString(6, funcionario.getRg());
            preparedStatement.setString(7, cpf);

            DaoContato.atualizar(funcionario.getContato(), cpf);
            DaoEndereco.atualizar(funcionario.getEndereco(), cpf);
            
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

    public static void excluir(String cpf)
            throws SQLException, Exception {

        String sql = "UPDATE FUNCIONARIO F\n"
                + "SET F.DISPONIVEL = 0\n"
                + "WHERE F.IDPESSOA = (SELECT ID FROM PESSOA p\n"
                + "							WHERE P.CPF=?);";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf);

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

    public static Funcionario procurar(Funcionario funcionario)
            throws SQLException, Exception {
        String sql = "SELECT * FROM Funcionario"
                + "WHERE idPessoa=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, funcionario.getIdPessoa());

            result = preparedStatement.executeQuery();

            if (result.next()) {
                funcionario.setCodFuncionario(result.getInt("codFuncionario"));
                funcionario.setDisponivel(result.getBoolean("disponivel"));
                funcionario.setNomeUsuario(result.getString("nomeUsuario"));
                funcionario.setSenha(result.getString("senha"));
                funcionario.setNivelFuncao(result.getInt("nivelFuncao"));
                funcionario.setRg(result.getString("rg"));
                
                funcionario.setContato(DaoContato.procurar(funcionario.getIdPessoa()));
                funcionario.setEndereco(DaoEndereco.procurar(funcionario.getIdPessoa()));
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
    
    public static Funcionario procurarPorNomeUsuario (String nomeUsuario)
            throws SQLException, Exception {
        Funcionario funcionario = new Funcionario ();
        
        String sql = "SELECT * FROM Funcionario"
                + "WHERE nomeUsuario=?";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nomeUsuario);

            result = preparedStatement.executeQuery();

            if (result.next()) {
                funcionario.setCodFuncionario(result.getInt("codFuncionario"));
                funcionario.setDisponivel(result.getBoolean("disponivel"));
                funcionario.setNomeUsuario(result.getString("nomeUsuario"));
                funcionario.setSenha(result.getString("senha"));
                funcionario.setNivelFuncao(result.getInt("nivelFuncao"));
                funcionario.setRg(result.getString("rg"));
                
                funcionario.setContato(DaoContato.procurar(funcionario.getIdPessoa()));
                funcionario.setEndereco(DaoEndereco.procurar(funcionario.getIdPessoa()));
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
