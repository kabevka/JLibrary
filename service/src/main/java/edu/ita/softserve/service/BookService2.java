package edu.ita.softserve.service;

import java.util.List;



import edu.ita.softserve.dao.factory.DaoFactory;
import edu.ita.softserve.entity.Author;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;

public class BookService2 {
    
    public Book findbyName(String name){
    	return DaoFactory.getInstance().getBookDao().findbyName(name);
	
    }   
    
    public Book findById(long id){
	if(id < 0){
	    return null;
	}
	return DaoFactory.getInstance().getBookDao().findById(id);
    }
    
    public void update(final Author currentAuthor, final Author updatedAuthor){
		DaoFactory.getInstance().getAuthorDao().update(updatedAuthor);
	}
	
	public void add(Book book){
		try {DaoFactory.getInstance().getBookDao().add(book);
		}
		catch (javax.persistence.PersistenceException ex){System.out.println("fields Publication, Year and Title are necessary");}
	}
	
	public void delete(Book book){
		DaoFactory.getInstance().getBookDao().delete(book);
	}
	
	
	public Book getById(long id){
		return DaoFactory.getInstance().getBookDao().findById(id);
	}
    
    public List<Book> getAll(){
		return DaoFactory.getInstance().getBookDao().getAll();
    }
    
    public List<Instance> checkIfAvailable(Book book){
    	return DaoFactory.getInstance().getBookDao().checkIfAvailable(book);
    }
    
  //returns List of books which were published in a specified year
  	public List<Book> findbyYear(Integer year) {
  		return DaoFactory.getInstance().getBookDao().findbyYear(year);
  	}
  	
  	//overloaded method which returns List of books which were published in the time interval from year1 to year2
  	public List<Book> findbyYear(Integer year1, Integer year2) {
  		return DaoFactory.getInstance().getBookDao().findbyYear(year1, year2);
  	}
}
