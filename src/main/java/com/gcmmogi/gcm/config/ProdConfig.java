package com.gcmmogi.gcm.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gcmmogi.gcm.entities.Bairro;
import com.gcmmogi.gcm.entities.Ocorrencia;
import com.gcmmogi.gcm.entities.Oficial;
import com.gcmmogi.gcm.entities.enums.Posto;
import com.gcmmogi.gcm.repositories.BairroRepository;
import com.gcmmogi.gcm.repositories.OcorrenciaRepository;
import com.gcmmogi.gcm.repositories.OficialRepository;

@Configuration
@Profile("prod")
public class ProdConfig implements CommandLineRunner{
	
	@Autowired
	private OficialRepository oficialRepository;
	
	@Autowired
	private BairroRepository bairroRepository;
	
	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;

	@Override
	public void run(String... args) throws Exception {	
		if(bairroRepository.count()==0 && oficialRepository.count()==0) {
			Oficial o1 = new Oficial(null, "juca88", "321", "Juca", "Time-B", 6, Posto.EM_CAMPO, "juca@hotmail.com");
			Oficial o2 = new Oficial(null, "marco87", "222", "Marco", "Time-C", 8, Posto.ADMINISTRATIVO, "marco@gmail.com");
			oficialRepository.saveAll(Arrays.asList(o1, o2));
			
			List<Bairro> bairros = ConfiguracaoBD.populaBairros();
			bairroRepository.saveAll(bairros);
			
			List<Ocorrencia> ocorrencias = ConfiguracaoBD.populaOcorrencias();
			ocorrenciaRepository.saveAll(ocorrencias);
		}
	}
}
