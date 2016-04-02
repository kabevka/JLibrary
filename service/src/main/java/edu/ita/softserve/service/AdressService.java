package edu.ita.softserve.service;

import java.util.List;

import edu.ita.softserve.dao.factory.DaoFactory;
import edu.ita.softserve.entity.Adress;

public class AdressService {
	
	public void update(final Adress curentAdress, final Adress updatedAdress){
		DaoFactory.getInstance().getAdressDao().update(updatedAdress);
	}
	
	public void add(Adress adress){
		DaoFactory.getInstance().getAdressDao().add(adress);
	}
	
	public void delete(Adress adress){
		DaoFactory.getInstance().getAdressDao().delete(adress);
	}
	
	public List<Adress> getAll(Adress adress){
		return DaoFactory.getInstance().getAdressDao().getAll();
	}
	
	public Adress getById(long id){
		return DaoFactory.getInstance().getAdressDao().findById(id);
	}
}
