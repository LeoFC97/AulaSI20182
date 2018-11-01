package com.mycompany.aulasi20182.bean;

import com.mycompany.aulasi20182.model.ClienteModel;
import com.mycompany.aulasi20182.model.bd.Repositorio;
import java.io.Serializable;
import static java.time.Clock.system;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named     //para a classe ser visualizada  gerenciada pelo jsf
@ViewScoped
public class CadastrarClienteBean implements Serializable {
    private UIComponent nomeComp;
    private String nome, email, tel, sexo, escolaridade;
    
    public void verificarNome(){
        System.out.println("entrou na funcao");
        for(ClienteModel cm: repo.getLista()){
            if(cm.getNome().equals(nome))
            {
                FacesContext.getCurrentInstance()
                            .addMessage(nomeComp.getClientId(),
                                    new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "FALHA!",
                                    "NOME JA EXISTE!"));
                nome="";
            }
        }    
    }
    
    public UIComponent getNomeComp()
    {
        return nomeComp;
    }
     public void setNomeComp(UIComponent nomeComp)
    {
        this.nomeComp=nomeComp;
    }
    
    
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Inject
    private Repositorio repo;

    public String salvar() {
        ClienteModel c = new ClienteModel();
        c.setNome(nome);
        c.setEmail(email);
        c.setTel(tel);
        c.setSexo(sexo);
        c.setEscolaridade(escolaridade);

        if (repo.inserir(c)==true){
          
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Cadastro Realizado!");
            
            FacesContext.getCurrentInstance()
                    .addMessage(null,msg );
            return "listarClientes?faces-redirect = true";
        }else{
            
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Falha!", "Cadastro Não Realizado!");
            
            FacesContext.getCurrentInstance()
                    .addMessage(null,msg );  
            return null;
        }
    }
}
