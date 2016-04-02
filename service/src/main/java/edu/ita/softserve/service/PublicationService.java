package edu.ita.softserve.service;

import java.util.List;

import edu.ita.softserve.dao.factory.DaoFactory;
import edu.ita.softserve.entity.Adress;
import edu.ita.softserve.entity.Publication;

public class PublicationService {
		
		public void update(final Publication curentPublication, final Publication updatedPublication){
			DaoFactory.getInstance().getPublicationDao().update(updatedPublication);
		}
		
		public void add(Publication publication){
			DaoFactory.getInstance().getPublicationDao().add(publication);
		}
		
		public void delete(Publication publication){
			DaoFactory.getInstance().getPublicationDao().delete(publication);
		}
		
		public List<Publication> getAll(Publication publication){
			return DaoFactory.getInstance().getPublicationDao().getAll();
		}
		
		public Publication getById(long id){
			return DaoFactory.getInstance().getPublicationDao().findById(id);
		}
	}
