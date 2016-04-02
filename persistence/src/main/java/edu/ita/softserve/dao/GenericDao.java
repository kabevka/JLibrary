package edu.ita.softserve.dao;

import java.util.List;
/***
 * This interface describes Generic Dao.
 * 
 * @author Volodymyr
 *
 * @param <T>
 * 		Type of entity class
 * @param <V>
 * 		Id Type
 */
public interface GenericDao<T,V> {
	
	/**
	 * 
	 * Add a new entity
	 * 
	 * @param t
	 * 		entity to be added
	 */
	void add(T t);
	
	/***
	 *Find entity by id param
	 * 
	 * @param
	 * 		Find object by id
	 */
	T findById(V id);
	
	/***
	 * Update entity information
	 * 
	 * @param t
	 * 		object t to be updated
	 * 
	 */
	void update(T t);
	
	/***
	 * 
	 * Delete object
	 * 
	 * @param t
	 * 		object to be deleted
	 * 
	 */
	void delete(T t);
	
	/***
	 * 
	 * Get all objects
	 * 
	 * @return list all objects
	 */
	List<T> getAll();
 
}
