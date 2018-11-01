/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.validador.pessoa.cliente;

import br.senac.tads.pi3a.livrariatades.model.pessoa.Pessoa;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;

/**
 *
 * @author Raul de Paula
 * @author Leonardo Maia
 */
public class ValidadorCliente {
    public static String validadorCliente (Cliente cliente){
        String mensagemErro = "Informar Campos Obrigatórios: ";
        boolean valido = true;
        
        
        if (cliente == null) {
            mensagemErro += "Não foi informado um Cliente";
            return mensagemErro;
        }
            
        if (valido == false) {
            return mensagemErro;
        } else {
            return null;
        }
    }
}
