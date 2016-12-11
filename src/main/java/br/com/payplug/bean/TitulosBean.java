
package br.com.payplug.bean;

import br.com.payplug.dao.OperacaoDao;
import br.com.payplug.dao.TitulosDao;
import br.com.payplug.dao.TransacoesDao;
import br.com.payplug.model.Operacoes;
import br.com.payplug.model.Titulos;
import br.com.payplug.model.Transacoes;
import br.com.payplug.tools.Mensagem;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    private Calendar calendar;
    
    
    public void calcularTitulos(){
        validarDatas();
        
        this.operacao = operacoesDao.getOperacaoPorCodigo(3);
        
        this.transacoes = transacoesDao.getTransacaoPorOperacoes(dtInicio, dtFim, 3);
        
        calcularParcelas(this.transacoes);
        

        this.operacao = operacoesDao.getOperacaoPorCodigo(4);
        
        this.transacoes = transacoesDao.getTransacaoPorOperacoes(dtInicio, dtFim, 4);

        calcularParcelas(this.transacoes);

        
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

    private void calcularParcelas(List<Transacoes> transacoes) {
        int diasIntervalo = 30;
        int qtdTitulo = 3;

        for(Transacoes t : transacoes){
            double valorTotalTitulo = t.getValorEmReal().doubleValue();

            if(valorTotalTitulo > 0){
                continue;
            }
            valorTotalTitulo = valorTotalTitulo * -1;
            
            this.titulos = new ArrayList<>();
            
            for(int i = 1; i <= qtdTitulo; i++){
                
                Titulos titulo = new Titulos();
                
                Calendar calendar = Calendar.getInstance();
                
                calendar.setTime(t.getDataTransacao());
                
                calendar.add(Calendar.DATE, +(diasIntervalo * i));
                
                titulo.setId(i);

                titulo.setIdTransacao(t);
                
                titulo.setDataTitulo(calendar.getTime());

                titulo.setDataTransacao(new Date());
                
                titulo.setDataAlteracao(new Date());
                
                titulo.setValorTitulo(new BigDecimal(valorTotalTitulo / qtdTitulo).setScale(2, RoundingMode.HALF_DOWN));
                
                titulos.add(titulo);
                
            }

            verificaValorDoTitulo(titulos, qtdTitulo, valorTotalTitulo);

            salvarTitulos(titulos);
            
            
        }
        


    }

    private void verificaValorDoTitulo(List<Titulos> titulos, int qtdTitulos, double valorTotalTitulo) {
        
        double total = titulos.get(0).getValorTitulo().doubleValue() * qtdTitulos;

        double dif = 0;
        
        if(total != valorTotalTitulo){
            
            dif = total - valorTotalTitulo;

            double primeiraParcela = titulos.get(0).getValorTitulo().doubleValue() - dif;
            
            titulos.get(0).setValorTitulo(new BigDecimal(primeiraParcela).setScale(2, RoundingMode.HALF_DOWN));
            
        }
        
    }

    private void salvarTitulos(List<Titulos> titulos) {
        
        for (Titulos titulo : titulos) {
            tDao.save(titulo);
        }
        
    }

    
}
