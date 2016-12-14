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
    private final SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
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
//        SQL.append("  DATENAME(MONTH,tit.dat_titulo) AS mes_cobranca, \n");
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

    public Double relTotalFechamentoSintetico(Date dtInicio, String cnpjEmpresa) {
        try {
            
            SQL.setLength(0);
            SQL.append("SELECT SUM(tit.val_titulo) AS total_mes, \n");
            SQL.append(" MONTH(tit.dat_titulo)          AS mes_da_cobranca, \n");
            SQL.append("  YEAR(tit.dat_titulo) \n");
            SQL.append("FROM dbo.titulos tit \n");
            SQL.append("INNER JOIN dbo.transacoes tra \n");
            SQL.append("ON (tra.id = tit.id_transacao) \n");
            SQL.append("INNER JOIN dbo.usuarios usu \n");
            SQL.append("ON (usu.id             = tra.id_usuario) \n");
            SQL.append("WHERE usu.empresa_cnpj = ? \n");
            SQL.append("AND tit.dat_titulo    >= CONVERT(DATETIME, ?) \n");
            SQL.append("GROUP BY usu.nome, \n");
            SQL.append("  MONTH(tit.dat_titulo), \n");
            SQL.append("  YEAR(tit.dat_titulo) \n");
            SQL.append("having  MONTH(tit.dat_titulo) = ? \n");
            SQL.append("ORDER BY YEAR(tit.dat_titulo),  \n");
            SQL.append("  MONTH(tit.dat_titulo) ");

            binds.clear();
            binds.put(1, cnpjEmpresa);
            binds.put(2, sdf.format(dtInicio));
            
            binds.put(3, sdfMes.format(dtInicio));

            ResultSet rs = ConexaoJdbc.getResultSet(SQL.toString(), binds);
            
            double total = 0;
            
            while(rs.next()){
                total += rs.getDouble("total_mes");
                
            }
            return total;
        } catch (Exception e) {
            return Double.valueOf(0);
        }
    }

    public ResultSet relExtratoDuncionario(Date dtInicio, Date dtFim, Integer codUsuario) {

        SQL.setLength(0);
        SQL.append("SELECT tra.valor_em_real * -1 AS valor, \n");
        SQL.append("  usu.nome                    AS funcionario, \n");
        SQL.append("  tra.data_transacao          AS data, \n");
        SQL.append("  tra.descricao \n");
        SQL.append("FROM dbo.transacoes tra \n");
        SQL.append("INNER JOIN dbo.usuarios usu \n");
        SQL.append("ON (usu.id = tra.id_usuario) \n");
        SQL.append("INNER JOIN dbo.operacoes op \n");
        SQL.append("ON (op.id              = tra.id_operacao) \n");
        SQL.append("WHERE usu.empresa_cnpj = '82.398.124/0001-31' \n");
        SQL.append("AND tra.valor_em_real  < 0 \n");
        SQL.append("AND (op.indoperacao    = 'T' \n");
        SQL.append("OR op.id               = 4) \n");
        SQL.append("AND tra.data_transacao BETWEEN CONVERT(DATETIME, ?) AND CONVERT(DATETIME, ?) \n");
        SQL.append("AND tra.id_usuario =? \n");
        SQL.append("ORDER BY data_transacao;");

        binds.clear();
        binds.put(1, sdf.format(dtInicio));
        binds.put(2, sdf.format(dtFim));
        binds.put(3, codUsuario);

        return ConexaoJdbc.getResultSet(SQL.toString(), binds);

    }

}
