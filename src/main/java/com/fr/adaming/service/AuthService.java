package com.fr.adaming.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IUserDao;
import com.fr.adaming.entity.User;

@Service
public class AuthService implements IAuthService {

	@Autowired
	private IUserDao dao;
	
	Logger log = Logger.getLogger(AuthService.class);
	
	@Override
	public User login(String email, String pwd) {
		// TODO Auto-generated method stub
		try {
			return dao.findByEmailandPwd(email, pwd);

		} catch (Exception e) {
			// TODO: handle exception
			if (email == null) {
				log.error("DEBUG login() : email est null");
			} 
			else if (pwd == null) {
				log.error("DEBUG login() : pwd est null");
			}
			return null;
		}
		
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		dao.save(user);
	}

}
