package br.com.payplug.bean;

import br.com.payplug.dao.TransacoesDao;
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
 * @author jsoliveira
 */
@Named
@SessionScoped
public class TransacoesBean implements Serializable {
    
    @Inject
    private TransacoesDao tDao;
    
    @Inject
    private Mensagem msg;
    
    private List<Transacoes> transacoes;
    
    private Transacoes transacao;
    
    private Date dtInicio;
    
    private Date dtFim;
    
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
            
            this.transacoes = tDao.getTransacao(dtInicio, dtFim);
        } catch (Exception ex) {
            
            msg.error("Erro ao consultar transações");
        }
    }
    
    public List<Transacoes> getTransacoes() {
        return transacoes;
    }
    
    public void setTransacoes(List<Transacoes> transacoes) {
        this.transacoes = transacoes;
    }
    
    public Transacoes getTransacao() {
        return transacao;
    }
    
    public void setTransacao(Transacoes transacao) {
        this.transacao = transacao;
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
