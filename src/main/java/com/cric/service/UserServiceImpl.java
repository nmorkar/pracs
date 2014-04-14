package com.cric.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cric.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	
}
