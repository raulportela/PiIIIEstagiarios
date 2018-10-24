/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.model.pessoa;

import java.util.Date;

/**
 *
 * @author Jeferson Nolasco
 */
public abstract class Endereco {

    protected String rua;//60 
    protected int numero;//independente
    protected String bairro;//30
    protected int cep;//oito 
    protected String complemento;//100

    public Endereco(String rua, int numero, String bairro, int cep, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public int getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

}
