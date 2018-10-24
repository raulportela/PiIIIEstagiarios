/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.model.contato;

import java.util.Date;

/**
 *
 * @author Jeferson Nolasco
 */
public class Contato {

    protected String email;
    protected long telefone;
    protected long celular;

    public Contato(String email, long telefone, long celular) {
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public long getTelefone() {
        return telefone;
    }

    public long getCelular() {
        return celular;
    }
    
}