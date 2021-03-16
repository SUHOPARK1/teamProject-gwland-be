package com.tplus.gwland.sec.provider;

import java.util.Map;

public class NaverUserInfo extends OAuth2UserInfo{
	public NaverUserInfo(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getId() {
		return (String)attributes.get("id");
	}

	@Override
	public String getName() {
		return (String)attributes.get("name");
	}

	@Override
	public String getEmail() {
		return (String)attributes.get("email");
	}
	
	@Override
	public String getGender() {
		return (String) attributes.get("gender");
	}
	
	@Override
	public String getAge() {
		return (String) attributes.get("age");
	}

	@Override
	public String getUsername() {
		return "Naver_"+(String)attributes.get("id");
	}
}
