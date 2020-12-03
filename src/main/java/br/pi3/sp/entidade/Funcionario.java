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
 * @author Matheus
 */

@Getter
@Setter
public class Funcionario {
private int id;
private String filial;
private String nome;
private String cpf;
private String sexo;
private String data_nasc;
private String estado_civil;
private String cargo;
private double salario;
private String email;
private String contato;
private String rua;
private String bairro;
private String cep;
private String cidade;

    public Funcionario(int id, String filial, String nome, String cpf, String sexo, String data_nasc, String estado_civil, String cargo, double salario, String email, String contato, String rua, String bairro, String cep, String cidade) {
        this.id = id;
        this.filial = filial;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
        this.estado_civil = estado_civil;
        this.cargo = cargo;
        this.salario = salario;
        this.email = email;
        this.contato = contato;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    public Funcionario(String filial, String nome, String cpf, String sexo, String data_nasc, String estado_civil, String cargo, double salario, String email, String contato, String rua, String bairro, String cep, String cidade) {
        this.filial = filial;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
        this.estado_civil = estado_civil;
        this.cargo = cargo;
        this.salario = salario;
        this.email = email;
        this.contato = contato;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }
    
    @Override
    public String toString(){
        return String.format("<br/>Id: "+this.id+"<br/>Filial: "+this.filial+"</br>Nome: "+this.nome);
    }

    
    
}
