package com.gcmmogi.gcm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gcmmogi.gcm.entities.Oficial;

public interface OficialRepository extends JpaRepository<Oficial, Long>{

	@Transactional(readOnly=true)
	Oficial findByEmail(String email);
}
