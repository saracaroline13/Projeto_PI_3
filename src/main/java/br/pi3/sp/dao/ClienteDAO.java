/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.dao;

import br.pi3.sp.conexaobd.ConexaoBD;
import br.pi3.sp.entidade.Cliente;
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
 * @author Sara
 */

public class ClienteDAO {
    public static List<Cliente> getClientes() {
        List<Cliente> listaClientes = new ArrayList();
        
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from clientes";
            PreparedStatement ps = con.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String sexo = rs.getString("sexo");
                String email = rs.getString("email");
                String celular = rs.getString("celular");
                String rua = rs.getString("rua");
                String bairro = rs.getString("bairro");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                listaClientes.add(new Cliente(id, nome, cpf, sexo, email, celular, rua, bairro, cep, cidade));   
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaClientes;
    }
    
    public static  void addCliente(Cliente cliente) throws SQLException, ClassNotFoundException{
        Connection con = ConexaoBD.getConexao();
        String query = "INSERT INTO ROOT.CLIENTES (NOME, CPF, SEXO, EMAIL, CELULAR, RUA, BAIRRO, CEP, CIDADE) \n" +
"	VALUES (?, ?, ?, ?, ?, ? , ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getSexo());
        ps.setString(4, cliente.getEmail());
        ps.setString(5, cliente.getCelular());
        ps.setString(6, cliente.getRua());
        ps.setString(7, cliente.getBairro());
        ps.setString(8, cliente.getCep());
        ps.setString(9, cliente.getCidade());
        
        ps.execute();
    }
    
    public static Cliente getClientesId(int id) {
        Cliente cliente = null;
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from clientes where id =?";
            PreparedStatement ps = con.prepareCall(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String sexo = rs.getString("sexo");
                String email = rs.getString("email");
                String contato = rs.getString("celular");
                String rua = rs.getString("rua");
                String bairro = rs.getString("bairro");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                cliente = new Cliente(id, nome, cpf, sexo, email, contato, rua, bairro, cep, cidade);
                  }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
   return cliente;
    }
    
    public static void updateCliente(Cliente cliente) throws SQLException, ClassNotFoundException{
        Connection con = ConexaoBD.getConexao();
        String query = "update clientes set NOME= ?, CPF= ?, SEXO= ?, EMAIL= ?, CELULAR= ?, RUA= ?, BAIRRO= ?, CEP= ?, CIDADE= ? WHERE ID= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getSexo());
        ps.setString(4, cliente.getEmail());
        ps.setString(5, cliente.getCelular());
        ps.setString(6, cliente.getRua());
        ps.setString(7, cliente.getBairro());
        ps.setString(8, cliente.getCep());
        ps.setString(9, cliente.getCidade());
        ps.setInt(10, cliente.getId());
        ps.execute();
    }
    
    public static void deleteCliente(int id) throws ClassNotFoundException, SQLException{
        Connection con = ConexaoBD.getConexao();
        String query = "delete from clientes where ID= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        
        ps.execute();
    }
}
