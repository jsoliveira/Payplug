
package br.com.payplug.bean;

import br.com.payplug.dao.OperacaoDao;
import br.com.payplug.dao.TitulosDao;
import br.com.payplug.dao.TransacoesDao;
import br.com.payplug.model.Operacoes;
import br.com.payplug.model.Titulos;
import br.com.payplug.model.Transacoes;
import br.com.payplug.tools.Mensagem;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jnakamura
 */
@Named
@SessionScoped
public class TitulosBean implements Serializable{


    @Inject
    private TitulosDao tDao;
    
    @Inject
    private TransacoesDao transacoesDao;
    
    @Inject
    private OperacaoDao operacoesDao;
    
    @Inject
    private Mensagem msg;
    
    private List<Titulos> titulos;
    
    private List<Transacoes> transacoes;
    
    private Operacoes operacao;
    
    private Titulos titulo;
    
    private Date dtInicio;
    
    private Date dtFim;
    
    
    public void calcularTitulos(){
        validarDatas();
        
        this.operacao = operacoesDao.getOperacaoPorCodigo(3);
        
        this.transacoes = transacoesDao.getTransacaoPorOperacoes(dtInicio, dtFim, 3);
        
        
        
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(this.operacao.toString());
        System.out.println(this.transacoes.toString());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        
        
    }
    
    private void validarDatas(){
        if (dtInicio == null) {

            msg.error("Infome a data de inicio");
            return;
        }

        if (dtInicio == null) {

            msg.error("Infome a data de fim");
            return;
        }

    }
    
    public void buscarPorPeriodo() {
        try {
            if (dtInicio == null) {
                
                msg.error("Infome a data de inicio");
                return;
            }
            
            if (dtInicio == null) {
                
                msg.error("Infome a data de fim");
                return;
            }
        
            
            this.titulos = tDao.getTitulos(dtInicio, dtFim);
        } catch (Exception ex) {
            
            msg.error("Erro ao consultar transações");
        }
    }
    
    public List<Titulos> getTitulos() {
        return titulos;
    }
    
    public void setTitulos(List<Titulos> titulos) {
        this.titulos = titulos;
    }
    
    public Titulos getTitulo() {
        return titulo;
    }
    
    public void setTitulo(Titulos titulo) {
        this.titulo = titulo;
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

    
}
