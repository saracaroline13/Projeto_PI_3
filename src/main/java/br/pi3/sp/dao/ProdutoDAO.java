/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.dao;

import br.pi3.sp.conexaobd.ConexaoBD;
import br.pi3.sp.entidade.Produto;
import br.pi3.sp.servlet.ServletBD;
import java.io.PrintWriter;
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
public class ProdutoDAO {
    public static List<Produto> getProdutos() {
        List<Produto> listaProdutos = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from produtos";
            PreparedStatement ps = con.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String produto = rs.getString("produto");
                String categoria = rs.getString("categoria");
                String tamanho = rs.getString("tamanho");
                Double valor = rs.getDouble("valor");
                String filial = rs.getString("filial");
                int estoque = rs.getInt("estoque");
                
                
                listaProdutos.add(new Produto(id, produto, categoria, tamanho, valor, filial, estoque)) ;   
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
   return listaProdutos;
    }
    
    public static  void addProduto(Produto produto) throws SQLException, ClassNotFoundException{
        Connection con = ConexaoBD.getConexao();
        String query = "INSERT INTO ROOT.PRODUTOS (PRODUTO, CATEGORIA,TAMANHO, VALOR, FILIAL, ESTOQUE) \n" +
"	VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, produto.getProduto());
        ps.setString(2, produto.getCategoria());
        ps.setString(3, produto.getTamanho());
        ps.setDouble(4, produto.getValor());
        ps.setString(5, produto.getFilial());
        ps.setInt(6, produto.getEstoque());
        
        
        ps.execute();
    }
    
    public static Produto getProdutosId(int id) {
        Produto produto = null;
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from produtos where id =?";
            PreparedStatement ps = con.prepareCall(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //int id = rs.getInt("id");
                String produton = rs.getString("produto");
                String categoria = rs.getString("categoria");
                String tamanho = rs.getString("tamanho");
                double valor = rs.getDouble("valor");
                String filial = rs.getString("filial");
                int estoque = rs.getInt("estoque");
                produto = new Produto(id, produton, categoria, tamanho, valor, filial, estoque);
                 }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
   return produto;
    }
    
    public static List<Produto> getProdutos(String parameter_filial) {
        List<Produto> listaProdutos = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from produtos where filial=?";
            PreparedStatement ps = con.prepareCall(query);
            ps.setString(1,parameter_filial);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String produto = rs.getString("produto");
                String categoria = rs.getString("categoria");
                String tamanho = rs.getString("tamanho");
                Double valor = rs.getDouble("valor");
                String filial = rs.getString("filial");
                int estoque = rs.getInt("estoque");
                
                
                listaProdutos.add(new Produto(id, produto, categoria, tamanho, valor, filial, estoque)) ;   
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
   return listaProdutos;
    }
    
    public static void updateProduto(Produto produto) throws SQLException, ClassNotFoundException{
        Connection con = ConexaoBD.getConexao();
        String query = "update produtos set PRODUTO= ? , CATEGORIA= ?, TAMANHO= ?, VALOR= ?, FILIAL= ?, ESTOQUE= ESTOQUE+ ? WHERE ID= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, produto.getProduto());
        ps.setString(2, produto.getCategoria());
        ps.setString(3, produto.getTamanho());
        ps.setDouble(4, produto.getValor());
        ps.setString(5, produto.getFilial());
        ps.setInt(6, produto.getEstoque());
        ps.setInt(7, produto.getId());
        ps.execute();
    }
    
    public static void deleteProduto(int id) throws ClassNotFoundException, SQLException{
        Connection con = ConexaoBD.getConexao();
        String query = "delete from produtos where ID= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        
        ps.execute();
    }
}
