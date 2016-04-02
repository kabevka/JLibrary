package edu.ita.softserve.service;

import java.sql.Date;
import java.util.List;

import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ita.softserve.dao.factory.DaoFactory;
import edu.ita.softserve.dao.impl.jpa.JpaUserDao;
import edu.ita.softserve.entity.User;


@Service
public class UserService {
	
	@Autowired
	JpaUserDao jpauserDao = new JpaUserDao();
	
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
		jpauserDao.update(updatedUser);
	}
	@Transactional
	public void delete(User user) {
		jpauserDao.delete(user);
	}
	@Transactional
	public void add(User user) {
		new JpaUserDao().add(user);
	}

	public User findById(long id) {
		return jpauserDao.findById(id);
	}

	public List<User> getAll() {
		return jpauserDao.getAll();
	}

	public double getAvarageAgeByBookName(String bookName) {	
		return jpauserDao.getAvarageAgeUserByBookName(bookName);
	}

	public List<User> getAllDeptors() {
		return jpauserDao.getAllDeptors();
	}

	public long timeOfLibraryUsing(User user) {
		return jpauserDao.timeOfLibraryUsing(user);
	}
	
	public long countOfApplicationByTime(Date start, Date end, User user) {
		start.setYear(start.getYear()-1900);
		start.setMonth(start.getMonth()-1);
		start.setYear(end.getYear()-1900);
		start.setMonth(end.getMonth()-1);
		return jpauserDao.countOfApplicationByTime(start, end, user);
	}
}
