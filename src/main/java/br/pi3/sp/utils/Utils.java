/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.utils;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus
 */
public class Utils {
    public static void mostrarTelaErro(Exception ex, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String msgErro = ex.getMessage();//caso de erro pego a mensagem de erro
            request.setAttribute("msgErro",msgErro );//adiciono mais um atributo no request para enviar a tela de erro
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/erro.jsp");// redirecono para atela de erro com o novo atributo (mensagem de erro do banco)
            requestDispatcher.forward(request, response);
    }
    public static void mostrarTelaSucesso(HttpServletResponse response) throws ServletException, IOException{
       response.sendRedirect("sucesso.jsp");
    }
}
