/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aulasi20182.bean;

import com.mycompany.aulasi20182.model.ClienteModel;
import com.mycompany.aulasi20182.model.bd.Repositorio;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class listarClientesBean implements Serializable {
    private ClienteModel clienteSelecionado;
    
    @Inject
    private Repositorio repo;
    
    public void excluir(){
        if(repo.remover(clienteSelecionado)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão realizada",""));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro na exclusão",""));
        }
    }

    public Repositorio getRepo() {
        return repo;
    }

    public void setRepo(Repositorio repo) {
        this.repo = repo;
    }

    public ClienteModel getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(ClienteModel clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }
    
}
