/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.pessoa.funcionario;

import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.DaoPessoa;
import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.funcionario.DaoFuncionario;
import br.senac.tads.pi3a.livrariatades.model.contato.Contato;
import br.senac.tads.pi3a.livrariatades.model.endereco.Endereco;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import java.io.IOException;
import java.time.LocalDate;
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
 * @author Jeferson Nolasco
 */
@WebServlet(name = "Alterarfuncinario", urlPatterns = {"/protegido/funcionario/alterar"})
public class AlterarExcluirFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Funcionario funcionario = null;

        if (request.getParameter("opcao") != null & request.getParameter("cpf") != null) {
            String opcao = request.getParameter("opcao");
            String cpf = request.getParameter("cpf");

            switch (opcao) {
                case "1":
                    try {
                        funcionario = DaoPessoa.procurarFuncionario(cpf);
                    } catch (Exception ex) {
                        Logger.getLogger(AlterarExcluirFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.setAttribute("funcionario", funcionario);
                    RequestDispatcher dispatcher = request.getRequestDispatcher(
                            "/WEB-INF/jsp/funcionario/alterarFuncionario.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "2":
                    try {
                        DaoFuncionario.mudarStatus(cpf, "0");
                    } catch (Exception ex) {
                        Logger.getLogger(AlterarExcluirFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    response.sendRedirect(request.getContextPath() + "/protegido/funcionario/listar");
                    break;
                case "3":
                    try {
                        DaoFuncionario.mudarStatus(cpf, "1");
                    } catch (Exception ex) {
                        Logger.getLogger(AlterarExcluirFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    response.sendRedirect(request.getContextPath() + "/protegido/funcionario/listar");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Funcionario funcionario2 = null;
        try {
            funcionario2 = DaoPessoa.procurarFuncionario(request.getParameter("cpf"));
        } catch (Exception ex) {
            Logger.getLogger(AlterarExcluirFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Funcionario funcionario = new Funcionario();
        funcionario.setCodFilial(Integer.parseInt(request.getParameter("filial")));
        funcionario.setDisponivel(funcionario2.isDisponivel());
        funcionario.setNome(request.getParameter("nome"));
        funcionario.setSobrenome(request.getParameter("sobrenome"));
        funcionario.setCpf(request.getParameter("cpf"));
        String data = request.getParameter("nasc");
        String dataS[] = data.split("-");
        LocalDate lData = LocalDate.of(Integer.parseInt(dataS[0]), Integer.parseInt(dataS[1]), Integer.parseInt(dataS[2]));
        funcionario.setDataNascimento(lData);
        funcionario.setRg(request.getParameter("rg"));
        funcionario.setNomeUsuario(request.getParameter("nomeusuario"));
        funcionario.setSenha(request.getParameter("senha"));
        funcionario.setNivelFuncao(request.getParameter("nivelfuncao"));

        Contato contato = new Contato();
        contato.setEmail(request.getParameter("email"));
        if (!request.getParameter("tel").equals("")) {
            contato.setTelefone(Long.parseLong(request.getParameter("tel")));
        }
        if (!request.getParameter("cel").equals("")) {
            contato.setCelular(Long.parseLong(request.getParameter("cel")));
        }
        
        Endereco endereco = new Endereco();
        endereco.setRua(request.getParameter("rua"));
        endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
        endereco.setCep(Integer.parseInt(request.getParameter("cep")));
        endereco.setBairro(request.getParameter("bairro"));
        endereco.setComplemento(request.getParameter("complemento"));

        funcionario.setContato(contato);
        funcionario.setEndereco(endereco);

        try {
            DaoPessoa.atualizar(null, funcionario);
        } catch (Exception ex) {
            Logger.getLogger(AlterarExcluirFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect(request.getContextPath() + "/protegido/funcionario/listar");

    }

}
