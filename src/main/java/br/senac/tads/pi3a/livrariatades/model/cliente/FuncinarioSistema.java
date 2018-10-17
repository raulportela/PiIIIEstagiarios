/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.Date;

/**
 *
 * @author Jeferson Nolasco
 */
public class FuncinarioSistema extends Funcionario {

    private String usuario;
    private String senha;

    public FuncinarioSistema(String nome, String sobrenome, String rg, String cpf,
            Date dataNascimento, String sexo, String ufNascimento, String estadoNascimento,
            String estadoCivil, String rua, String numero, String bairro, Integer cep,
            String complemento, String uf, String estado, Integer numeroCtps,
            String usuario, String senha) {
        super(nome, sobrenome, rg, cpf, dataNascimento, sexo, ufNascimento, estadoNascimento, estadoCivil, rua, numero, bairro, cep, complemento, uf, estado, numeroCtps);

        this.usuario = usuario;
        this.senha = senha;
    }

}
