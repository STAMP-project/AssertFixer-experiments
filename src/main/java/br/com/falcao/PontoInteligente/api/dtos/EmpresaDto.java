package br.com.falcao.PontoInteligente.api.dtos;

public class EmpresaDto {

	/* Não tem ação de validação pois essa classe estara ligada somente a ações do tipo Get */
	
	private Long id;
	private String nome;
	private String razaoSocial;
	private String cnpj;
	
	/* Construtor */
	public EmpresaDto() {}

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
	
	@Override
	public String toString() {
		return "EmpresaDto [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "]";
	}
	
}
