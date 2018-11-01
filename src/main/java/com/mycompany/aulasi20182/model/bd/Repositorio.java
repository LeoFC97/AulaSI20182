/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aulasi20182.model.bd;

import com.mycompany.aulasi20182.model.ClienteModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Aluno
 */
@Named
@ApplicationScoped
public class Repositorio implements Serializable {
    private List<ClienteModel> lista;
    
    @PostConstruct
    public void init(){
        lista = new ArrayList<>();
    }
    
    public boolean inserir(ClienteModel c){
        for(ClienteModel cm: lista){
            if(cm.getNome().equals(c.getNome())){
                return false;
            }
        }     
        lista.add(c);
        return true;
    }
    
    public boolean remover(ClienteModel c){
        for(ClienteModel cm:lista){
            if(cm.getNome().equals(c.getNome())){
              lista.remove(cm); 
              return true;
            }
        }
        return false;
    }
    
    public void alterar(ClienteModel c){
        
    }
    

    public List<ClienteModel> getLista() {
        return lista;
    }

    public void setLista(List<ClienteModel> lista) {
        this.lista = lista;
    }
}
