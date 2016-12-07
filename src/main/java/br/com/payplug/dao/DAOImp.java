package br.com.payplug.dao;

import br.com.payplug.enuns.OperadoresJPQL;
import br.com.payplug.lazy.filter.LazyFilter;
import br.com.payplug.tools.Mensagem;
import br.com.payplug.lazy.interfaces.DAO;
import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jsoliveira
 * @param <T>
 * @param <I>
 */
public abstract class DAOImp<T, I extends Serializable> implements DAO<T, I> {

    @PersistenceContext(unitName = "Persistencia")
    public EntityManager entityManager;

    @Inject
    private Mensagem men;

    private final Class<I> type;

    public UaiCriteria criteria;

    public DAOImp(Class<I> type) {
        this.type = type;

    }

    public void initCriteria() {

        this.criteria = null;

        this.criteria = UaiCriteriaFactory.createQueryCriteria(this.entityManager, this.type);

    }

    public List<I> filtrados(LazyFilter filter) {

        createEasyCriteria(filter);

        this.criteria.setFirstResult(filter.getPrimeiroRegistro());
        this.criteria.setMaxResults(filter.getQuantidadeRegistros());

        if (filter.isAscendente() && filter.getPropriedadeOrdenacao() != null && !filter.getPropriedadeOrdenacao().isEmpty()) {
            this.criteria.orderByAsc(filter.getPropriedadeOrdenacao());
        } else if (filter.getPropriedadeOrdenacao() != null && !filter.getPropriedadeOrdenacao().isEmpty()) {
            this.criteria.orderByDesc(filter.getPropriedadeOrdenacao());
        } else {

            this.criteria.orderByAsc(filter.getPropriedadePadraoOrdenacao());
        }

        return this.criteria.getResultList();

    }

    public Long quantidadeFiltrados(LazyFilter filter) {
        createEasyCriteria(filter);

        return this.criteria.countRegularCriteria();
    }

    private void createEasyCriteria(LazyFilter filter) {

        initCriteria();

        if (filter.getPropFiltroFixo() != null) {

            if (!filter.getPropFiltroFixo().isEmpty()) {

                this.criteria.andEquals(filter.getPropFiltroFixo(), filter.getValorFiltroFixo());
            }

        }

        if (filter.getPropriedadePesq() == null || filter.getPropriedadePesq().isEmpty()) {

            return;
        }

        ///Caso a consulta necessite de um JOIN
        if (filter.getPropriedadePesq().contains("|")) {

            this.criteria.innerJoin(filter.getPropriedadePesq().substring(filter.getPropriedadePesq().indexOf("|") + 1, filter.getPropriedadePesq().length()));

        }

        try {

            Field f = type.getDeclaredField(filter.getPropriedadePesq().contains("|")
                    ? filter.getPropriedadePesq().substring(0, filter.getPropriedadePesq().indexOf("|"))
                    : filter.getPropriedadePesq());

            switch (f.getType().getName()) {

                case ("java.util.Date"): {

                    try {

                        if (f.isAnnotationPresent(Temporal.class)) {

                            if (f.getAnnotation(Temporal.class).value().equals(TemporalType.TIMESTAMP)) {

                                //            f.set(obj, new Date(r.getTimestamp(f.getAnnotation(Column.class).name().trim()).getTime()));
                            }

                            if (f.getAnnotation(Temporal.class).value().equals(TemporalType.DATE)) {

                                //           f.set(obj, new Date(r.getDate(f.getAnnotation(Column.class).name().trim()).getTime()));
                            }

                        }

                    } catch (Exception e) {

                        return;

                    }

                }

                case ("java.lang.String"): {

                    this.criteria.andStringLike(false, filter.getPropriedadePesq(), "%" + filter.getDescricao() + "%");
                    return;

                }

                case ("java.lang.Integer"): {

                    try {
                        Integer.parseInt(filter.getDescricao());
                        this.criteria.andEquals(filter.getPropriedadePesq(), filter.getDescricao());
                        return;
                    } catch (NumberFormatException n) {

                        men.error("Erro ao Pesquisar, essa pesquisa so aceita números inteiros");
                        return;

                    }

                }

                case ("java.lang.Long"): {

                    try {
                        Long.parseLong(filter.getDescricao());
                        this.criteria.andEquals(filter.getPropriedadePesq(), filter.getDescricao());
                        return;
                    } catch (Exception e) {

                        men.error("Erro ao Pesquisar, essa pesquisa so aceita números");
                        return;

                    }
                }

                case ("char"): {

                    this.criteria.andEquals(filter.getPropriedadePesq(), filter.getDescricao());

                }

                default: {

                    this.criteria.andEquals(filter.getPropriedadePesq(), filter.getDescricao());

                }

            }

        } catch (NoSuchFieldException | SecurityException ex) {

            this.criteria.andEquals((filter.getPropriedadePesq().contains("|"))
                    ? filter.getPropriedadePesq().substring(0, filter.getPropriedadePesq().indexOf("|"))
                    : filter.getPropriedadePesq(), filter.getDescricao());

        }

    }

