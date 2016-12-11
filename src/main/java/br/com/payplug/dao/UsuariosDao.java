package br.com.payplug.dao;

import br.com.payplug.model.Usuarios;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author jsoliveira
 */
@Stateless
public class UsuariosDao extends DAOImp<Integer, Usuarios> {

    public UsuariosDao() {
        super(Usuarios.class);
    }

    public Usuarios findUser(String email, String senha) {

        try {
            initCriteria();

            criteria.andEquals("email", email);
            criteria.andEquals("pwLogin", senha);

            return (Usuarios) criteria.getSingleResult();

        } catch (Exception e) {
            return null;

        }

    }
    
      public List<Usuarios> empresas() {

        try {
            initCriteria();

            criteria.andEquals("isParceiro", 1);
            

        
            return criteria.getResultList();
            

        } catch (Exception e) {
            return null;

        }

    }

}
