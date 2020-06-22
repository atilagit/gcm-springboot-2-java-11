package com.gcmmogi.gcm.entities.enums;

public enum Dano {

	PEQUENA_MONTA(1),
	MEDIA_MONTA(2),
	GRANDE_MONTA(3),
	SEM_DANO(4);

	private int code;

	private Dano(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static Dano valueOf(int code) {
		for (Dano value : Dano.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo de dano nao valido");
	}

}
