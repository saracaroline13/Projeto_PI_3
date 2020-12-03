/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.servlet;

import br.pi3.sp.dao.VendaDAO;
import br.pi3.sp.entidade.Produto;
import br.pi3.sp.entidade.Venda;
import br.pi3.sp.utils.Utils;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 *
 * @author Matheus
 */
public class FinalizarVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        List<Produto> listaProdutos = (List<Produto>) sessao.getAttribute("listaProdutos");
        
        String filial = request.getParameter("filial");
        String datavenda=request.getParameter("data_venda");
        
        
        int id_funcionario=Integer.parseInt(request.getParameter("id_funcionario"));
        String cpf_cliente=request.getParameter("cpf_cliente");
        String tipo_pagamento= request.getParameter("tipopagamento");
        double total_venda=0;
        for (Produto p : listaProdutos) {
        total_venda = total_venda+p.getValor();
        }
       
        Venda venda = new Venda(filial, datavenda, id_funcionario, cpf_cliente, tipo_pagamento, total_venda);
        
        try {
            int id_venda = VendaDAO.finalizarVenda(venda);
            VendaDAO.cadastraritensvenda(id_venda, listaProdutos, datavenda);
            listaProdutos = new ArrayList<>();
            sessao.setAttribute("listaProdutos", listaProdutos);
            response.sendRedirect("sucesso.jsp");
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
          
        }
    }

}
