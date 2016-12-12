package br.com.payplug.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author jsoliveira
 */
public class ConexaoJdbc {

    private static ResultSet r;
    private static PreparedStatement ps;
    private static Connection c;
    private static final String conectionPoll = "java:app/PayPLugJNDI";
    private static int contador;

    private static DataSource dtSource;

    public static Connection getConn() {
        try {

            InitialContext initialContext;
            try {

                initialContext = new InitialContext();
                dtSource = (DataSource) initialContext.lookup(conectionPoll);
                

            } catch (NamingException ex) {

                ex.printStackTrace();

            }
           
            return dtSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException("A CONEXAO NÃO PODE SER RECUPERADA.");
        }
    }

    public static ResultSet getResultSet(String sql, HashMap<Integer, Object> binds) {

        try {
            c = ConexaoJdbc.getConn();
            ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            for (Map.Entry<Integer, Object> entrada : binds.entrySet()) {

                ps.setObject(entrada.getKey(), entrada.getValue());
            }

            r = ps.executeQuery();

            return r;

        } catch (Exception e) {

            return null;

        } 
    }
    
    public static void fechar(){
    
  
            if (r != null) {
                try {
                    r.close();
                } catch (SQLException | RuntimeException e) {

                    e.printStackTrace();
                }
            }

            if (ps != null) {
                try {

                    ps.close();

                } catch (SQLException | RuntimeException e) {
                    e.printStackTrace();
                }
            }

            if (c != null) {
                try {

                    c.close();

                } catch (SQLException | RuntimeException e) {
                    e.printStackTrace();
                }
            }
        
    }

    public DataSource getDtSource() {
        return dtSource;
    }

    public void setDtSource(DataSource dtSource) {
        ConexaoJdbc.dtSource = dtSource;
    }

    public static Connection getC() {
        return c;
    }

}
