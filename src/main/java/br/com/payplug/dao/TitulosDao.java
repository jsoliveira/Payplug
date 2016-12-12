package br.com.payplug.dao;

import br.com.payplug.model.Titulos;
import br.com.payplug.tools.ConexaoJdbc;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author junio
 */
@Stateless
public class TitulosDao extends DAOImp<Integer, Titulos> {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private final StringBuilder SQL = new StringBuilder();
    private final HashMap<Integer, Object> binds = new HashMap<>();

    public TitulosDao() {
        super(Titulos.class);
    }

    public List<Titulos> getTitulos(Date dtInicio, Date dtFim) {

        try {
            initCriteria();

            criteria.andBetween("dataTitulo", dtInicio, dtFim);
            criteria.orderByDesc("dataTitulo");

            return criteria.getResultList();

        } catch (Exception e) {
            return new ArrayList<>();

        }

    }

    public ResultSet relFechamentoSintetico(Date dtInicio, String cnpjEmpresa) {

        SQL.setLength(0);
        SQL.append("SELECT SUM(tit.val_titulo) AS total_mes, \n");
        SQL.append("  usu.nome, \n");
        SQL.append("  MONTH(tit.dat_titulo)          AS mes_da_cobranca, \n");
        SQL.append("  DATENAME(MONTH,tit.dat_titulo) AS mes_cobranca, \n");
        SQL.append("  YEAR(tit.dat_titulo)           AS ano_da_cobranca, \n");
        SQL.append("  MONTH(tra.data_transacao)      AS mes_do_gasto, \n");
        SQL.append("  YEAR(tra.data_transacao)       AS ano_do_gasto \n");
        SQL.append("FROM dbo.titulos tit \n");
        SQL.append("INNER JOIN dbo.transacoes tra \n");
        SQL.append("ON (tra.id = tit.id_transacao) \n");
        SQL.append("INNER JOIN dbo.usuarios usu \n");
        SQL.append("ON (usu.id             = tra.id_usuario) \n");
        SQL.append("WHERE usu.empresa_cnpj = ? \n");
        SQL.append("AND tit.dat_titulo    >= CONVERT(DATETIME, ?) \n");
        SQL.append("  ---  and tit.dat_titulo <= convert(datetime, ?) \n");
        SQL.append("GROUP BY usu.nome, \n");
        SQL.append("  MONTH(tit.dat_titulo), \n");
        SQL.append("  YEAR(tit.dat_titulo), \n");
        SQL.append("  MONTH(tra.data_transacao), \n");
        SQL.append("  YEAR(tra.data_transacao), \n");
        SQL.append("  DATENAME(MONTH,tit.dat_titulo) \n");
        SQL.append("ORDER BY YEAR(tit.dat_titulo), \n");
        SQL.append("  MONTH(tit.dat_titulo) ;");

        binds.clear();
        binds.put(1, cnpjEmpresa);
        binds.put(2, sdf.format(dtInicio));
      

        return ConexaoJdbc.getResultSet(SQL.toString(), binds);

    }
}
