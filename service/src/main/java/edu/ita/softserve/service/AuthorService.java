package edu.ita.softserve.service;

import java.util.List;

import edu.ita.softserve.dao.factory.DaoFactory;
import edu.ita.softserve.entity.Author;

public class AuthorService {
	public void update(final Author currentAuthor, final Author updatedAuthor){
		DaoFactory.getInstance().getAuthorDao().update(updatedAuthor);
	}
	
	public void add(Author author){
		DaoFactory.getInstance().getAuthorDao().add(author);
	}
	
	public void delete(Author author){
		DaoFactory.getInstance().getAuthorDao().delete(author);
	}
	
	public List<Author> getAll(){
		return DaoFactory.getInstance().getAuthorDao().getAll();
	}
	
	public Author getById(long id){
		return DaoFactory.getInstance().getAuthorDao().findById(id);
	}
	
	

}
