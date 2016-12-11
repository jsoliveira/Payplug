package br.com.payplug.bean;

import br.com.payplug.dao.UsuariosDao;
import br.com.payplug.enuns.OperadoresJPQL;
import br.com.payplug.model.Usuarios;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Leticia
 */
@SessionScoped
@Named
public class RelatorioFechamentoBean implements Serializable {

    @Inject
    private UsuariosDao uDao;

    private Date dtInicio;

    private Date dtFim;

    private Usuarios usuario;

    private List<SelectItem> empresas;

    public UsuariosDao getuDao() {
        return uDao;
    }

    public void setuDao(UsuariosDao uDao) {
        this.uDao = uDao;
    }

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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }


    public List<SelectItem> getEmpresas() {

        return this.empresas = uDao.getSelectItens("isParceiro", 1, OperadoresJPQL.equals.getOperador(), "nome", Boolean.TRUE);
     
    }


}
