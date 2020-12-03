/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.servlet;

import br.pi3.sp.dao.FuncionarioDAO;
import br.pi3.sp.entidade.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus
 */
public class ListarFuncionarios extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//requeste que vem do menu
            throws ServletException, IOException {
        List<Funcionario> listaFuncionarios = FuncionarioDAO.getFuncionarios();
        request.setAttribute("listaFuncionarios", listaFuncionarios);//adicionei no request um atributo a mais que a o select que vem alista de clientes do banco
        
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/protegido/listaFuncionarios.jsp");// redirecono a lista para a lista de Funcionarios
        requestDispatcher.forward(request, response);
    }

}