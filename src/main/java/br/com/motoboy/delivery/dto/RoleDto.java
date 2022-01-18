package br.com.motoboy.delivery.dto;

import br.com.motoboy.delivery.models.Role;

public class RoleDto {

	private String name;

	public RoleDto(Role role) {
		this.name = role.getName();
	}

	public static RoleDto convert(Role role) {
		return new RoleDto(role);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
