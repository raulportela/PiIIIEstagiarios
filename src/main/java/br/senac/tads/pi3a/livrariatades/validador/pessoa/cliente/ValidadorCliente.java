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

    public static String validar(Cliente cliente) {
        String mensagemErro = "Informar Campos Obrigatórios: ";
        boolean valido = true;
        String validoContato, validoEndereco;

        if (cliente == null) {
            mensagemErro += "Não foi informado um Cliente";
            return mensagemErro;
        }
        
        Contato contato = new Contato();
        contato.setCelular(cliente.getContato().getCelular());
        contato.setEmail(cliente.getContato().getEmail());
        contato.setTelefone(cliente.getContato().getTelefone());
        validoContato = ValidadorContato.validar(contato);

        Endereco endereco = new Endereco();
        endereco.setBairro(cliente.getEndereco().getBairro());
        endereco.setCep(cliente.getEndereco().getCep());
        endereco.setComplemento(cliente.getEndereco().getComplemento());
        endereco.setNumero(cliente.getEndereco().getNumero());
        endereco.setRua(cliente.getEndereco().getRua());
        validoEndereco = ValidadorEndereco.validar(endereco);

        if (validoContato != null) {
            mensagemErro += validoContato;
            valido = false;
        }
        if (validoEndereco != null) {
            mensagemErro += validoEndereco;
            valido = false;
        }

        if (valido == false) {
            return mensagemErro;
        } else {
            return null;
        }
    }
}