    /**
     *
     * @param entity Objeto a ser persistido
     */
    @Override
    public void save(I entity) {
        this.entityManager.persist(entity);
    }

    public void refresh(I entity) {

        this.entityManager.refresh(entity);

    }

    /**
     *
     * @param entity Objeto a ser removido
     */
    @Override
    public void remove(I entity) {

        this.entityManager.remove(this.entityManager.merge(entity));
    }

    /**
     *
     * @param entity Objeto a ser Atualizado
     */
    @Override
    public void update(I entity) {
        this.entityManager.merge(entity);
    }

    /**
     *
     * @param pk Valor da chave primaria a ser pesquisa
     * @return retorna objeto do tipo
     *
     */
    @Override
    public I getById(T pk) {
        return (I) this.entityManager.find(this.type, pk);
    }

    /**
     *
     * @return Retorna todos os objetos do tipoo
     *
     */
    @Override
    public List<I> getAll() {

        initCriteria();
        return this.criteria.getResultList();
    }

    /**
     *
     *
     * @param orderBy Campo de ordenação
     * @param asc True- Ascendente False-Descendente
     * @return retorna uma de entidades pesquisada
     */
    @Override
    public List<I> findAll(String orderBy, Boolean asc) {

        try {

            initCriteria();
            if (asc) {
                this.criteria.orderByAsc(orderBy);
            } else {
                this.criteria.orderByDesc(orderBy);
            }

            return this.criteria.getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao consultar todos =>" + e);
            return new ArrayList<>();
        }
    }

