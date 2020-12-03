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
public class Produto {
    private int id;
    private String produto;
    private String categoria;
    private String tamanho;
    private double valor;
    private String filial;
    private int estoque;
    
    
    public Produto(int id, String produto, String categoria, String tamanho, double valor, String filial, int estoque) {
        this.id = id;
        this.produto = produto;
        this.categoria = categoria;
        this.tamanho = tamanho;
        this.valor = valor;
        this.filial = filial;
        this.estoque = estoque;
    }

    public Produto(String produto, String categoria, String tamanho, double valor,String filial, int estoque) {
        this.produto = produto;
        this.categoria = categoria;
        this.tamanho = tamanho;
        this.valor = valor;
        this.filial = filial;
        this.estoque = estoque;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.id != other.id){
            return false;
        }
        return true;
    }
   
    
    
}
