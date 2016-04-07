package edu.ita.softserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.ita.softserve.dao.impl.InstanceDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;

@Service
public class InstanceService {

	@Autowired
	InstanceDao instanceDao;

	@Autowired
	BookService bookService;

	@Transactional
	public void delete(Instance instance) {
		instanceDao.delete(instance);

	}

	@Transactional
	public void add(Instance instance) {
		instanceDao.add(instance);
	}

	@Transactional
	public Instance findById(Long id) {
		Instance instance = instanceDao.findById(id);
		return instance;
	}

	@Transactional
	public List<Instance> getAll() {
		List<Instance> listOfBooks = instanceDao.getAll();
		return listOfBooks;
	}

	@Transactional
	public List<Instance> findByName(String name) {
		List<Instance> listOfInstance = null;
		Book book = bookService.findbyName(name);
		if (book != null) {
			listOfInstance = instanceDao.findAllInstanceByBook(book);
		}
		return listOfInstance;
	}
	@Transactional
	public void remove(Long id){
		instanceDao.remove(id);
	}
}
