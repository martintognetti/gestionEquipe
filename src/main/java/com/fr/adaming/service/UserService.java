package com.fr.adaming.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IUserDao;
import com.fr.adaming.entity.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao dao;

	private Logger log = Logger.getLogger(UserService.class);
	
	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		if(user.getId() == null || user.getId()==0) {
			user = dao.save(user);
			System.out.println("DEBUG  CREATE : ID non existant");
			log.info("Utilisateur créé");
			return user;
		}else {
			if(dao.existsById(user.getId())) {
				log.debug("L'objet User a un ID différent de null");
				return null;
			}else {
				user = dao.save(user);
				log.info("L'utilisateur a été créé avec succès");
				return user;
			}
		}
		
	}

	@Override
	public User readById(long id) {
		User res = null;
		try {
			res = dao.findById(id).get();
		} catch (Exception e) {
			if(e instanceof IllegalArgumentException) {
				log.info("ID est null ! Opération non effectuée");
			} else {
				log.error(e.getStackTrace());
			}
		}
		return res;
		
	}

	@Override
	public List<User> readAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void update(User user) {
		if(user.getId() == null) {
			System.out.println("DEBUG UPDATE : id non existant");
		}else {
			if(dao.existsById(user.getId())) {
				dao.save(user);
				System.out.println("DEBUG : MAJ du USER");
			}else {
				System.out.println("DEBUG UPDATE : MAJ non possible");
			}
		}
		
		
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		try {
			dao.delete(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return !dao.existsById(user.getId());
		
	}
	
	
}
