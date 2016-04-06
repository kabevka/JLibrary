package edu.ita.softserve.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import edu.ita.softserve.dao.JPAUtil;
import edu.ita.softserve.dao.impl.AuthorDao;
import edu.ita.softserve.entity.Author;
import edu.ita.softserve.entity.Book;
@Repository
public class JpaAuthorDao extends JpaGenericDao<Author, Long> implements AuthorDao{

   

	public List<Book> findAllBooksByAutor(Author author) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		List<Book> bookList = entityManager.createQuery("SELECT b FROM Book b where b.author = ?1", Book.class)
	                .setParameter(1, author).getResultList();
		return  bookList;
	}

}