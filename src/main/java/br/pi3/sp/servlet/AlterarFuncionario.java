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
public class AlterarFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id   = Integer.parseInt(request.getParameter("id"));
        Funcionario funcionario = FuncionarioDAO.getFuncionariosId(id);
        request.setAttribute("funcionario", funcionario);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/protegido/alterarFuncionario.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String filial = request.getParameter("filial");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");
        String data_nasc = request.getParameter("data_nasc");
        String estado_civil = request.getParameter("estado_civil");
        String cargo = request.getParameter("cargo");
        double salario = Double.parseDouble(request.getParameter("salario"));
        String email = request.getParameter("email");
        String contato = request.getParameter("contato");
        String rua = request.getParameter("rua");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        Funcionario funcionario = FuncionarioDAO.getFuncionariosId(id);
        
        funcionario.setFilial(filial);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSexo(sexo);
        funcionario.setData_nasc(data_nasc);
        funcionario.setEstado_civil(estado_civil);
        funcionario.setCargo(cargo);
        funcionario.setSalario(salario);
        funcionario.setEmail(email);
        funcionario.setContato(contato);
        funcionario.setRua(rua);
        funcionario.setBairro(bairro);
        funcionario.setCep(cep);
        funcionario.setCidade(cidade);
        try {
            FuncionarioDAO.updateFuncionario(funcionario);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(AlterarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlterarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
           
            Utils.mostrarTelaErro(ex, request, response);
        }
    }

    

}
