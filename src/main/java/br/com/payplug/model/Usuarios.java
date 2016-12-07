package br.com.payplug.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jsoliveira
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement

public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 100)
    @Column(name = "codigo")
    private String codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome")
    private String nome;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "celular")
    private String celular;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    
    @Size(max = 200)
    @Column(name = "endereco")
    private String endereco;
    
    @Size(max = 200)
    @Column(name = "bairro")
    private String bairro;
    
    @Size(max = 200)
    @Column(name = "complemento")
    private String complemento;
    
    @Size(max = 9)
    @Column(name = "cep")
    private String cep;
    
    @Column(name = "agencia")
    private Integer agencia;
    @Column(name = "conta")
    private Integer conta;
    @Size(max = 20)
    @Column(name = "numero_cartao")
    private String numeroCartao;
    @Column(name = "digito_verificador")
    private Integer digitoVerificador;
    @Size(max = 200)
    @Column(name = "nome_titular")
    private String nomeTitular;
    @Size(max = 8)
    @Column(name = "vencimento_cartao_mes")
    private String vencimentoCartaoMes;
    @Size(max = 8)
    @Column(name = "vencimento_cartao_ano")
    private String vencimentoCartaoAno;
    @Column(name = "tipo_cartao")
    private Integer tipoCartao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "senha")
    private String senha;
    @Size(max = 200)
    @Column(name = "senha_liberacao")
    private String senhaLiberacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_prefere_notificacao_sms")
    private boolean isPrefereNotificacaoSms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_prefere_notificacao_email")
    private boolean isPrefereNotificacaoEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_administrador")
    private boolean isAdministrador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_parceiro")
    private boolean isParceiro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_taxa")
    private boolean isTaxa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo_total")
    private BigDecimal saldoTotal;
    @Column(name = "saldo_disponivel_saque")
    private BigDecimal saldoDisponivelSaque;
    @Lob
    @Column(name = "imagem")
    private byte[] imagem;
    @Size(max = 200)
    @Column(name = "nome_imagem")
    private String nomeImagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_bloqueado")
    private boolean isBloqueado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_ativo")
    private boolean isAtivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removido")
    private int removido;
    @Size(max = 200)
    @Column(name = "empresa_nome")
    private String empresaNome;
    @Size(max = 20)
    @Column(name = "empresa_telefone")
    private String empresaTelefone;
    @Size(max = 100)
    @Column(name = "empresa_email")
    private String empresaEmail;
    @Column(name = "limite_mensal")
    private BigDecimal limiteMensal;
    @Column(name = "limite_mensal_camara")
    private BigDecimal limiteMensalCamara;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;
    @Size(max = 200)
    @Column(name = "profissao")
    private String profissao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pagamento_automatico")
    private boolean pagamentoAutomatico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_terminal")
    private int idTerminal;
    @Column(name = "qualificacao_camara_comercio")
    private Integer qualificacaoCamaraComercio;
    @Column(name = "renda_anual_camara_comerio")
    private BigDecimal rendaAnualCamaraComerio;
    @Column(name = "id_cnae")
    private Integer idCnae;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_optante_servico_convenio")
    private boolean isOptanteServicoConvenio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_optante_servico_camara_comercio")
    private boolean isOptanteServicoCamaraComercio;
    
    @Size(max = 18)
    @Column(name = "empresa_cnpj")
    private String empresaCnpj;
    
    @JoinColumn(name = "id_banco", referencedColumnName = "id")
    @ManyToOne
    private Bancos idBanco;
    @JoinColumn(name = "id_cartao_credito", referencedColumnName = "id")
    @ManyToOne
    private CartoesCredito idCartaoCredito;
    @JoinColumn(name = "id_cidade", referencedColumnName = "id")
    @ManyToOne
    private Cidades idCidade;
    @JoinColumn(name = "id_moeda", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Moedas idMoeda;
    @OneToMany(mappedBy = "idUsuarioIndicadorCadastro")
    private List<Usuarios> usuariosList;
    @JoinColumn(name = "id_usuario_indicador_cadastro", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuarioIndicadorCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Relatorios> relatoriosList;
    @OneToMany(mappedBy = "idUsuarioDono")
    private List<NumeroCartao> numeroCartaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<ApiTokens> apiTokensList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Transacoes> transacoesList;
    @OneToMany(mappedBy = "idUsuarioSolicitante")
    private List<CartaoPayplug> cartaoPayplugList;
    @OneToMany(mappedBy = "idUsuarioDono")
    private List<CartaoPayplug> cartaoPayplugList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Importacoes> importacoesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProponente")
    private List<CotacoesCamaraComercio> cotacoesCamaraComercioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProdutor")
    private List<PlanosCamaraComercio> planosCamaraComercioList;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String nome, String cpfCnpj, String celular, String email, String senha, boolean isPrefereNotificacaoSms, boolean isPrefereNotificacaoEmail, boolean isAdministrador, boolean isParceiro, boolean isTaxa, boolean isBloqueado, boolean isAtivo, int removido, boolean pagamentoAutomatico, int idTerminal, boolean isOptanteServicoConvenio, boolean isOptanteServicoCamaraComercio) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.celular = celular;
        this.email = email;
        this.senha = senha;
        this.isPrefereNotificacaoSms = isPrefereNotificacaoSms;
        this.isPrefereNotificacaoEmail = isPrefereNotificacaoEmail;
        this.isAdministrador = isAdministrador;
        this.isParceiro = isParceiro;
        this.isTaxa = isTaxa;
        this.isBloqueado = isBloqueado;
        this.isAtivo = isAtivo;
        this.removido = removido;
        this.pagamentoAutomatico = pagamentoAutomatico;
        this.idTerminal = idTerminal;
        this.isOptanteServicoConvenio = isOptanteServicoConvenio;
        this.isOptanteServicoCamaraComercio = isOptanteServicoCamaraComercio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Integer getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(Integer digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getVencimentoCartaoMes() {
        return vencimentoCartaoMes;
    }

    public void setVencimentoCartaoMes(String vencimentoCartaoMes) {
        this.vencimentoCartaoMes = vencimentoCartaoMes;
    }

    public String getVencimentoCartaoAno() {
        return vencimentoCartaoAno;
    }

    public void setVencimentoCartaoAno(String vencimentoCartaoAno) {
        this.vencimentoCartaoAno = vencimentoCartaoAno;
    }

    public Integer getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(Integer tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaLiberacao() {
        return senhaLiberacao;
    }

    public void setSenhaLiberacao(String senhaLiberacao) {
        this.senhaLiberacao = senhaLiberacao;
    }

    public boolean getIsPrefereNotificacaoSms() {
        return isPrefereNotificacaoSms;
    }

    public void setIsPrefereNotificacaoSms(boolean isPrefereNotificacaoSms) {
        this.isPrefereNotificacaoSms = isPrefereNotificacaoSms;
    }

    public boolean getIsPrefereNotificacaoEmail() {
        return isPrefereNotificacaoEmail;
    }

    public void setIsPrefereNotificacaoEmail(boolean isPrefereNotificacaoEmail) {
        this.isPrefereNotificacaoEmail = isPrefereNotificacaoEmail;
    }

    public boolean getIsAdministrador() {
        return isAdministrador;
    }

    public void setIsAdministrador(boolean isAdministrador) {
        this.isAdministrador = isAdministrador;
    }

    public boolean getIsParceiro() {
        return isParceiro;
    }

    public void setIsParceiro(boolean isParceiro) {
        this.isParceiro = isParceiro;
    }

    public boolean getIsTaxa() {
        return isTaxa;
    }

    public void setIsTaxa(boolean isTaxa) {
        this.isTaxa = isTaxa;
    }

    public BigDecimal getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(BigDecimal saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public BigDecimal getSaldoDisponivelSaque() {
        return saldoDisponivelSaque;
    }

    public void setSaldoDisponivelSaque(BigDecimal saldoDisponivelSaque) {
        this.saldoDisponivelSaque = saldoDisponivelSaque;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public boolean getIsBloqueado() {
        return isBloqueado;
    }

    public void setIsBloqueado(boolean isBloqueado) {
        this.isBloqueado = isBloqueado;
    }

    public boolean getIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(boolean isAtivo) {
        this.isAtivo = isAtivo;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public String getEmpresaNome() {
        return empresaNome;
    }

    public void setEmpresaNome(String empresaNome) {
        this.empresaNome = empresaNome;
    }

    public String getEmpresaTelefone() {
        return empresaTelefone;
    }

    public void setEmpresaTelefone(String empresaTelefone) {
        this.empresaTelefone = empresaTelefone;
    }

    public String getEmpresaEmail() {
        return empresaEmail;
    }

    public void setEmpresaEmail(String empresaEmail) {
        this.empresaEmail = empresaEmail;
    }

    public BigDecimal getLimiteMensal() {
        return limiteMensal;
    }

    public void setLimiteMensal(BigDecimal limiteMensal) {
        this.limiteMensal = limiteMensal;
    }

    public BigDecimal getLimiteMensalCamara() {
        return limiteMensalCamara;
    }

    public void setLimiteMensalCamara(BigDecimal limiteMensalCamara) {
        this.limiteMensalCamara = limiteMensalCamara;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public boolean getPagamentoAutomatico() {
        return pagamentoAutomatico;
    }

    public void setPagamentoAutomatico(boolean pagamentoAutomatico) {
        this.pagamentoAutomatico = pagamentoAutomatico;
    }

    public int getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(int idTerminal) {
        this.idTerminal = idTerminal;
    }

    public Integer getQualificacaoCamaraComercio() {
        return qualificacaoCamaraComercio;
    }

    public void setQualificacaoCamaraComercio(Integer qualificacaoCamaraComercio) {
        this.qualificacaoCamaraComercio = qualificacaoCamaraComercio;
    }

    public BigDecimal getRendaAnualCamaraComerio() {
        return rendaAnualCamaraComerio;
    }

    public void setRendaAnualCamaraComerio(BigDecimal rendaAnualCamaraComerio) {
        this.rendaAnualCamaraComerio = rendaAnualCamaraComerio;
    }

    public Integer getIdCnae() {
        return idCnae;
    }

    public void setIdCnae(Integer idCnae) {
        this.idCnae = idCnae;
    }

    public boolean getIsOptanteServicoConvenio() {
        return isOptanteServicoConvenio;
    }

    public void setIsOptanteServicoConvenio(boolean isOptanteServicoConvenio) {
        this.isOptanteServicoConvenio = isOptanteServicoConvenio;
    }

    public boolean getIsOptanteServicoCamaraComercio() {
        return isOptanteServicoCamaraComercio;
    }

    public void setIsOptanteServicoCamaraComercio(boolean isOptanteServicoCamaraComercio) {
        this.isOptanteServicoCamaraComercio = isOptanteServicoCamaraComercio;
    }

    public String getEmpresaCnpj() {
        return empresaCnpj;
    }

    public void setEmpresaCnpj(String empresaCnpj) {
        this.empresaCnpj = empresaCnpj;
    }

    public Bancos getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Bancos idBanco) {
        this.idBanco = idBanco;
    }

    public CartoesCredito getIdCartaoCredito() {
        return idCartaoCredito;
    }

    public void setIdCartaoCredito(CartoesCredito idCartaoCredito) {
        this.idCartaoCredito = idCartaoCredito;
    }

    public Cidades getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Cidades idCidade) {
        this.idCidade = idCidade;
    }

    public Moedas getIdMoeda() {
        return idMoeda;
    }

    public void setIdMoeda(Moedas idMoeda) {
        this.idMoeda = idMoeda;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Usuarios getIdUsuarioIndicadorCadastro() {
        return idUsuarioIndicadorCadastro;
    }

    public void setIdUsuarioIndicadorCadastro(Usuarios idUsuarioIndicadorCadastro) {
        this.idUsuarioIndicadorCadastro = idUsuarioIndicadorCadastro;
    }

    @XmlTransient
    public List<Relatorios> getRelatoriosList() {
        return relatoriosList;
    }

    public void setRelatoriosList(List<Relatorios> relatoriosList) {
        this.relatoriosList = relatoriosList;
    }

    @XmlTransient
    public List<NumeroCartao> getNumeroCartaoList() {
        return numeroCartaoList;
    }

    public void setNumeroCartaoList(List<NumeroCartao> numeroCartaoList) {
        this.numeroCartaoList = numeroCartaoList;
    }

    @XmlTransient
    public List<ApiTokens> getApiTokensList() {
        return apiTokensList;
    }

    public void setApiTokensList(List<ApiTokens> apiTokensList) {
        this.apiTokensList = apiTokensList;
    }

    @XmlTransient
    public List<Transacoes> getTransacoesList() {
        return transacoesList;
    }

    public void setTransacoesList(List<Transacoes> transacoesList) {
        this.transacoesList = transacoesList;
    }

    @XmlTransient
    public List<CartaoPayplug> getCartaoPayplugList() {
        return cartaoPayplugList;
    }

    public void setCartaoPayplugList(List<CartaoPayplug> cartaoPayplugList) {
        this.cartaoPayplugList = cartaoPayplugList;
    }

    @XmlTransient
    public List<CartaoPayplug> getCartaoPayplugList1() {
        return cartaoPayplugList1;
    }

    public void setCartaoPayplugList1(List<CartaoPayplug> cartaoPayplugList1) {
        this.cartaoPayplugList1 = cartaoPayplugList1;
    }

    @XmlTransient
    public List<Importacoes> getImportacoesList() {
        return importacoesList;
    }

    public void setImportacoesList(List<Importacoes> importacoesList) {
        this.importacoesList = importacoesList;
    }

    @XmlTransient
    public List<CotacoesCamaraComercio> getCotacoesCamaraComercioList() {
        return cotacoesCamaraComercioList;
    }

    public void setCotacoesCamaraComercioList(List<CotacoesCamaraComercio> cotacoesCamaraComercioList) {
        this.cotacoesCamaraComercioList = cotacoesCamaraComercioList;
    }

    @XmlTransient
    public List<PlanosCamaraComercio> getPlanosCamaraComercioList() {
        return planosCamaraComercioList;
    }

    public void setPlanosCamaraComercioList(List<PlanosCamaraComercio> planosCamaraComercioList) {
        this.planosCamaraComercioList = planosCamaraComercioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.viptech.payplug.model.Usuarios[ id=" + id + " ]";
    }
    
}
