package com.yu.ds.service.impl;

import org.springframework.stereotype.Service;

import com.yu.ds.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	public void query() {
		System.out.println("--- query ---");
	}

}
