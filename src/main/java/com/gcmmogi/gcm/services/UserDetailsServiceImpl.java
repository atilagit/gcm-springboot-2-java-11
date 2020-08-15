package com.gcmmogi.gcm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.Oficial;
import com.gcmmogi.gcm.repositories.OficialRepository;
import com.gcmmogi.gcm.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private OficialRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Oficial oficial = repo.findByEmail(email);
		if(oficial == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(oficial.getId(), oficial.getEmail(), oficial.getSenha(), oficial.getPerfis());
	}
}
