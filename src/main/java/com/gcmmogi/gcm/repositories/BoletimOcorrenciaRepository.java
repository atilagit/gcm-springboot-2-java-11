package com.gcmmogi.gcm.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gcmmogi.gcm.entities.BoletimOcorrencia;
import com.gcmmogi.gcm.entities.Oficial;

public interface BoletimOcorrenciaRepository extends JpaRepository<BoletimOcorrencia, Long>{
	
	@Transactional(readOnly=true)
	List<BoletimOcorrencia> findFirst10ByOficial(Oficial oficial, Sort sort);
}