    public List<SelectItem> getSelectItens(String orderBy, Boolean asc) {

        try {

            List<SelectItem> ret = new ArrayList<>();

            for (I i : findAll(orderBy, asc)) {

                ret.add(new SelectItem(i));

            }
            return ret;
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    public List<SelectItem> getSelectItens(String atributo, Object valorPesq, Integer operador, String orderBy, Boolean asc) {

        try {

            List<SelectItem> ret = new ArrayList<>();

            for (I i : buscarPorAtributo(atributo, valorPesq, operador, orderBy, asc)) {

                ret.add(new SelectItem(i));

            }
            return ret;
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    public List<SelectItem> listToSelectItens(List<I> list) {

        try {

            List<SelectItem> ret = new ArrayList<>();

            for (I i : list) {
                ret.add(new SelectItem(i));
            }
            return ret;
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    /**
     *
     * @param jpql Consulta JPQL
     * @return retorna uma lita de entidades pesquisadas
     */
    @Override
    public List<I> executeJPQL(String jpql) {

        try {

            return this.entityManager.createQuery(jpql).getResultList();

        } catch (Exception e) {

            System.out.println("Erro ao executar jpql =>" + e);
            return new ArrayList<>();

        }
    }

    /**
     *
     * @param jpql -Executa o jpql retornando um unico valor que deve ser feito
     * o cast
     * @return -Retorna Objeto que foi pesquisado
     */
    @Override
    public Object executeJPQLUnicoValor(String jpql) {

        try {

            return this.entityManager.createQuery(jpql).getSingleResult();

        } catch (Exception e) {

            System.out.println("Erro ao executar jpql =>" + e);
            return null;

        }
    }

    /**
     *
     * @param atributo Atributo a ser pesquisado
     * @param valorPesq Valor a ser pesquisado no atributo
     * @param operador Operador logico da consulta
     * @param orderBy Campo de ordenação
     * @param asc True- Ascendente False-Descendente
     * @return -Retorna uma lista de entidades pesquisada
     */
    @Override
    public List<I> buscarPorAtributo(String atributo, Object valorPesq, Integer operador, String orderBy, Boolean asc) {

        try {
            initCriteria();

            if (operador.equals(OperadoresJPQL.equals.getOperador())) {

                this.criteria.andEquals(atributo, valorPesq);

            }

            if (operador.equals(OperadoresJPQL.notEquals.getOperador())) {

                this.criteria.andNotEquals(atributo, valorPesq);

            }

            if (operador.equals(OperadoresJPQL.like.getOperador())) {

                this.criteria.andStringLike(atributo, "%" + (String) valorPesq + "%");

            }

            if (operador.equals(OperadoresJPQL.notLike.getOperador())) {

                this.criteria.andStringNotLike(atributo, "%" + (String) valorPesq + "%");

            }

            if (asc) {
                this.criteria.orderByAsc(orderBy);
            } else {
                this.criteria.orderByDesc(orderBy);
            }

            return this.criteria.getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao consultar todos =>" + e);
            return new ArrayList<>();
        }
    }

    /**
     *
     * @param atributo Atributo a ser pesquisado
     * @param valorPesq Valor a ser pesquisado no atributo
     * @param operador Operador logico da consulta
     * @param join Entidade que fará Join
     * @param orderBy Campo de ordenação
     * @param asc True- Ascendente False-Descendente
     * @return -Retorna uma lista de entidades pesquisada
     */
    public List<I> buscarPorAtributo(String atributo, Object valorPesq, Integer operador, String join, String orderBy, Boolean asc) {

        try {
            initCriteria();

            if (join != null || !join.isEmpty()) {
                this.criteria.innerJoin(join);
            }

            if (operador.equals(OperadoresJPQL.equals.getOperador())) {

                this.criteria.andEquals(atributo, valorPesq);

            }

            if (operador.equals(OperadoresJPQL.notEquals.getOperador())) {

                this.criteria.andNotEquals(atributo, valorPesq);

            }

            if (operador.equals(OperadoresJPQL.like.getOperador())) {

                this.criteria.andStringLike(atributo, "%" + (String) valorPesq + "%");

            }

            if (operador.equals(OperadoresJPQL.notLike.getOperador())) {

                this.criteria.andStringNotLike(atributo, "%" + (String) valorPesq + "%");

            }

            if (asc) {
                this.criteria.orderByAsc(orderBy);
            } else {
                this.criteria.orderByDesc(orderBy);
            }

            return this.criteria.getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao consultar todos =>" + e);
            return new ArrayList<>();
        }
    }

    /**
     *
     * @param atributos Atributos para Where
     * @param valoresPesq Valores para Where
     * @param operadores Operadores dos Atributos
     * @param orderBy Campo de ordenação
     * @param asc True- Ascendente False-Descendente
     * @return -Retorna uma lista de entidades pesquisada
     */
    public List<I> buscarPorAtributos(List<String> atributos, List<Object> valoresPesq, List<Integer> operadores, String orderBy, Boolean asc) {

        if (atributos.size() != valoresPesq.size()) {

            return new ArrayList<>();

        }

        if (atributos.size() != operadores.size()) {

            return new ArrayList<>();

        }

        try {
            initCriteria();

            Integer operador = null;
            String atributo = null;
            Object valorPesq = null;

            for (int i = 0; i <= atributos.size(); i++) {

                operador = operadores.get(i);
                atributo = atributos.get(i);
                valorPesq = valoresPesq.get(i);

                if (operador.equals(OperadoresJPQL.equals.getOperador())) {

                    this.criteria.andEquals(atributo, valorPesq);

                }

                if (operador.equals(OperadoresJPQL.notEquals.getOperador())) {

                    this.criteria.andNotEquals(atributo, valorPesq);

                }

                if (operador.equals(OperadoresJPQL.like.getOperador())) {

                    this.criteria.andStringLike(atributo, "%" + (String) valorPesq + "%");

                }

                if (operador.equals(OperadoresJPQL.notLike.getOperador())) {

                    this.criteria.andStringNotLike(atributo, "%" + (String) valorPesq + "%");

                }
            }

            if (asc) {
                this.criteria.orderByAsc(orderBy);
            } else {
                this.criteria.orderByDesc(orderBy);
            }

            return this.criteria.getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao consultar todos =>" + e);
            return new ArrayList<>();
        }
    }

    public List<I> buscarPorAtributos(List<String> atributos, List<Object> valoresPesq, List<Integer> operadores, List<String> joins, String orderBy, Boolean asc) {

        if (atributos.size() != valoresPesq.size()) {

            return new ArrayList<>();

        }

        if (atributos.size() != operadores.size()) {

            return new ArrayList<>();

        }

        try {
            initCriteria();

            if (joins != null && !joins.isEmpty()) {

                for (String s : joins) {

                    this.criteria.innerJoin(s);
                }

            } 

            Integer operador = null;
            String atributo = null;
            Object valorPesq = null;

            for (int i = 0; i <= (atributos.size() -1 ); i++) {

                operador = operadores.get(i);
                atributo = atributos.get(i);
                valorPesq = valoresPesq.get(i);

                if (operador.equals(OperadoresJPQL.equals.getOperador())) {

                    this.criteria.andEquals(atributo, valorPesq);
                    continue;

                }

                if (operador.equals(OperadoresJPQL.notEquals.getOperador())) {

                    this.criteria.andNotEquals(atributo, valorPesq);
                    continue;

                }

                if (operador.equals(OperadoresJPQL.like.getOperador())) {

                    this.criteria.andStringLike(atributo, "%" + (String) valorPesq + "%");
                    continue;

                }

                if (operador.equals(OperadoresJPQL.notLike.getOperador())) {

                    this.criteria.andStringNotLike(atributo, "%" + (String) valorPesq + "%");
                    continue;

                }
            }

            if (asc) {
                this.criteria.orderByAsc(orderBy);
            } else {
                this.criteria.orderByDesc(orderBy);
            }

            return this.criteria.getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao consultar todos =>" + e);
            return new ArrayList<>();
        }
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
