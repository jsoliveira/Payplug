
package br.com.payplug.dao;

import br.com.payplug.model.Transacoes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author jsoliveira
 */

@Stateless
public class TransacoesDao extends DAOImp<Integer, Transacoes>{
    
    public TransacoesDao() {
        super(Transacoes.class);
    }
    
    
    public List<Transacoes> getTransacao(Date dtInicio,Date dtFim) {

        try {
            initCriteria();

          
            criteria.andBetween("dataTransacao", dtInicio, dtFim);
            criteria.orderByDesc("dataTransacao");
            

            return criteria.getResultList();

        } catch (Exception e) {
            return new ArrayList<>();

        }

    }

    
}
