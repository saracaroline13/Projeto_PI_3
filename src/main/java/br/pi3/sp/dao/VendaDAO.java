/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.dao;

import br.pi3.sp.conexaobd.ConexaoBD;
import br.pi3.sp.entidade.Funcionario;
import br.pi3.sp.entidade.Produto;
import br.pi3.sp.entidade.Venda;
import br.pi3.sp.servlet.ServletBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class VendaDAO {
    
    public static int finalizarVenda(Venda venda) throws ClassNotFoundException, SQLException{
        Connection con = ConexaoBD.getConexao();
        String query = "INSERT INTO vendas (filial, id_funcionario, cpf_cliente, data_venda, tipo_pagemento, total_venda) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, venda.getFilial());
        ps.setInt   (2, venda.getId_funcionario());
        ps.setString(3, venda.getCpf_cliente());
        ps.setString(4, venda.getData_venda());
        ps.setString(5, venda.getTipo_pagamento());
        ps.setDouble(6, venda.getTotal_venda());
        
        ps.execute();
        ResultSet rs = ps.getGeneratedKeys();
		int id = 0;
		if(rs.next()){
			id = rs.getInt(1);
		}		
        return id;
    }
    
    public static void cadastraritensvenda(int id_venda,List<Produto> listaProdutos,String data_venda) throws ClassNotFoundException, SQLException{
        Connection con = ConexaoBD.getConexao();
        
        for (Produto p : listaProdutos) {
        String query = "INSERT INTO itens_vendas (id_venda, id_produto, nome, categoria, preco_pago, data_venda) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id_venda);
        ps.setInt(2, p.getId());
        ps.setString(3, p.getProduto());
        ps.setString(4, p.getCategoria());
        ps.setDouble(5,p.getValor());
        ps.setString (6, data_venda);
        
        ps.execute();
        
        ps = con.prepareStatement("update produtos set ESTOQUE= ESTOQUE-1 WHERE ID= ?");
        ps.setInt(1, p.getId());
        ps.execute();
        }
        
    }
    
   
}
