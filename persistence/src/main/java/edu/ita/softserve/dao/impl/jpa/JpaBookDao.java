package edu.ita.softserve.dao.impl.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Predicate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.ita.softserve.dao.JPAUtil;
import edu.ita.softserve.dao.impl.AuthorDao;
import edu.ita.softserve.dao.impl.BookDao;
import edu.ita.softserve.dao.impl.InstanceDao;
import edu.ita.softserve.dao.impl.PublicationDao;
import edu.ita.softserve.entity.Author;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;
import edu.ita.softserve.entity.Publication;

@Repository
public class JpaBookDao extends JpaGenericDao<Book, Long> implements BookDao {

	public Book findbyName(String name) {
		EntityManager entityManager = getEntityManager();
		Book book = (Book) entityManager.createQuery("SELECT b FROM Book b where b.name = ?1").setParameter(1, name)
				.getResultList().get(0);
		return book;
	}

	public List<Instance> checkIfAvailable(Book book) {
		EntityManager entityManager = getEntityManager();
		List<Instance> instances = entityManager
				.createQuery("SELECT i FROM Instance i where i.is_available = ?1", Instance.class).setParameter(1, true)
				.getResultList();

		return instances;
	}

	// returns List of books which were published in a specified year
	public List<Book> findbyYear(Integer year) {
		EntityManager entityManager = getEntityManager();
		List<Book> books = entityManager.createQuery("SELECT b FROM Book b where b.year = ?1", Book.class)
				.setParameter(1, year).getResultList();

		return books;
	}

	// overloaded method which returns List of books which were published in the
	// time interval from year1 to year2
	public List<Book> findbyYear(Integer year1, Integer year2) {
		EntityManager entityManager = getEntityManager();
		List<Book> books = entityManager
				.createQuery("SELECT b FROM Book b where b.year >= ?1 AND b.year <= ?2", Book.class)
				.setParameter(1, year1).setParameter(2, year2).getResultList();
		return books;
	}

	/*
	 * public void add(Book book) { EntityManager entityManager =
	 * getEntityManager();
	 * 
	 * 
	 * List<Book> listBook = entityManager .createQuery(
	 * "SELECT b FROM Book b where b.name = ?1 AND b.amountOfPage = ?2 AND b.year = ?3"
	 * , Book.class) .setParameter(1, book.getName()).setParameter(2,
	 * book.getAmountOfPage()).setParameter(3, book.getYear()) .getResultList();
	 * Instance instance = new Instance(); if (listBook.size() == 0) { new
	 * BookDao().add(book); Book bookdb = bookDao.findbyName(book.getName());
	 * instance.setBook(bookdb); } else { instance.setBook(listBook.get(0)); }
	 * instanceDao.add(instance);
	 * 
	 * }
	 */

	@Override
	public void addBook(Book book) {
		EntityManager entityManager = getEntityManager();
		Session session = (Session) entityManager.getDelegate();
		Criteria criteriaBook = session.createCriteria(Book.class);
		criteriaBook.add(Example.create(book));
		
		Book bookDb = (Book) criteriaBook.uniqueResult();
		
		Publication publicationInput = book.getPublication();
		Criteria criteriaPublication = session.createCriteria(Publication.class);
		criteriaPublication.add(Example.create(publicationInput));
		
		Publication publicationData = (Publication) criteriaPublication.uniqueResult();
			
		Author authorInput = book.getAuthor();
		Criteria criteriaAuthor = session.createCriteria(Author.class);
		criteriaAuthor.add(Example.create(book.getAuthor()));
		
		Author authorData = (Author) criteriaAuthor.uniqueResult();

		Instance instance = new Instance();
		
		if(book.equals(bookDb) && publicationInput.equals(publicationData) && authorInput.equals(authorData)){
			instance.setBook(bookDb);
		}else{
			if(publicationInput.equals(publicationData)){
				book.setPublication(publicationData);
			}
			if(authorInput.equals(authorData)){
				book.setAuthor(authorData);
			}
			instance.setBook(book);
		}
		session.save(instance);
	}
}
