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

    private String email;
    private long telefone;
    private long celular;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public void setCelular(long celular) {
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