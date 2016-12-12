package br.com.payplug.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author jsoliveira
 */
@Stateless
public class Relatorio {

    private HttpServletResponse response;
    private FacesContext context;
    private ByteArrayOutputStream baos;
    private InputStream stream;
    private ServletContext servletContext;
    private Connection con;

    public void init() {
        this.context = FacesContext.getCurrentInstance();
        this.response = (HttpServletResponse) context.getExternalContext().getResponse();
        this.servletContext = (ServletContext) context.getExternalContext().getContext();
    }

    public String getPath(String dir) {

        try {
            init();
            return context.getExternalContext().getRealPath("/report/") + "/";
        } catch (Exception e) {
            return null;
        }

    }

    public JasperReport getSub(String jasper) {
        try {
            init();
            return (JasperReport) JRLoader.loadObject(context.getExternalContext().getResourceAsStream("/report/"+jasper));
        } catch (JRException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public void getRelatorio(String jasper, Map<String, Object> params, ResultSet resultSet) {

        init();
        stream = context.getExternalContext().getResourceAsStream("/report/" + jasper);

        baos = new ByteArrayOutputStream();

        try {

            JasperReport report = (JasperReport) JRLoader.loadObject(stream);
            JRResultSetDataSource dataSource = new JRResultSetDataSource(resultSet);
            JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);
            JasperExportManager.exportReportToPdfStream(print, baos);

            response.reset();
            response.setContentType("application/pdf");
            response.setContentLength(baos.size());
            response.setHeader("Content-disposition", "inline; filename=relatorio.pdf");
            response.getOutputStream().write(baos.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();

            context.responseComplete();

        } catch (JRException | IOException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public void getRelatorio(String jasper, Map<String, Object> params, List<Object> lista) {

        init();
        stream = context.getExternalContext().getResourceAsStream("/report/" + jasper);
        baos = new ByteArrayOutputStream();

        try {

            JasperReport report = (JasperReport) JRLoader.loadObject(stream);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
            JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);
            JasperExportManager.exportReportToPdfStream(print, baos);

            response.reset();
            response.setContentType("application/pdf");
            response.setContentLength(baos.size());
            response.setHeader("Content-disposition", "inline; filename=relatorio.pdf");
            response.getOutputStream().write(baos.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();

            context.responseComplete();

        } catch (JRException | IOException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
