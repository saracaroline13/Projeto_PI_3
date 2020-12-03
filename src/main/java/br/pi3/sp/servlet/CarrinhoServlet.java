/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.servlet;

import br.pi3.sp.dao.ProdutoDAO;
import br.pi3.sp.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matheus
 */
public class CarrinhoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Produto produto = ProdutoDAO.getProdutosId(id);
        HttpSession sessao = request.getSession();
        
        List<Produto> listaProdutos = null;
        if(sessao.getAttribute("listaProdutos")==null){
            listaProdutos = new ArrayList<>();
        }
        else{
            listaProdutos = (List<Produto>) sessao.getAttribute("listaProdutos");
        }
        
            listaProdutos.add(produto);
       
        
        sessao.setAttribute("listaProdutos", listaProdutos);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
