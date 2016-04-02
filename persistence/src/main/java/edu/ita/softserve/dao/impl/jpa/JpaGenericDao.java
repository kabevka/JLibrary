package edu.ita.softserve.dao.impl.jpa;

import java.lang.reflect.ParameterizedType;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.ita.softserve.dao.GenericDao;
import edu.ita.softserve.dao.JPAUtil;


import edu.ita.softserve.dao.GenericDao;


@Repository
public abstract class JpaGenericDao<T,V> implements GenericDao<T, V> {
	
	private Class<T> entityType;
	 
	@PersistenceContext
	protected EntityManager entityManager = JPAUtil.getEntityManager(); 
	
	@SuppressWarnings("unchecked")
	public JpaGenericDao() {
		ParameterizedType genericSuperClass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityType = (Class<T>) genericSuperClass.getActualTypeArguments()[0];         
	}
	
	public void add(T t) {
		entityManager.persist(t);		
	}
	
	public void delete(T t) {
		entityManager.remove(t);		
	}
	
	public T findById(V id) {
		return entityManager.find(entityType, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query query = entityManager.createQuery(
                "SELECT entity FROM " + entityType.getName() + " entity");
        return query.getResultList();
	}
	
	public void update(T t) {
		entityManager.merge(t);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
