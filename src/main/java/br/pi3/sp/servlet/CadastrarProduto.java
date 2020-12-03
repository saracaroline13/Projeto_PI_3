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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus
 */
public class CadastrarProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("produto");
        String categoria = request.getParameter("categoria");
        String tamanho = request.getParameter("tamanho");
        double valor =Double.parseDouble(request.getParameter("valor")) ;
        int estoque = Integer.parseInt(request.getParameter("estoque"));
        String filial = request.getParameter("filial");
         
        
        Produto produto = new Produto(nome, categoria, tamanho, valor, filial, estoque);
                try {
            ProdutoDAO.addProduto(produto);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
          
        }



}
}
