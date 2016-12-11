package br.com.payplug.bean;

import br.com.payplug.dao.UsuariosDao;
import br.com.payplug.model.Usuarios;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Leticia
 */

@SessionScoped
@Named
public class RelatorioFechamentoBean implements Serializable{
    
    
    @Inject
    private UsuariosDao uDao;
        
    private Date dtInicio;

    private Date dtFim;
    
    private Usuarios usuarios;
    
    
    private List<Usuarios> empresas;

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuarios> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Usuarios> empresas) {
        this.empresas = empresas;
    }


    
    
    
    
}
