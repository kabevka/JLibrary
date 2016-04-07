package edu.ita.softserve.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ita.softserve.dao.JPAUtil;
import edu.ita.softserve.dao.impl.InstanceDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;

@Repository
public class JpaInstanceDao extends JpaGenericDao<Instance, Long> implements InstanceDao{

    public List<Instance> findAllInstanceByBook(Book book) {
	EntityManager entityManager = getEntityManager();
	List<Instance> instances = entityManager.createQuery("SELECT i FROM Instance i where i.book = ?1", Instance.class)
                .setParameter(1, book).getResultList();
	return instances;
    }
    @Override
    public void remove(Long id){
    	EntityManager entityManager = getEntityManager();
    	Instance instance = entityManager.find(Instance.class, id);
    	System.out.println("****************instance = " + instance);
    	entityManager.remove(instance);
    }
}
