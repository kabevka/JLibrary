package edu.ita.softserve.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import edu.ita.softserve.dao.JPAUtil;
import edu.ita.softserve.dao.impl.BookDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;

public class JpaBookDao extends JpaGenericDao<Book, Long> implements BookDao{

    public Book findbyName(String name) {
	EntityManager entityManager = JPAUtil.getEntityManager();
	Book book = (Book) entityManager.createQuery("SELECT b FROM Book b where b.name = ?1").setParameter(1, name).getSingleResult();
	return book;
    }

	public List<Instance> checkIfAvailable(Book book) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		List<Instance> instances = entityManager.createQuery("SELECT i FROM Instance i where i.is_available = ?1", Instance.class)
                .setParameter(1, true).getResultList();
		
	return  instances;
	}
	

	//returns List of books which were published in a specified year
	public List<Book> findbyYear(Integer year) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		List<Book> books = entityManager.createQuery("SELECT b FROM Book b where b.year = ?1", Book.class)
				 .setParameter(1, year).getResultList();
		
	return  books;
	}
	
	//overloaded method which returns List of books which were published in the time interval from year1 to year2
	public List<Book> findbyYear(Integer year1, Integer year2) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		List<Book> books = entityManager.createQuery("SELECT b FROM Book b where b.year >= ?1 AND b.year <= ?2", Book.class)
				 .setParameter(1, year1).setParameter(2, year2).getResultList();
			return  books;
	}

}
