/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.model.pessoa;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Jeferson Nolasco
 */
public abstract class Pessoa {

    protected String nome;
    protected String sobrenome;
    protected String cpf;
    protected LocalDate dataNascimento;
    protected int codFilial; 

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

     public int getCodFilial() {
        return codFilial;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d", getNome(), getSobrenome(),
                getCpf(), getDataNascimento(), getCodFilial());

    }

}
