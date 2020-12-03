/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.entidade;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Sara
 */
@Getter
@Setter
public class Cliente {

    int id;
    private String nome;
    private String cpf;
    private String sexo;
    private String email;
    private String celular;
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    
    public Cliente (int id, String nome, String cpf, String sexo, String email, String celular, String rua, String bairro, String cep, String cidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.email = email;
        this.celular = celular;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }
    
    public Cliente (String nome, String cpf, String sexo, String email, String celular, String rua, String bairro, String cep, String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.email = email;
        this.celular = celular;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }
    
    @Override
    public String toString(){
        return String.format("<br/>Id: "+this.id+"</br>Nome: "+this.nome);
    }
}
