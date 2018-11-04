/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.validador.pessoa.cliente;

import br.senac.tads.pi3a.livrariatades.model.contato.Contato;
import br.senac.tads.pi3a.livrariatades.model.endereco.Endereco;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import br.senac.tads.pi3a.livrariatades.validador.contato.ValidadorContato;
import br.senac.tads.pi3a.livrariatades.validador.endereco.ValidadorEndereco;

/**
 *
 * @author Raul de Paula
 */
public class ValidadorCliente {

    public static String validar(Cliente cliente, Contato contato, Endereco endereco) {
        String mensagemErro = "Informar Campos Obrigatórios: ";
        boolean valido = true;
        String validoContato, validoEndereco;

        if (cliente == null) {
            mensagemErro += "Não foi informado um Cliente";
            return mensagemErro;
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
