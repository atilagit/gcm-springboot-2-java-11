package com.gcmmogi.gcm.entities.enums;

public enum Posto {

	EM_CAMPO(1), 
	ADMINISTRATIVO(2);

	private int code;
	
	private Posto(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Posto valueOf(int code) {
		for (Posto value : Posto.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo de posto inválido");
	}
}
