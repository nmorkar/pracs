package com.pracs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pracs.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	
}
