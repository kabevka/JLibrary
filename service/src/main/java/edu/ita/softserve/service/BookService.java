package edu.ita.softserve.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ita.softserve.dao.JPAUtil;
import edu.ita.softserve.dao.factory.DaoFactory;
import edu.ita.softserve.dao.impl.BookDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;

@Service

public class BookService {
	
	@Autowired
	BookDao bookDao;
	@Transactional
    public Book findbyName(String name){
    Book book = bookDao.findbyName(name);
	return book;
    }
	@Transactional
    public void add(Book book){
	/*EntityManager entityManager = JPAUtil.getEntityManager();
	List<Book> listBook = entityManager.createQuery("SELECT b FROM Book b where b.name = ?1 AND b.amountOfPage = ?2 AND b.year = ?3", Book.class).
		setParameter(1, book.getName()).setParameter(2, book.getAmountOfPage()).setParameter(3, book.getYear()).getResultList();
	Instance instance = new Instance();
	if(listBook.size() == 0){
	    DaoFactory.getInstance().getBookDao().add(book);   
	    instance.setBook(book);
 	} else{
 	    instance.setBook(listBook.get(0));
	}
	    DaoFactory.getInstance().getInstanceDao().add(instance);*/
    	bookDao.add(book);
    }
	@Transactional
    public Book findById(long id){
	if(id < 0){
	    return null;
	}
	Book book = bookDao.findById(id);
	return book;
    }
	@Transactional
     public List<Book> getAll(){
	List<Book> listOfBooks = bookDao.getAll();
	return listOfBooks;
    }
    
}
