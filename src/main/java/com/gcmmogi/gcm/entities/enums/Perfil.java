package com.gcmmogi.gcm.entities.enums;

public enum Perfil {

	EM_CAMPO(1, "ROLE_EM_CAMPO"), 
	ADMINISTRATIVO(2, "ROLE_CLIENTE");

	private Integer code;
	private String descricao;
	
	private Perfil(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil valueOf(Integer code) {
		if(code == null) return null;
		for (Perfil value : Perfil.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo de posto inválido");
	}
}
