package edu.ita.softserve.service;

import java.sql.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ita.softserve.dao.impl.UserDao;
import edu.ita.softserve.dao.impl.jpa.JpaUserDao;
import edu.ita.softserve.entity.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao ;
	
	@Transactional
	public void update(final User curentUser, final User updatedUser) {
		if (!curentUser.getFirstName().equals("") & curentUser.getFirstName() != null) {
			updatedUser.setFirstName(curentUser.getFirstName());
		}
		if (!curentUser.getSecondName().equals("") & curentUser != null) {
			updatedUser.setSecondName(curentUser.getSecondName());
		}
		if (curentUser.getTelephoneNumber() != 0) {
			updatedUser.setTelephoneNumber(curentUser.getTelephoneNumber());
		}
		if ((curentUser.getDateOfRegistration() != null)) {
			updatedUser.setDateOfRegistration(curentUser.getDateOfRegistration());
		}
		if ((curentUser.getAdress() != null)) {
			updatedUser.setAdress(curentUser.getAdress());
		}
		userDao.update(updatedUser);
	}
	@Transactional
	public void delete(User user) {
		userDao.delete(user);
	}
	@Transactional
	public void add(User user) {
		userDao.add(user);
	}

	public User findById(long id) {
		return userDao.findById(id);
	}

	public List<User> getAll() {
		return userDao.getAll();
	}

	public double getAvarageAgeByBookName(String bookName) {	
		return userDao.getAvarageAgeUserByBookName(bookName);
	}

	public List<User> getAllDeptors() {
		return userDao.getAllDeptors();
	}

	public long timeOfLibraryUsing(User user) {
		return userDao.timeOfLibraryUsing(user);
	}
	
	public long countOfApplicationByTime(Date start, Date end, User user) {
		return userDao.countOfApplicationByTime(start, end, user);
	}
	
	public User getUserByAllName(String firstName, String secondName) {
		return userDao.getUserByAllName(firstName,secondName);
	}
}
