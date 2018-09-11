package br.com.falcao.PontoInteligente.api.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="empresa")
public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String razaoSocial;
	
	@Column(nullable=false)
	private String cnpj;
	
	@Column(nullable=false)
	private Date dataCriacao;
	
	@Column(nullable=false)
	private Date dataAtualizacao;
	
	/* 
		@OneToMany = Uma empresa possui um ou mais funcionarios
		FetchType.LAZY = Quando carregar a entidade empresa, não sera carregado todos os funcionarios altomaticamente
		CascadeType.ALL = Se uma empresa é excluida, todos os funcionarios nela são desvinculados
	*/
	@OneToMany(
			mappedBy="empresa",
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL
			)
	private List<Funcionario> funcionarios;

	/* Construtor */
	public Empresa() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	/* Métodos Adicionais */
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	
	@Override
	public String toString() {
		return "Empresa ["+
				"id="+id+
				", razaoSocial="+razaoSocial+
				", cnpj="+cnpj+
				", dataCriacao="+dataCriacao+
				", dataAtualizacao"+dataAtualizacao+
				"]";
	}
	
}
