/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.pessoa.funcionario;

import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.DaoPessoa;
import br.senac.tads.pi3a.livrariatades.model.contato.Contato;
import br.senac.tads.pi3a.livrariatades.model.endereco.Endereco;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raul de Paula
 */
@WebServlet(name = "InclusaoAlterarFuncionario", urlPatterns = {"/funcionario/cadastrar"})
public class CadastrarFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/funcionario/cadastrarFuncionario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Funcionario funcionario = new Funcionario();

        funcionario.setDisponivel(true);
        funcionario.setNome(request.getParameter("nome"));
        funcionario.setSobrenome(request.getParameter("sobrenome"));
        funcionario.setCpf(request.getParameter("cpf"));
        String datajsp = request.getParameter("nasc");
       
        Date dateTeste = new Date();
        funcionario.setDataNascimento(dateTeste);
        funcionario.setRg(request.getParameter("rg"));
        funcionario.setNomeUsuario(request.getParameter("nomeusuario"));
        funcionario.setSenha(request.getParameter("senha"));
        funcionario.setNivelFuncao(Integer.parseInt(request.getParameter("funcao")));
        
        Contato contato = new Contato();
        contato.setEmail(request.getParameter("email"));
        contato.setTelefone(Long.parseLong(request.getParameter("tel")));
        contato.setCelular(Long.parseLong(request.getParameter("cel")));

        Endereco endereco = new Endereco();
        endereco.setRua(request.getParameter("rua"));
        endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
        endereco.setCep(Integer.parseInt(request.getParameter("cep")));
        endereco.setBairro(request.getParameter("bairro"));
        endereco.setComplemento(request.getParameter("complemento"));

        funcionario.setContato(contato);
        funcionario.setEndereco(endereco);

        try {
            DaoPessoa.inserirPessoa(null, funcionario);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        response.sendRedirect(request.getContextPath() + "/funcionario/listar");
    }

}
