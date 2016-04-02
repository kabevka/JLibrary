package edu.ita.softserve.dao.impl;

import java.sql.Date;
import java.util.List;

import edu.ita.softserve.dao.GenericDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.User;

public interface UserDao extends GenericDao<User, Long> {
	
	List<User> getAllDeptors();
	List<Book> showBooksByUser(User user);
	long timeOfLibraryUsing(User user);
	double getAvarageAgeUserByBookName(String bookName);
	long countOfApplicationByTime(Date start, Date end,User user);

}
