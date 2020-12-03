/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.dao;

import br.pi3.sp.conexaobd.ConexaoBD;
import br.pi3.sp.entidade.Funcionario;
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
public class FuncionarioDAO {
    public static List<Funcionario> getFuncionarios() {
        List<Funcionario> listaFuncionarios = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from funcionarios";
            PreparedStatement ps = con.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String filial = rs.getString("filial");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String sexo = rs.getString("sexo");
                String data_nasc = rs.getString("data_nasc");
                String estado_civil = rs.getString("estado_civil");
                String cargo = rs.getString("cargo");
                Double salario = rs.getDouble("salario");
                String email = rs.getString("email");
                String contato = rs.getString("contato");
                String rua = rs.getString("rua");
                String bairro = rs.getString("bairro");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                listaFuncionarios.add(new Funcionario(id, filial, nome, cpf, sexo, data_nasc, estado_civil, cargo, salario, email, contato, rua, bairro, cep, cidade)) ;   
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
   return listaFuncionarios;
    }
    
    public static  void addFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        Connection con = ConexaoBD.getConexao();
        String query = "INSERT INTO ROOT.FUNCIONARIOS (FILIAL, NOME, CPF, SEXO, DATA_NASC, ESTADO_CIVIL, CARGO, SALARIO, EMAIL, CONTATO, RUA, BAIRRO, CEP, CIDADE) \n" +
"	VALUES (?, ?, ?, ?, ?, ?, ?,? , ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, funcionario.getFilial());
        ps.setString(2, funcionario.getNome());
        ps.setString(3, funcionario.getCpf());
        ps.setString(4, funcionario.getSexo());
        ps.setString(5, funcionario.getData_nasc());
        ps.setString(6, funcionario.getEstado_civil());
        ps.setString(7, funcionario.getCargo());
        ps.setDouble(8, funcionario.getSalario());
        ps.setString(9, funcionario.getEmail());
        ps.setString(10, funcionario.getContato());
        ps.setString(11, funcionario.getRua());
        ps.setString(12, funcionario.getBairro());
        ps.setString(13, funcionario.getCep());
        ps.setString(14, funcionario.getCidade());
        
        ps.execute();
    }
    
    public static Funcionario getFuncionariosId(int id) {
        Funcionario funcionario = null;
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from funcionarios where id =?";
            PreparedStatement ps = con.prepareCall(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //int id = rs.getInt("id");
                String filial = rs.getString("filial");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String sexo = rs.getString("sexo");
                String data_nasc = rs.getString("data_nasc");
                String estado_civil = rs.getString("estado_civil");
                String cargo = rs.getString("cargo");
                double salario = rs.getDouble("salario");
                String email = rs.getString("email");
                String contato = rs.getString("contato");
                String rua = rs.getString("rua");
                String bairro = rs.getString("bairro");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                funcionario = new Funcionario(id, filial, nome, cpf, sexo, data_nasc, estado_civil, cargo, salario, email, contato, rua, bairro, cep, cidade);
                  }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
   return funcionario;
    }
    
    public static void updateFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        Connection con = ConexaoBD.getConexao();
        String query = "update funcionarios set FILIAL= ? , NOME= ?, CPF= ?, SEXO= ?, DATA_NASC= ?, ESTADO_CIVIL= ?, CARGO= ?, SALARIO= ?, EMAIL= ?, CONTATO= ?, RUA= ?, BAIRRO= ?, CEP= ?, CIDADE= ? WHERE ID= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, funcionario.getFilial());
        ps.setString(2, funcionario.getNome());
        ps.setString(3, funcionario.getCpf());
        ps.setString(4, funcionario.getSexo());
        ps.setString(5, funcionario.getData_nasc());
        ps.setString(6, funcionario.getEstado_civil());
        ps.setString(7, funcionario.getCargo());
        ps.setDouble(8, funcionario.getSalario());
        ps.setString(9, funcionario.getEmail());
        ps.setString(10, funcionario.getContato());
        ps.setString(11, funcionario.getRua());
        ps.setString(12, funcionario.getBairro());
        ps.setString(13, funcionario.getCep());
        ps.setString(14, funcionario.getCidade());
        ps.setInt(15, funcionario.getId());
        ps.execute();
    }
    
    public static void deleteFuncionario(int id) throws ClassNotFoundException, SQLException{
        Connection con = ConexaoBD.getConexao();
        String query = "delete from funcionarios where ID= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        
        ps.execute();
    }
}
