/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.servlet;

import br.pi3.sp.dao.FuncionarioDAO;
import br.pi3.sp.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ExcluirFuncionario extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idFuncionario"));
        try {
            FuncionarioDAO.deleteFuncionario(id);
            response.getWriter().print(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ExcluirFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            response.getWriter().print(false);
        } 
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
