/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.servlet;

import br.pi3.sp.dao.FuncionarioDAO;
import br.pi3.sp.entidade.Funcionario;
import br.pi3.sp.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus
 */
public class CadastrarFuncionario extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filial = request.getParameter("filial");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");
        String data_nasc = request.getParameter("data_nasc");
        String estado_civil = request.getParameter("estado_civil");
        String	cargo = request.getParameter("cargo");
        double salario =Double.parseDouble(request.getParameter("salario")) ;
        String email = request.getParameter("email");
        String contato = request.getParameter("contato");
        String rua = request.getParameter("rua");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
         
        
        Funcionario funcionario = new Funcionario( filial, nome, cpf, sexo, data_nasc, estado_civil, cargo, salario, email, contato, rua, bairro, cep, cidade);
        try {
            FuncionarioDAO.addFuncionario(funcionario);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
          
        }



}
}