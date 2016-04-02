package edu.ita.softserve.service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.ita.softserve.dao.JPAUtil;
import edu.ita.softserve.dao.factory.DaoFactory;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;

public class BookService {
    
    public Book findbyName(String name){
	Book book = DaoFactory.getInstance().getBookDao().findbyName(name);
	return book;
    }
    
    public void add(Book book){
	EntityManager entityManager = JPAUtil.getEntityManager();
	List<Book> listBook = entityManager.createQuery("SELECT b FROM Book b where b.name = ?1 AND b.amountOfPage = ?2 AND b.year = ?3", Book.class).
		setParameter(1, book.getName()).setParameter(2, book.getAmountOfPage()).setParameter(3, book.getYear()).getResultList();
	Instance instance = new Instance();
	if(listBook.size() == 0){
	    DaoFactory.getInstance().getBookDao().add(book);   
	    instance.setBook(book);
 	} else{
 	    instance.setBook(listBook.get(0));
	}
	    DaoFactory.getInstance().getInstanceDao().add(instance);
    }
    
    public Book findById(long id){
	if(id < 0){
	    return null;
	}
	Book book = DaoFactory.getInstance().getBookDao().findById(id);
	return book;
    }
     public List<Book> getAll(){
	List<Book> listOfBooks =  DaoFactory.getInstance().getBookDao().getAll();
	return listOfBooks;
    }
    
}
