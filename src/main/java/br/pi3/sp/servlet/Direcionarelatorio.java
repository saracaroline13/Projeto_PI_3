/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus
 */
public class Direcionarelatorio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tiporelatorio = request.getParameter("tipo_relatorio");
        
        if(tiporelatorio.equals("Vendas")){
            response.sendRedirect("protegido/relatorioVendas.jsp");
        }
        if(tiporelatorio.equals("Categoria")){
            response.sendRedirect("protegido/relatorioCategorias.jsp");
        }
        if(tiporelatorio.equals("Clientes")){
           response.sendRedirect("protegido/relatorioClientes.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
