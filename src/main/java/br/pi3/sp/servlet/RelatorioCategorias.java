/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.servlet;

import br.pi3.sp.dao.RelatorioDAO;
import br.pi3.sp.entidade.Venda;
import java.io.IOException;
import java.io.PrintWriter;
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
public class RelatorioCategorias extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String datade = request.getParameter("de");
        String dataate = request.getParameter("ate");
        String filial = request.getParameter("filial");
        
        List<Venda> listaVendass = RelatorioDAO.getCategoriasporPeriodo(datade, dataate, filial);
        request.setAttribute("listaVendass", listaVendass);//adicionei no request um atributo a mais que a o select que vem alista de clientes do banco
        
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/protegido/listaRelatorioCategorias.jsp");// redirecono a lista para a lista de Vendas
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
