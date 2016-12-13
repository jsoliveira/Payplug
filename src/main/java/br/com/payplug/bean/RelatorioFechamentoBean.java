package br.com.payplug.bean;

import br.com.payplug.dao.TitulosDao;
import br.com.payplug.dao.UsuariosDao;
import br.com.payplug.enuns.OperadoresJPQL;
import br.com.payplug.model.Usuarios;
import br.com.payplug.relatorio.Relatorio;
import br.com.payplug.tools.ConexaoJdbc;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
    
    @Inject
    private TitulosDao tDao;
    
    @Inject
    private TitulosDao titulosDao;
    
    @Inject
    private Relatorio relatorio;
    
    @Inject
    private LoginBean loginBean;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private Date dtInicio;

    private Usuarios empresa;

    private List<SelectItem> empresas;
    

    public void imprimir(){
    
        HashMap<String, Object> params = new HashMap<>();
        params.put("Empresa", empresa.getNome());
        params.put("DataInicio", sdf.format(dtInicio));
        params.put("DataFim", sdf.format(new Date()));
        params.put("Total", tDao.relTotalFechamentoSintetico(dtInicio, empresa.getCpfCnpj()));
                        
        relatorio.getRelatorio("RelatorioFechamentoSintetico.jasper", params, tDao.relFechamentoSintetico(dtInicio, empresa.getCpfCnpj()) );
        ConexaoJdbc.fechar();
        
    }

    

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Usuarios getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Usuarios empresa) {
        this.empresa = empresa;
    }

    public List<SelectItem> getEmpresas() {

        return this.empresas = uDao.getSelectItens("isParceiro", 1, OperadoresJPQL.equals.getOperador(), "nome", Boolean.TRUE);

    }

}
