package edu.ita.softserve.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import edu.ita.softserve.dao.JPAUtil;
import edu.ita.softserve.dao.impl.PublicationDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Publication;
@Repository
public class JpaPublicationDao extends JpaGenericDao<Publication, Long> implements PublicationDao{

	public List<Book> findAllBooksByPublication(Publication publication) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		List<Book> bookList = entityManager.createQuery("SELECT b FROM Book b where b.publication = ?", Book.class)
                .setParameter(1, publication).getResultList();
	return bookList;
	}

}
