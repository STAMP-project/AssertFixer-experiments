package br.com.falcao.PontoInteligente.api.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import br.com.falcao.PontoInteligente.api.enums.PerfilEnum;

@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String sobrenome;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(nullable=false, unique=true)
	private String cpf;
	
	@Column(nullable=true)
	private BigDecimal valorHora;
	
	@Column(nullable=true)
	private Float qtdHorasTrabalhoDia;
	
	@Column(nullable=true)
	private Float qtdHorasAlmoco;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private PerfilEnum perfil;
	
	@Column(nullable=false)
	private Date dataCriacao;
	
	@Column(nullable=false)
	private Date dataAtualizacao;
	
	/* 
		@ManyToOne = Muitos Funcionarios para uma empresa
		FetchType.EAGER = Sempre que carregar funcionario, os dados da empre já estaram disponíveis
	*/
	@ManyToOne(fetch=FetchType.EAGER)
	private Empresa empresa;
	
	/* 
	@OneToMany = Um funcionario possui mais de um lancamento
	FetchType.LAZY = Quando carregar a entidade empresa, não sera carregado todos os funcionarios altomaticamente
	CascadeType.ALL = Se uma empresa é excluida, todos os funcionarios nela são desvinculados
	*/
	@OneToMany(
			mappedBy="funcionario",
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL
			)
	private List<Lancamento> lancamentos;
	
	/* Construtor */
	public Funcionario() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/* Vai ser usado para realizar converções com DTO */
	@Transient // O método anotado com Transient sera iguinorado pelo JPA no mapeamento do banco de dados
	public Optional<BigDecimal> getValorHoraOpt() {
		return Optional.ofNullable(valorHora);
	}
	
	public BigDecimal getValorHora() {
		return valorHora;
	}
	
	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}
	
	@Transient
	public Optional<Float> getQtdHorasTrabalhoDiaOpt() {
		return Optional.ofNullable(qtdHorasTrabalhoDia);
	}
	
	public Float getQtdHorasTrabalhoDia() {
		return qtdHorasTrabalhoDia;
	}
	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia) {
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}
	
	@Transient
	public Optional<Float> getQdtHorasAlmocoOpt() {
		return Optional.ofNullable(qtdHorasAlmoco);
	}
	
	public Float getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}
	public void setQdtHorasAlmoco(Float qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}
	public PerfilEnum getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	/* Métodos Adicionais */
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorHora=" + valorHora + ", qtdHorasTrabalhoDia=" + qtdHorasTrabalhoDia + ", qtdHorasAlmoco="
				+ qtdHorasAlmoco + ", perfil=" + perfil + ", dataCriacao="
				+ dataCriacao + ", dataAtualizacao=" + dataAtualizacao + ", empresa=" + empresa + "]";
	}
	
}
