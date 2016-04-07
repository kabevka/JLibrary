package edu.ita.softserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ita.softserve.dao.impl.PublicationDao;
import edu.ita.softserve.entity.Publication;

@Service
public class PublicationService {
	
	@Autowired
	PublicationDao publicationDao;
		
		public void update(final Publication curentPublication, final Publication updatedPublication){
			publicationDao.update(updatedPublication);
		}
		
		public void add(Publication publication){
			publicationDao.add(publication);
		}
		
		public void delete(Publication publication){
			publicationDao.delete(publication);
		}
		
		public List<Publication> getAll(Publication publication){
			return publicationDao.getAll();
		}
		
		public Publication getById(long id){
			return publicationDao.findById(id);
		}
	}