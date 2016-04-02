package edu.ita.softserve.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import edu.ita.softserve.dao.JPAUtil;
import edu.ita.softserve.dao.impl.InstanceDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;


public class JpaInstanceDao extends JpaGenericDao<Instance, Long> implements InstanceDao{

    public List<Instance> findAllInstanceByBook(Book book) {
	EntityManager entityManager = JPAUtil.getEntityManager();
	List<Instance> instances = entityManager.createQuery("SELECT i FROM Instance i where i.book = ?1", Instance.class)
                .setParameter(1, book).getResultList();
	return instances;
    }

}
