/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.validador.pessoa;

import br.senac.tads.pi3a.livrariatades.model.contato.Contato;
import br.senac.tads.pi3a.livrariatades.model.endereco.Endereco;
import br.senac.tads.pi3a.livrariatades.model.pessoa.Pessoa;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import br.senac.tads.pi3a.livrariatades.validador.ValidadorCPF;
import br.senac.tads.pi3a.livrariatades.validador.pessoa.cliente.ValidadorCliente;
import br.senac.tads.pi3a.livrariatades.validador.pessoa.funcionario.ValidadorFuncionario;

/**
 *
 * @author Maia
 */
public class ValidadorPessoa {
    
    public static String validar (Pessoa pessoa, Cliente cliente, Funcionario funcionario,
            Contato contato, Endereco endereco){
        
        String mensagemErro = "Informar Campos Obrigatórios";
        boolean valido = true, validoCPF; 
        String validoCliente, validoFuncionario;
        
        if (pessoa == null) {
            mensagemErro += "Não foi informado um Cliente";
            return mensagemErro;
        }
        
        if (pessoa.getNome().equals("") || pessoa.getNome() == null) {
            mensagemErro += "\nNome.";
            valido = false;
        } else if (pessoa.getNome().length() > 20) {
            mensagemErro += "Nome excede limite máximo. 20 caracteres.";
            valido = false;
        }
        
        if (pessoa.getSobrenome().equals("") || pessoa.getSobrenome() == null) {
            mensagemErro += "\nSobrenome.";
            valido = false;
        } else if (pessoa.getSobrenome().length() > 60) {
            mensagemErro += "\nSobrenome excede limite máximo. 60 caracteres.";
            valido = false;
        }
        
        validoCPF = ValidadorCPF.validadar(Long.toString(pessoa.getCpf()));
        
        if (Long.toString(pessoa.getCpf()).equals("") || Long.toString(pessoa.getCpf()) == null) {
            mensagemErro += "\nCPF.";
            valido = false;
        } else if (Long.toString(pessoa.getCpf()).length() > 11) {
            mensagemErro += "\nCPF excede limite máximo. 11 caracteres.";
            valido = false;
        } else if (validoCPF == false) {
            mensagemErro += "\nCPF inválido.";
            valido = false;
        }
        
        //FALTA VALIDAR DATA DE NASCIIMENTO
        
        if (Integer.toString(cliente.getCodCliente()) != null || cliente.getCodCliente() != 0) {
            validoCliente = ValidadorCliente.validar(cliente, contato, endereco);
            if (validoCliente != null) {
                mensagemErro += validoCliente;
                valido = false;
            }
        } else if (Integer.toString(funcionario.getCodFuncionario()) != null || funcionario.getCodFuncionario() != 0) {
            validoFuncionario = ValidadorFuncionario.validar(funcionario, contato, endereco);
            if (validoFuncionario != null) {
                mensagemErro += validoFuncionario;
                valido = false;
            }
        }
        
        if (valido == false) {
            return mensagemErro;
        } else {
            return null;
        }
    }
}
