/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;
import java.util.Date;

/**
 *
 * @author Jeferson Nolasco
 */
public abstract class Pessoa {

    private final String nome;
    private final String sobrenome;
    private final String rg;
    private final String cpf;
    private final Date dataNascimento;
    private final String sexo;

    public Pessoa(String nome, String sobrenome, String rg, String cpf,
            Date dataNascimento, String sexo) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;

    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }
    
    @Override
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%s,", getNome(),getSobrenome(),getRg(),
                getCpf(),getDataNascimento(), getSexo());
        
    }

}
