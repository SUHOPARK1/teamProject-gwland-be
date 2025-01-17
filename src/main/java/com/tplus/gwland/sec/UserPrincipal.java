package com.tplus.gwland.sec;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.tplus.gwland.usr.domian.User;


public class UserPrincipal implements UserDetails, OAuth2User {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String email;
	private Collection<? extends GrantedAuthority> authorities;
	private Map<String, Object> attributes;

	public UserPrincipal(Long id, String email, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.email = email;
		this.authorities = authorities;
	}

	public static UserPrincipal create(User user) {
		List<GrantedAuthority> authorities = Collections.
				singletonList(new SimpleGrantedAuthority("ROLE_USER"));

		return new UserPrincipal(
				user.getNum(),
				user.getEmail(),
				authorities
		);
	}

	public static UserPrincipal create(User user, Map<String, Object> attributes) {
		UserPrincipal userPrincipal = UserPrincipal.create(user);
		userPrincipal.setAttributes(attributes);
		return userPrincipal;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String getName() {
		return String.valueOf(id);
	}
}