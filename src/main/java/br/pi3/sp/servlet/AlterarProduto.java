/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.servlet;

import br.pi3.sp.dao.ProdutoDAO;
import br.pi3.sp.entidade.Funcionario;
import br.pi3.sp.entidade.Produto;
import br.pi3.sp.utils.Utils;
import java.io.IOException;
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
public class AlterarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id   = Integer.parseInt(request.getParameter("id"));
        Produto produto = ProdutoDAO.getProdutosId(id);
        request.setAttribute("produto", produto);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/protegido/alterarProduto.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String produton = request.getParameter("produto");
        String categoria = request.getParameter("categoria");
        String tamanho = request.getParameter("tamanho");
        double valor = Double.parseDouble(request.getParameter("valor"));
        String filial = request.getParameter("filial");
        int estoque = Integer.parseInt(request.getParameter("estoque"));
        
        Produto produto = ProdutoDAO.getProdutosId(id);
        
        produto.setProduto(produton);
        produto.setCategoria(categoria);
        produto.setTamanho(tamanho);
        produto.setValor(valor);
        produto.setFilial(filial);
        produto.setEstoque(estoque);
        
        try {
            ProdutoDAO.updateProduto(produto);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(AlterarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlterarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
           
            Utils.mostrarTelaErro(ex, request, response);
        }
    }

    
}
