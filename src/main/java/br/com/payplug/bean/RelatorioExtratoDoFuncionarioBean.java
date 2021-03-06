/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.payplug.bean;

import br.com.payplug.dao.TitulosDao;
import br.com.payplug.dao.UsuariosDao;
import br.com.payplug.enuns.OperadoresJPQL;
import br.com.payplug.model.Usuarios;
import br.com.payplug.relatorio.Relatorio;
import br.com.payplug.tools.ConexaoJdbc;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jnakamura
 */
@SessionScoped
@Named
public class RelatorioExtratoDoFuncionarioBean implements Serializable {

    @Inject
    private UsuariosDao uDao;

    @Inject
    private Relatorio relatorio;

    @Inject
    private TitulosDao tDao;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date dtInicio;

    private Date dtFim;

    private Usuarios usuarios;

    private Usuarios empresa;

    private Usuarios funcionario;

    private List<SelectItem> empresas;

    private List<SelectItem> funcionarios;

    @PostConstruct
    public void init() {

        this.funcionarios = new ArrayList<>();

    }

    public void imprimir() {

        HashMap<String, Object> params = new HashMap<>();
        params.put("MesParametro", sdf.format(dtInicio));
     

        relatorio.getRelatorio("RelatorioExtratoFuncionario.jasper", params, tDao.relExtratoDuncionario(dtInicio, dtFim,funcionario.getId()));
        ConexaoJdbc.fechar();

    }

    public UsuariosDao getuDao() {
        return uDao;
    }

    public void setuDao(UsuariosDao uDao) {
        this.uDao = uDao;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public List<SelectItem> getEmpresas() {

        return this.empresas = uDao.getSelectItens("isParceiro", 1, OperadoresJPQL.equals.getOperador(), "nome", Boolean.TRUE);

    }

    public List<SelectItem> preencherFuncionarios() {
        this.funcionarios = uDao.getSelectItens("empresaCnpj", this.empresa.getCpfCnpj(), OperadoresJPQL.equals.getOperador(), "nome", Boolean.TRUE);
        return this.funcionarios;

    }

    public List<SelectItem> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<SelectItem> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Usuarios getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Usuarios empresa) {
        this.empresa = empresa;
    }

    public Usuarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Usuarios funcionario) {
        this.funcionario = funcionario;
    }

}
