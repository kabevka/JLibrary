package edu.ita.softserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.ita.softserve.dao.impl.AdressDao;
import edu.ita.softserve.entity.Adress;

public class AdressService {
	@Autowired
	AdressDao adressDao;
	
	public void update(final Adress curentAdress, final Adress updatedAdress){
		adressDao.update(updatedAdress);
	}
	
	public void add(Adress adress){
		adressDao.add(adress);
	}
	
	public void delete(Adress adress){
		adressDao.delete(adress);
	}
	
	public List<Adress> getAll(Adress adress){
		return adressDao.getAll();
	}
	
	public Adress getById(long id){
		return adressDao.findById(id);
	}
}
