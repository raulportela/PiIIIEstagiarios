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
public abstract class Pessoa {

    protected String nome;
    protected String sobrenome;
    protected long cpf;
    protected Date dataNascimento;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public long getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", getNome(), getSobrenome(),
                getCpf(), getDataNascimento());

    }

}
