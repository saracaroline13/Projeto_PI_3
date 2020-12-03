/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.conexaobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class ConexaoBD {
    
    static{
        try {  
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  public static Connection  getConexao() throws ClassNotFoundException, SQLException{  
    
    String url ="jdbc:derby://localhost:1527/ShopSports";
    String user = "root" ;
    String password = "root";
    return DriverManager.getConnection(url, user, password);
    
}
  
}
