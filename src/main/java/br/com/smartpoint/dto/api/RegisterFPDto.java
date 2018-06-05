package br.com.smartpoint.dto.api;

import java.util.Optional;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class RegisterFPDto {

	private Long id;
	private String name;
	private String email;
	private String password;
	private String cpf;
	private Optional<String> hourvalue = Optional.empty();
	private Optional<String> quantityHourOfDay = Optional.empty();
	private Optional<String> qtyLunch = Optional.empty();
	private String cnpj;

	public RegisterFPDto() {

	}

	public RegisterFPDto(String name, String email, String cpf) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	@NotEmpty(message = "email cannot be empty")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "name cannot be empty")
	public String getName() {
		return name;
	}

	@NotEmpty(message = "password cannot be empty")
	public String getPassword() {
		return password;
	}

	@CPF
	@NotEmpty(message = "cpf cannot be empty")
	public String getCpf() {
		return cpf;
	}

	public Optional<String> getHourvalue() {
		return hourvalue;
	}

	public Optional<String> getQuantityHourOfDay() {
		return quantityHourOfDay;
	}

	public Optional<String> getQtyLunch() {
		return qtyLunch;
	}

	@CNPJ
	@NotEmpty(message = "cnpj cannot be empty ")
	public String getCnpj() {
		return cnpj;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setHourvalue(Optional<String> hourvalue) {
		this.hourvalue = hourvalue;
	}

	public void setQuantityHourOfDay(Optional<String> quantityHourOfDay) {
		this.quantityHourOfDay = quantityHourOfDay;
	}

	public void setQtyLunch(Optional<String> qtyLunch) {
		this.qtyLunch = qtyLunch;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "FuncionarioDto [id=" + id + ", nome=" + name + ", email=" + email + ", senha=" + password + ", cpf="
				+ cpf + ", valorHora=" + hourvalue + ", qtdHorasTrabalhoDia=" + quantityHourOfDay + ", qtdHorasAlmoco="
				+ qtyLunch + ", cnpj=" + cnpj + "]";
	}

}
