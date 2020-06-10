package com.gcmmogi.gcm.entities.enums;

public enum CondicaoDaParte {

	VITIMA(1),
	AUTOR(2),
	INDICIADO(3),
	SINDICADO(4),
	TESTEMUNHA(5),
	CONDUTOR(6),
	PROPRIETARIO(7),
	PASSAGEIRO(8),
	PEDESTRE(9),
	PARTE(10),
	INDEFINIDA(11);
	
	private int code;
	
	private CondicaoDaParte(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static CondicaoDaParte valueOf(int code) {
		for (CondicaoDaParte value : CondicaoDaParte.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo de condicao da parte inválido");
	}
}
