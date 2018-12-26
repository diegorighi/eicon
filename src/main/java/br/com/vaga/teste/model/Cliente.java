package br.com.vaga.teste.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	public Cliente() {}
	
	public Cliente(String email, String primeiroNome, String sobrenome, LocalDate dataNascimento) {
		this.email = email;
		this.primeiroNome = primeiroNome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
	}
	
	@Id
	@NotNull
	@Size(max=1000)
	public String email;

	@NotNull
	public String primeiroNome;
	
	@NotNull
	public String sobrenome;
	
	@NotNull(message = "Data é uma informação obrigatória.")
	public LocalDate dataNascimento;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
