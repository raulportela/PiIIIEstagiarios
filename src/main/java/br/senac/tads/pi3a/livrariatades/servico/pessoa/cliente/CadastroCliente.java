/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.pessoa.cliente;

import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.DaoPessoa;
import br.senac.tads.pi3a.livrariatades.model.contato.Contato;
import br.senac.tads.pi3a.livrariatades.model.endereco.Endereco;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import com.oracle.jrockit.jfr.DataType;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.parser.DateParser;

/**
 *
 * @author Jeferson Nolasco
 */
@WebServlet(name = "InclusaoClienteServlet", urlPatterns = {"/cliente/cadastra"})
public class CadastroCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/cliente/cadastraCliente.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente cliente = new Cliente();

        cliente.setDisponivel(true);
        cliente.setNome(request.getParameter("nome"));
        cliente.setSobrenome(request.getParameter("sobrenome"));
        cliente.setCpf(Long.parseLong(request.getParameter("cpf")));
        String datajsp = request.getParameter("nasc");
        
        
            //PRECISA CONFIGURAR A DATA QUE ESTE VINDO COMO STRING DA PAGINA JSP, PARA ENTRAR NO BANCO DE DADOS
            
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy/mm/dd");
//        Date data = null;
//        try {
//            data = formato.parse(datajsp);
//        } catch (ParseException ex) {
//            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
//        }

        Date dateTeste = new Date();

        cliente.setDataNascimento(dateTeste);

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

        cliente.setContato(contato);
        cliente.setEndereco(endereco);

        try {
            DaoPessoa.inserirPessoa(cliente, null);
        } catch (Exception ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/jsp/cliente/cadastraCliente.jsp");
        dispatcher.forward(request, response);

    }

}
