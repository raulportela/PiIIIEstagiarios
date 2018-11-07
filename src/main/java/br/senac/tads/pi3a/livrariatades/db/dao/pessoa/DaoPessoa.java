/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.pessoa;

import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.cliente.DaoCliente;
import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.funcionario.DaoFuncionario;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.contato.Contato;
import br.senac.tads.pi3a.livrariatades.model.endereco.Endereco;
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
        //leo é esse trecho 
        Pessoa pessoa = new Pessoa() {
        };
        if (cliente != null) {
            pessoa = cliente;
            isClient = true;
        }
        if (funcionario != null) {
            pessoa = funcionario;
            isClient = false;
        }

        String sql = "INSERT INTO Pessoa VALUES (0, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getSobrenome());
            preparedStatement.setString(3, pessoa.getCpf());
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
            preparedStatement.setString(3, pessoa.getCpf());
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

    public static List<Cliente> listarCliente()
            throws SQLException, Exception {
        String sql = "SELECT * FROM PESSOA P\n"
                + "JOIN CLIENTE C\n"
                + "ON P.ID = C.IDPESSOA\n"
                + "JOIN CONTATO CT\n"
                + "ON P.ID = CT.IDPESSOA\n"
                + "JOIN ENDERECO E\n"
                + "ON P.ID = E.IDPESSOA";

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        Cliente cliente;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            
            result = preparedStatement.executeQuery();

            while (result.next()) {

                cliente = new Cliente();

                cliente.setIdPessoa(result.getInt("id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                cliente.setCpf(result.getString("cpf"));
                Timestamp t = result.getTimestamp("dataNascimento");
                Date datanasc = t;
                cliente.setDataNascimento(datanasc);

                cliente.setCodCliente(result.getInt("codCliente"));
                cliente.setDisponivel(result.getBoolean("disponivel"));
                cliente.setTotalCompras(result.getInt("totalCompras"));

                Contato contato = new Contato();
                contato.setEmail(result.getString("email"));
                contato.setTelefone(result.getLong("telefone"));
                contato.setCelular(result.getLong("celular"));
                cliente.setContato(contato);

                Endereco endereco = new Endereco();
                endereco.setRua(result.getString("rua"));
                endereco.setNumero(result.getInt("numero"));
                endereco.setBairro(result.getString("bairro"));
                endereco.setCep(result.getInt("cep"));
                endereco.setComplemento(result.getString("complemento"));

                cliente.setEndereco(endereco);

                listaClientes.add(cliente);
            }
            return listaClientes;
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

    }

    public static List<Funcionario> listarFuncionario()
            throws SQLException, Exception {
        String sql = "SELECT * FROM PESSOA P\n"
                + "JOIN FUNCIONARIO C\n"
                + "ON P.ID = C.IDPESSOA\n"
                + "JOIN CONTATO CT\n"
                + "ON P.ID = CT.IDPESSOA\n"
                + "JOIN ENDERECO E\n"
                + "ON P.ID = E.IDPESSOA;";

        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        Funcionario funcionario;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();

            while (result.next()) {

                funcionario = new Funcionario();

                funcionario.setIdPessoa(result.getInt("id"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setSobrenome(result.getString("sobrenome"));
                funcionario.setCpf(result.getString("cpf"));
                Timestamp t = result.getTimestamp("dataNascimento");
                Date datanasc = t;
                funcionario.setDataNascimento(datanasc);

                funcionario.setCodFuncionario(result.getInt("codFuncionario"));
                funcionario.setDisponivel(result.getBoolean("disponivel"));
                funcionario.setNomeUsuario(result.getString("nomeUsuario"));
                int senha = result.getInt("senha");
                funcionario.setSenha("" + senha);
                funcionario.setNivelFuncao(result.getInt("nivelFuncao"));
                funcionario.setRg(result.getString("rg"));

                Contato contato = new Contato();
                contato.setEmail(result.getString("email"));
                contato.setTelefone(result.getLong("telefone"));
                contato.setCelular(result.getLong("celular"));
                funcionario.setContato(contato);

                Endereco endereco = new Endereco();
                endereco.setRua(result.getString("rua"));
                endereco.setNumero(result.getInt("numero"));
                endereco.setBairro(result.getString("bairro"));
                endereco.setCep(result.getInt("cep"));
                endereco.setComplemento(result.getString("complemento"));

                funcionario.setEndereco(endereco);

                listaFuncionarios.add(funcionario);
            }
            return listaFuncionarios;
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
    }

    public static Cliente procurarCliente(String cpf)
            throws SQLException, Exception {
        String sql = "SELECT * FROM PESSOA P\n"
                + "JOIN CLIENTE C\n"
                + "ON P.ID = C.IDPESSOA\n"
                + "JOIN CONTATO CT\n"
                + "ON P.ID = CT.IDPESSOA\n"
                + "JOIN ENDERECO E\n"
                + "ON P.ID = E.IDPESSOA\n"
                + "WHERE P.CPF = ?";

        Cliente cliente = new Cliente();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf);

            result = preparedStatement.executeQuery();

            if (result.next()) {

                cliente = new Cliente();

                cliente.setIdPessoa(result.getInt("id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                cliente.setCpf(result.getString("cpf"));
                Timestamp t = result.getTimestamp("dataNascimento");
                Date datanasc = t;
                cliente.setDataNascimento(datanasc);

                cliente.setCodCliente(result.getInt("codCliente"));
                cliente.setDisponivel(result.getBoolean("disponivel"));
                cliente.setTotalCompras(result.getInt("totalCompras"));

                Contato contato = new Contato();
                contato.setEmail(result.getString("email"));
                contato.setTelefone(result.getLong("telefone"));
                contato.setCelular(result.getLong("celular"));
                cliente.setContato(contato);

                Endereco endereco = new Endereco();
                endereco.setRua(result.getString("rua"));
                endereco.setNumero(result.getInt("numero"));
                endereco.setBairro(result.getString("bairro"));
                endereco.setCep(result.getInt("cep"));
                endereco.setComplemento(result.getString("complemento"));

                cliente.setEndereco(endereco);

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
        String sql = "SELECT * FROM PESSOA P\n"
                + "JOIN FUNCIONARIO C\n"
                + "ON P.ID = C.IDPESSOA\n"
                + "JOIN CONTATO CT\n"
                + "ON P.ID = CT.IDPESSOA\n"
                + "JOIN ENDERECO E\n"
                + "ON P.ID = E.IDPESSOA\n"
                + "where P.CPF = ?";

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
                funcionario = new Funcionario();

                funcionario.setIdPessoa(result.getInt("id"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setSobrenome(result.getString("sobrenome"));
                funcionario.setCpf(result.getString("cpf"));
                Timestamp t = result.getTimestamp("dataNascimento");
                Date datanasc = t;
                funcionario.setDataNascimento(datanasc);

                funcionario.setCodFuncionario(result.getInt("codFuncionario"));
                funcionario.setDisponivel(result.getBoolean("disponivel"));
                funcionario.setNomeUsuario(result.getString("nomeUsuario"));
                int senha = result.getInt("senha");
                funcionario.setSenha("" + senha);
                funcionario.setNivelFuncao(result.getInt("nivelFuncao"));
                funcionario.setRg(result.getString("rg"));

                Contato contato = new Contato();
                contato.setEmail(result.getString("email"));
                contato.setTelefone(result.getLong("telefone"));
                contato.setCelular(result.getLong("celular"));
                funcionario.setContato(contato);

                Endereco endereco = new Endereco();
                endereco.setRua(result.getString("rua"));
                endereco.setNumero(result.getInt("numero"));
                endereco.setBairro(result.getString("bairro"));
                endereco.setCep(result.getInt("cep"));
                endereco.setComplemento(result.getString("complemento"));

                funcionario.setEndereco(endereco);

                return funcionario;
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
        return null;
    }

}
