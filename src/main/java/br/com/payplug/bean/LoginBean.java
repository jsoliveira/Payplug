package br.com.payplug.bean;

import br.com.payplug.dao.TitulosDao;
import br.com.payplug.dao.UsuariosDao;
import br.com.payplug.model.Usuarios;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jsoliveira
 */
@Named
@SessionScoped
public class LoginBean implements Serializable{
    
    
    @Inject
    private UsuariosDao uDao;

    private String email;
    private String senha;
    
    private Usuarios usuario;
    
  public void doLogin() {
        try {
            
            ///usuario = uDao.findUser(email, senha);
            usuario = uDao.getById(1);

//            if (usuario == null) {
//
//                FacesContext.getCurrentInstance().addMessage(null,
//                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", "Usuário e/ou Senha incorreto(s)."));
//                return;
//
//            }
           
            FacesContext.getCurrentInstance().getExternalContext().redirect("/PayPlug/interno/index.xhtml");
            

        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", "Erro ao redirecionar página. Consulte o Administrador do sistema."));
        }
    }

    public void doLogout() {
        try {

            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

            FacesContext.getCurrentInstance().getExternalContext().redirect("/PayPlug/login.xhtml");

        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", "Erro ao redirecionar página. Consulte o Administrador do sistema."));
        }
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
     
    
    
    
    
}
