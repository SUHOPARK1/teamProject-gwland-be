package com.tplus.gwland.sec.oauth.provider;

public interface OAuth2UserInfo {
	String getUsername();
	
	String getProviderId();

	String getProvider();

	String getEmail();

	String getAge();

	String getGender();
}
