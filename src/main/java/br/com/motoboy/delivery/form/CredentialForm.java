package br.com.motoboy.delivery.form;

import javax.validation.constraints.NotBlank;

public class CredentialForm {

	@NotBlank(message = "Email não pode ser passado vazio.")
	private String email;

	@NotBlank(message = "Senha não pode ser passada vazia.")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
