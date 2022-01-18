package br.com.motoboy.delivery.models;

public class ApiConfig {

	private String jwtSecret;
	private Integer jwtExpirationInMinutes;
	public String getJwtSecret() {
		return jwtSecret;
	}
	public void setJwtSecret(String jwtSecret) {
		this.jwtSecret = jwtSecret;
	}
	public Integer getJwtExpirationInMinutes() {
		return jwtExpirationInMinutes;
	}
	public void setJwtExpirationInMinutes(Integer jwtExpirationInMinutes) {
		this.jwtExpirationInMinutes = jwtExpirationInMinutes;
	}
	
	
}
