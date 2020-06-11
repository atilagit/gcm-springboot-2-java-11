package com.gcmmogi.gcm.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gcmmogi.gcm.entities.BoletimOcorrencia;
import com.gcmmogi.gcm.entities.Endereco;
import com.gcmmogi.gcm.entities.Envolvido;
import com.gcmmogi.gcm.entities.Oficial;
import com.gcmmogi.gcm.entities.RG;
import com.gcmmogi.gcm.entities.enums.CondicaoDaParte;
import com.gcmmogi.gcm.entities.enums.Posto;
import com.gcmmogi.gcm.repositories.BoletimOcorrenciaRepository;
import com.gcmmogi.gcm.repositories.EnderecoRepository;
import com.gcmmogi.gcm.repositories.EnvolvidoRepository;
import com.gcmmogi.gcm.repositories.OficialRepository;

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
	private EnvolvidoRepository envolvidoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Endereco end1 = new Endereco(null, "Teste residencia1", 21, "Teste bairro1", "Teste Cidade1", "SP", "Teste complemento1");
		Endereco end2 = new Endereco(null, "Teste residencia2", 22, "Teste bairro2", "Teste Cidade2", "MG", "Teste complemento2");
		Endereco end3 = new Endereco(null, "Teste residencia3", 23, "Teste bairro3", "Teste Cidade3", "PA", "Teste complemento3");

		Envolvido env1 = new Envolvido(null, CondicaoDaParte.AUTOR, true, "Ze Lorota", Instant.parse("1980-06-20T19:53:07Z"), "pai do ze", "mae do ze", "Brasileiro", "teste cidade1", "SP", "1988554477", "Açougue", "teste de versao do envolvido1", null, end1);
		Envolvido env2 = new Envolvido(null, CondicaoDaParte.INDICIADO, true, "Joaquim do bar", Instant.parse("1981-06-20T19:53:07Z"), "pai do joaquim", "mae do joaquim", "Brasileiro", "teste cidade2", "SP", "1999554477", "Padaria", "teste de versao do envolvido2", null, end2);
		Envolvido env3 = new Envolvido(null, CondicaoDaParte.PEDESTRE, false, "Mariazinha Silva", Instant.parse("1982-06-20T19:53:07Z"), "pai da maria", "mae da maria", "Brasileiro", "teste cidade3", "SP", "1911554477", "Garçonete", "teste de versao do envolvido3", null, end2);
		Envolvido env4 = new Envolvido(null, CondicaoDaParte.VITIMA, false, "Luquinha Junior", Instant.parse("1983-06-20T19:53:07Z"), "pai do lucas", "mae do lucas", "Brasileiro", "teste cidade4", "SP", "1922554477", null, "teste de versao do envolvido4", null, end3);
		Envolvido env5 = new Envolvido(null, CondicaoDaParte.INDEFINIDA, true, "Joao Doido", Instant.parse("1984-06-20T19:53:07Z"), "pai do joao", "mae do joao", "Brasileiro", "teste cidade5", "SP", "1933554477", "Bombeiro", "teste de versao do envolvido5", null, end3);
		
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		envolvidoRepository.saveAll(Arrays.asList(env1, env2, env3, env4, env5));
		
		RG rg1 = new RG(null, "41.106.298-11", "SSP", "SP", env1);
		RG rg3 = new RG(null, "43.207.298-13", "SSP", "SP", env3);
		RG rg5 = new RG(null, "45.308.298-15", "SSP", "SP", env5);
		
		env1.setRg(rg1);
		env3.setRg(rg3);
		env5.setRg(rg5);
		
		envolvidoRepository.saveAll(Arrays.asList(env1, env3, env5));
		
		Oficial o1 = new Oficial(null, "juca88", "321", "Juca", "Time-B", 6, Posto.EM_CAMPO);
		Oficial o2 = new Oficial(null, "marco87", "222", "Marco", "Time-C", 8, Posto.ADMINISTRATIVO);
		
		BoletimOcorrencia bo1 = new BoletimOcorrencia(null, 4, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 1, 10, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 11256, 11260, 11260, 11260, "local teste", "Relatorio teste", o1);
		BoletimOcorrencia bo2 = new BoletimOcorrencia(null, 5, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 2, 11, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 11256, 11260, 11260, 11260, "local teste", "Relatorio teste", o2);
		BoletimOcorrencia bo3 = new BoletimOcorrencia(null, 6, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 3, 12, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 11256, 11260, 11260, 11260, "local teste", "Relatorio teste", o1);
		
		oficialRepository.saveAll(Arrays.asList(o1, o2));
		boletimOcorrenciaRepository.saveAll(Arrays.asList(bo1, bo2, bo3));
	}
	
	
}
