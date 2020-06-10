package com.gcmmogi.gcm.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gcmmogi.gcm.entities.BoletimOcorrencia;
import com.gcmmogi.gcm.entities.Endereco;
import com.gcmmogi.gcm.entities.Oficial;
import com.gcmmogi.gcm.entities.RG;
import com.gcmmogi.gcm.entities.enums.Posto;
import com.gcmmogi.gcm.repositories.BoletimOcorrenciaRepository;
import com.gcmmogi.gcm.repositories.EnderecoRepository;
import com.gcmmogi.gcm.repositories.OficialRepository;
import com.gcmmogi.gcm.repositories.RGRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private OficialRepository oficialRepository;
	
	@Autowired
	private BoletimOcorrenciaRepository boletimOcorrenciaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private RGRepository rgRepository;

	@Override
	public void run(String... args) throws Exception {
		
		RG rg1 = new RG(null, "41.106.298-11", "SSP", "SP");
		RG rg2 = new RG(null, "42.207.298-12", "SSP", "SP");
		RG rg3 = new RG(null, "43.308.298-13", "SSP", "SP");
		RG rg4 = new RG(null, "44.409.298-x", "SSP", "SP");
		RG rg5 = new RG(null, "45.510.298-15", "SSP", "SP");
		
		rgRepository.saveAll(Arrays.asList(rg1, rg2, rg3, rg4, rg5));
		
		Endereco end1 = new Endereco(null, "Teste residencia1", 21, "Teste bairro1", "Teste Cidade1", "SP", "Teste complemento1");
		Endereco end2 = new Endereco(null, "Teste residencia2", 21, "Teste bairro2", "Teste Cidade2", "MG", "Teste complemento2");
		Endereco end3 = new Endereco(null, "Teste residencia3", 21, "Teste bairro3", "Teste Cidade3", "PA", "Teste complemento3");

		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		
		Oficial o1 = new Oficial(null, "juca88", "321", "Juca", "Time-B", 6, Posto.EM_CAMPO);
		Oficial o2 = new Oficial(null, "marco87", "222", "Marco", "Time-C", 8, Posto.ADMINISTRATIVO);
		
		//Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		BoletimOcorrencia bo1 = new BoletimOcorrencia(null, 4, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 1, 10, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), "km teste 1", "km teste 1", "km teste 1", "km teste 1", "local teste", "Relatorio teste", o1);
		BoletimOcorrencia bo2 = new BoletimOcorrencia(null, 5, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 2, 11, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), "km teste 2", "km teste 2", "km teste 2", "km teste 2", "local teste", "Relatorio teste", o2);
		BoletimOcorrencia bo3 = new BoletimOcorrencia(null, 6, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 3, 12, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), "km teste 3", "km teste 3", "km teste 3", "km teste 3", "local teste", "Relatorio teste", o1);
		
		oficialRepository.saveAll(Arrays.asList(o1, o2));
		boletimOcorrenciaRepository.saveAll(Arrays.asList(bo1, bo2, bo3));
	}
	
	
}
