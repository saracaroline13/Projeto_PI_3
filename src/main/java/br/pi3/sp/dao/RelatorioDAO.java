/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.dao;

import br.pi3.sp.conexaobd.ConexaoBD;
import br.pi3.sp.entidade.Venda;
import br.pi3.sp.servlet.ServletBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class RelatorioDAO {
     public static List<Venda> getVendasporPeriodo(String datade, String dataate, String filial) {
        List<Venda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select vendas.filial, id_venda, funcionarios.nome as nome_funcionario,cpf_cliente, clientes.NOME as nome_cliente, data_venda, tipo_pagemento, total_venda from vendas\n" +
"                   inner join clientes on vendas.cpf_cliente = clientes.cpf \n" +
"                    inner join funcionarios on vendas.id_funcionario = funcionarios.id\n" +
"                    WHERE data_venda \n" +
"                    BETWEEN ? AND ? AND vendas.filial= ?";
            PreparedStatement ps = con.prepareCall(query);
            ps.setString(1,datade);
            ps.setString(2,dataate);
            ps.setString(3, filial);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_venda = rs.getInt("id_venda");
                String filiall = rs.getString("filial");
                String funcionario= rs.getString("nome_funcionario");
                String cpf_cliente = rs.getString("cpf_cliente");
                String nome_cliente = rs.getString("nome_cliente");
                String data_venda = rs.getString("data_venda");
                String tipo_pagamento = rs.getString("tipo_pagemento");
                double total_venda = rs.getDouble("total_venda");
                listaVendas.add(new Venda(id_venda, filiall, data_venda, funcionario, cpf_cliente, nome_cliente, tipo_pagamento, total_venda) ) ;   
            
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
   return listaVendas;
    }
     
     public static List<Venda> getCategoriasporPeriodo(String datade, String dataate, String filial) {
        List<Venda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select  itens_vendas.ID_VENDA,vendas.filial, itens_vendas.ID_PRODUTO, itens_vendas.NOME, produtos.TAMANHO, itens_vendas.CATEGORIA, itens_vendas.preco_pago, itens_vendas.DATA_VENDA\n" +
"from itens_vendas\n" +
"inner join vendas on itens_vendas.id_venda = vendas.id_venda \n" +
"inner join produtos on itens_vendas.id_produto = produtos.id\n" +
"WHERE itens_vendas.data_venda \n" +
"BETWEEN ? AND ? and  vendas.filial=?";
            PreparedStatement ps = con.prepareCall(query);
            ps.setString(1,datade);
            ps.setString(2,dataate);
            ps.setString(3, filial);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_venda = rs.getInt("id_venda");
                String filiall = rs.getString("filial");
                int id_produto= rs.getInt("id_produto");
                String nome_produto = rs.getString("nome");
                String tamanho_produto = rs.getString("tamanho");
                String categoria_produto = rs.getString("categoria");
                double preco_pago = rs.getDouble("preco_pago");
                String data_venda = rs.getString("data_venda");
                listaVendas.add(new Venda(id_venda, filiall, data_venda, id_produto, nome_produto, tamanho_produto, categoria_produto, preco_pago));   
            
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
   return listaVendas;
    }
     
     public static List<Venda> getClientesporPeriodo(String datade, String dataate, String cpf) {
        List<Venda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select  vendas.cpf_cliente, itens_vendas.ID_VENDA,vendas.filial, itens_vendas.ID_PRODUTO, itens_vendas.NOME, produtos.TAMANHO, itens_vendas.CATEGORIA, itens_vendas.preco_pago, itens_vendas.DATA_VENDA \n" +
"from itens_vendas\n" +
"inner join vendas on itens_vendas.id_venda = vendas.id_venda \n" +
"inner join produtos on itens_vendas.id_produto = produtos.id\n" +
"WHERE itens_vendas.data_venda \n" +
"BETWEEN ? AND ? and  vendas.cpf_cliente= ?";
            PreparedStatement ps = con.prepareCall(query);
            ps.setString(1,datade);
            ps.setString(2,dataate);
            ps.setString(3, cpf);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cpf_cliente = rs.getString("cpf_cliente");
                int id_venda = rs.getInt("id_venda");
                String filiall = rs.getString("filial");
                int id_produto= rs.getInt("id_produto");
                String nome_produto = rs.getString("nome");
                String tamanho_produto = rs.getString("tamanho");
                String categoria_produto = rs.getString("categoria");
                double preco_pago = rs.getDouble("preco_pago");
                String data_venda = rs.getString("data_venda");
                listaVendas.add(new Venda(cpf_cliente, id_venda, filiall, data_venda, id_produto, nome_produto, tamanho_produto, categoria_produto, preco_pago));   
            
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
   return listaVendas;
    }
     
     
     
}
