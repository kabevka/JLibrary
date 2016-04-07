package edu.ita.softserve.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ita.softserve.dao.JPAUtil;
import edu.ita.softserve.dao.impl.BookDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;

@Service
public class BookService {

	@Autowired
	BookDao bookDao;

	@Transactional
	public Book findbyName(String name) {
		Book book = bookDao.findbyName(name);
		return book;
	}

	@Transactional
	public void add(Book book) {
		bookDao.add(book);
	}

	@Transactional
	public Book findById(long id) {
		Book book = bookDao.findById(id);
		return book;
	}

	@Transactional
	public List<Book> getAll() {
		List<Book> listOfBooks = bookDao.getAll();
		return listOfBooks;
	}
	@Transactional
	public void addBook(Book book){
		bookDao.addBook(book);
	}

}
