/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi3.sp.entidade;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Sara
 */

@Getter
@Setter
public class Usuario {
    
    private String nome;
    private String login;
    private String senha;
    private String perfil;
    
    public boolean isGerente(){
        return this.perfil.equalsIgnoreCase("gerente");
    }
    
    public boolean isVendedor(){
        return this.perfil.equalsIgnoreCase("vendedor");
    }
    
    public boolean isEstoquista(){
        return this.perfil.equalsIgnoreCase("estoquista");
    }
    
    public boolean isRh(){
        return this.perfil.equalsIgnoreCase("rh");
    }
    
}
