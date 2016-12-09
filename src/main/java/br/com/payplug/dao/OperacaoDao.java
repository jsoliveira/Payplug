package br.com.payplug.dao;

import br.com.payplug.model.Operacoes;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author jnakamura
 */
@Stateless
public class OperacaoDao extends DAOImp<Integer, Operacoes>{
    
    
    public OperacaoDao() {
        super(Operacoes.class);
    }
    
    
    public Operacoes getOperacaoPorCodigo(Integer codOperacao) {

        try {
            initCriteria();
            
            criteria.andEquals("id", codOperacao);
            
            return (Operacoes) criteria.getSingleResult();

        } catch (Exception e) {
            return new Operacoes();

        }

    }

    
    
}
