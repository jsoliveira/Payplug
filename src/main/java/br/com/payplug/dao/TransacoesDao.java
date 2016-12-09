package br.com.payplug.dao;

import br.com.payplug.dao.DAOImp;
import br.com.payplug.model.Operacoes;
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
public class TransacoesDao extends DAOImp<Integer, Transacoes> {

    public TransacoesDao() {
        super(Transacoes.class);
    }

    public List<Transacoes> getTransacao(Date dtInicio, Date dtFim) {

        try {
            initCriteria();

            criteria.andBetween("dataTransacao", dtInicio, dtFim);
            criteria.orderByDesc("dataTransacao");

            return criteria.getResultList();

        } catch (Exception e) {
            return new ArrayList<>();

        }

    }

    public List<Transacoes> getTransacaoPorOperacoes(Date dtInicio, Date dtFim, Integer codOperacao) {

        try {
            initCriteria();

            criteria.innerJoin("idOperacao");
            criteria.andBetween("dataTransacao", dtInicio, dtFim);
            criteria.andEquals("idOperacao.id", codOperacao);
            criteria.orderByDesc("dataTransacao");

            return criteria.getResultList();

        } catch (Exception e) {
            return new ArrayList<>();

        }

    }

}
