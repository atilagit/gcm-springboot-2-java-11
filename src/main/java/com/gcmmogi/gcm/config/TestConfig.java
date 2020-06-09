package com.gcmmogi.gcm.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gcmmogi.gcm.entities.BoletimOcorrencia;
import com.gcmmogi.gcm.entities.Oficial;
import com.gcmmogi.gcm.entities.enums.Posto;
import com.gcmmogi.gcm.repositories.BoletimOcorrenciaRepository;
import com.gcmmogi.gcm.repositories.OficialRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private OficialRepository oficialRepository;
	
	@Autowired
	private BoletimOcorrenciaRepository boletimOcorrenciaRepository;

	@Override
	public void run(String... args) throws Exception {

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
