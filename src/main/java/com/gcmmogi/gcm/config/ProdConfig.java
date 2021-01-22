package com.gcmmogi.gcm.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gcmmogi.gcm.entities.Bairro;
import com.gcmmogi.gcm.entities.Ocorrencia;
import com.gcmmogi.gcm.entities.Oficial;
import com.gcmmogi.gcm.entities.enums.Perfil;
import com.gcmmogi.gcm.repositories.BairroRepository;
import com.gcmmogi.gcm.repositories.OcorrenciaRepository;
import com.gcmmogi.gcm.repositories.OficialRepository;

@Configuration
@Profile("prod")
public class ProdConfig implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private OficialRepository oficialRepository;
	
	@Autowired
	private BairroRepository bairroRepository;
	
	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;

	@Override
	public void run(String... args) throws Exception {	
		if(bairroRepository.count()==0 && oficialRepository.count()==0) {
			Set<Perfil> perfilSimples = new HashSet<>();
			perfilSimples.add(Perfil.EM_CAMPO);
			Set<Perfil> perfilAdm = new HashSet<>();
			perfilAdm.addAll(Arrays.asList(Perfil.EM_CAMPO, Perfil.ADMINISTRATIVO));
			Oficial o1 = new Oficial(null, "admin", pe.encode("321"), "GCM APP Admin", "adm", 0, "gcm.app.mogimirim@gmail.com", perfilAdm);
			oficialRepository.saveAll(Arrays.asList(o1));
			
			List<Bairro> bairros = ConfiguracaoBD.populaBairros();
			bairroRepository.saveAll(bairros);
			
			List<Ocorrencia> ocorrencias = ConfiguracaoBD.populaOcorrencias();
			ocorrenciaRepository.saveAll(ocorrencias);
		}
	}
}
