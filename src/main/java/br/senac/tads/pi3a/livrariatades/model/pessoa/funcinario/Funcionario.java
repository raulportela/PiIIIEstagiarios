/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario;

import br.senac.tads.pi3a.livrariatades.model.pessoa.Pessoa;
import java.util.Date;

/**
 *
 * @author Jeferson Nolasco
 */
public class Funcionario extends Pessoa {
    private String ufNascimento;
    private String estadoNascimento;
    private String estadoCivil;
    private String rua;
    private String numero;
    private String bairro;
    private Integer cep;
    private String complemento;
    private String uf;
    private String estado;
    private Integer numeroCtps;

    public Funcionario(String nome, String sobrenome, String rg, String cpf, Date dataNascimento, String sexo,
    String ufNascimento, String estadoNascimento, String estadoCivil,
            String rua, String numero, String bairro, Integer cep, String complemento,
            String uf, String estado, Integer numeroCtps) {
        super(nome, sobrenome, rg, cpf, dataNascimento, sexo);
        
        this.ufNascimento = ufNascimento;
        this.estadoNascimento = estadoNascimento;
        this.estadoCivil = estadoCivil;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
        this.uf = uf;
        this.estado = estado;
        this.numeroCtps = numeroCtps;
       
    }

    public String getUfNascimento() {
        return ufNascimento;
    }

    public void setUfNascimento(String ufNascimento) {
        this.ufNascimento = ufNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumeroCtps() {
        return numeroCtps;
    }

    public void setNumeroCtps(Integer numeroCtps) {
        this.numeroCtps = numeroCtps;
    }
    
}
