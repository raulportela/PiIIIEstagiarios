/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.validador.pessoa.funcionario;

import br.senac.tads.pi3a.livrariatades.model.contato.Contato;
import br.senac.tads.pi3a.livrariatades.model.endereco.Endereco;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import br.senac.tads.pi3a.livrariatades.validador.contato.ValidadorContato;
import br.senac.tads.pi3a.livrariatades.validador.endereco.ValidadorEndereco;

/**
 *
 * @author Raul de Paula
 */
public class ValidadorFuncionario {

    public static String validar(Funcionario funcionario, Contato contato, Endereco endereco) {
        String mensagemErro = "Informar Campos Obrigatórios: ";
        String validoContato, validoEndereco;
        boolean valido = true;

        if (funcionario == null) {
            mensagemErro += "\nNão foi informado um Funcionario";
            return mensagemErro;
        }

        if (funcionario.getNomeUsuario() == null || "".equals(funcionario.getNomeUsuario())) {
            mensagemErro += "\nNome de usuário";
            valido = false;
        } else if (funcionario.getNomeUsuario().length() > 20) {
            mensagemErro += "\nNome excede o limite. 20 caracteres";
            valido = false;
        }

        if (funcionario.getSenha() == null || "".equals(funcionario.getSenha())) {
            mensagemErro += "\nSenha";
            valido = false;
        } else if (funcionario.getSenha().length() < 6) {
            mensagemErro += "\nSenha deve possuir no mínimo 6 caracteres";
            valido = false;
        }

        if (funcionario.getRg() == null) {
            mensagemErro += "\nRG";
            valido = false;
        } else if (funcionario.getRg().length() > 20) {
            mensagemErro += "\nRG excede o limite. 20 caracteres";
            valido = false;
        }

        validoContato = ValidadorContato.validar(contato);
        validoEndereco = ValidadorEndereco.validar(endereco);

        if (valido == false && validoContato != null && validoEndereco != null) {
            return mensagemErro += validoContato + validoEndereco;
        } else {
            return null;
        }
    }
}
