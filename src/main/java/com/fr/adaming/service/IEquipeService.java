package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.entity.Equipe;


public interface IEquipeService {

	public void create(Equipe equipe);
	public Equipe readById (long id);
	public List<Equipe> readAll();
	public void update(Equipe equipe);
	public void delete(Equipe equipe);
}
