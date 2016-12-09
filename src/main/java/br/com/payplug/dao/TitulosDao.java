package br.com.payplug.dao;

import br.com.payplug.model.Titulos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author junio
 */
@Stateless
public class TitulosDao extends DAOImp<Integer, Titulos>{

    public TitulosDao() {
        super(Titulos.class);
    }
    
    
    public List<Titulos> getTitulos(Date dtInicio,Date dtFim) {

        try {
            initCriteria();

            criteria.andBetween("dataTitulo", dtInicio, dtFim);
            criteria.orderByDesc("dataTitulo");

            return criteria.getResultList();

        } catch (Exception e) {
            return new ArrayList<>();

        }

    }

    
}
