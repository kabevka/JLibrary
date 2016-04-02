package edu.ita.softserve.service;

import java.util.List;

import edu.ita.softserve.dao.factory.DaoFactory;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;

public class InstanceService {
    
    public void delete(Instance instance) {
	DaoFactory.getInstance().getInstanceDao().delete(instance);
	List<Instance> listOfIns = DaoFactory.getInstance().getInstanceDao().findAllInstanceByBook(instance.getBook());
	if(listOfIns.size() == 0){
	    DaoFactory.getInstance().getBookDao().delete(instance.getBook());
	}
    }
    
    public void add(Instance instance){
	 DaoFactory.getInstance().getInstanceDao().add(instance);
    }
    
    public Instance findById(long id){
	if(id < 0){
	    return null;
	}
	Instance instance = DaoFactory.getInstance().getInstanceDao().findById(id);
	return instance;
    }
    
     public List<Instance> getAll(){
	List<Instance> listOfBooks =  DaoFactory.getInstance().getInstanceDao().getAll();
	return listOfBooks;
     }
     
     public List<Instance> findByName(String name){
	 List<Instance> listOfInstance = null;
	 Book book = new BookService().findbyName(name);
	 if(book != null){
	     listOfInstance = DaoFactory.getInstance().getInstanceDao().findAllInstanceByBook(book);
	 }
	 return listOfInstance;
     }
}
