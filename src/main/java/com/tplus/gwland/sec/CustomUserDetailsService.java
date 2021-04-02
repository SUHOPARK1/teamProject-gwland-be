package com.tplus.gwland.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.tplus.gwland.usr.domian.User;
import com.tplus.gwland.usr.repository.UserRepository;

@Service 
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			return null;
		}else {
			return UserPrincipal.create(user);
		}
	}

	public UserDetails loadUserById(Long id){
		User user = userRepository.findById(id).orElse(null);
		if(user == null) {
			return null;
		}else {
			return UserPrincipal.create(user);
		}
	}
}