package edu.ita.softserve.dao.impl.jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ita.softserve.dao.impl.UserDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.User;



@Repository
@Component
public class JpaUserDao extends JpaGenericDao<User, Long> implements UserDao {
	
	@PersistenceContext//(unitName = "persistenceUnit")
	EntityManager entityManager;
	
	
	public List<User> getAllDeptors() {
		List<User> users = null;
		Query query = entityManager.createNamedQuery("showAllDeptors", User.class);
		users = (List<User>) query.getResultList();
		return users;
	}

	public long timeOfLibraryUsing(User user) {
		Query query = entityManager.createNamedQuery("showRegistrationTime");
		query.setParameter("uId", user.getId());
		Date dateRegistration = (Date) query.getResultList().get(0);
		query = entityManager.createNativeQuery("select curdate()");
		Date curentDate = (Date) query.getResultList().get(0);
		long timeOfUsing = Math.abs(curentDate.getTime() - dateRegistration.getTime()) / (24 * 60 * 60 * 1000);
		return timeOfUsing;
	}

	public double getAvarageAgeUserByBookName(String bookName) {
		Query query = entityManager.createNamedQuery("getAvarageAgeByBookName");
		query.setParameter("bookName", bookName);
		double avagareAge = (Double) query.getResultList().get(0);
		return avagareAge;
	}

	public List<Book> showBooksByUser(User user) {

		return null;
	}

	public long countOfApplicationByTime(Date start, Date end, User user) {
		Query query = entityManager.createNamedQuery("showCountOfApplicatioByTime");
		query.setParameter("start", start);
		query.setParameter("end", end);
		query.setParameter("id", user.getId());
		long count = (Long) query.getResultList().get(0);
		return count;
	}
}
