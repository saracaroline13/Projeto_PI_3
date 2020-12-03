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
public class Venda {
    private int id_venda;
    private String filial;
    private String data_venda;
    private int id_produto;
    private String nome_produto;
    private String tamanho_produto;
    private String categoria_produto;
    private int id_funcionario;
    private double preco_pago;
    private String nome_funcionario;
    private String cpf_cliente;
    private String nome_cliente;
    private String tipo_pagamento;
    private double total_venda;

    public Venda(int id_venda, String filial, String data_venda, String nome_funcionario, String cpf_cliente, String nome_cliente, String tipo_pagamento, double total_venda) {
        this.id_venda = id_venda;
        this.filial = filial;
        this.data_venda = data_venda;
        this.nome_funcionario = nome_funcionario;
        this.cpf_cliente = cpf_cliente;
        this.nome_cliente = nome_cliente;
        this.tipo_pagamento = tipo_pagamento;
        this.total_venda = total_venda;
    }

    public Venda(String filial, String data_venda, int id_funcionario, String cpf_cliente, String tipo_pagamento,double total_venda) {
        this.filial = filial;
        this.data_venda = data_venda;
        this.id_funcionario = id_funcionario;
        this.cpf_cliente = cpf_cliente;
        this.tipo_pagamento = tipo_pagamento;
        this.total_venda = total_venda;
    }
    
    

    public Venda(int id_venda, String filial, String data_venda, int id_produto, String nome_produto, String tamanho_produto, String categoria_produto, double preco_pago) {
        this.id_venda = id_venda;
        this.filial = filial;
        this.data_venda = data_venda;
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.tamanho_produto = tamanho_produto;
        this.categoria_produto = categoria_produto;
        this.preco_pago = preco_pago;
    }
    
     public Venda(String cpf_cliente, int id_venda, String filial, String data_venda, int id_produto, String nome_produto, String tamanho_produto, String categoria_produto, double preco_pago) {
        this.cpf_cliente = cpf_cliente;
        this.id_venda = id_venda;
        this.filial = filial;
        this.data_venda = data_venda;
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.tamanho_produto = tamanho_produto;
        this.categoria_produto = categoria_produto;
        this.preco_pago = preco_pago;
    }
    
}
