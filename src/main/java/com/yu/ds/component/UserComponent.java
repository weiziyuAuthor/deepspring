package com.yu.ds.component;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
