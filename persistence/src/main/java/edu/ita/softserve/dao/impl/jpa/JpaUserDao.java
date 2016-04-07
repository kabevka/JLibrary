package edu.ita.softserve.dao.impl.jpa;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.ita.softserve.dao.impl.UserDao;
import edu.ita.softserve.entity.User;

@Repository
public class JpaUserDao extends JpaGenericDao<User, Long> implements UserDao {
	
	@Override
	public User getUserByAllName(String firstName, String secondName ) {
		Query query = getEntityManager().createNamedQuery("showUserByAllName");
		query.setParameter("fName", firstName);
		query.setParameter("sName", secondName);
		User user = (User) query.getResultList().get(0);
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllDeptors() {
		List<User> users = null;
		Query query = getEntityManager().createNamedQuery("showAllDeptors", User.class);
		users = (List<User>) query.getResultList();
		return users;
	}

	public long timeOfLibraryUsing(User user) {
		Query query = getEntityManager().createNamedQuery("showRegistrationTime");
		query.setParameter("uId", user.getId());
		Date dateRegistration = (Date) query.getResultList().get(0);
		query = getEntityManager().createNativeQuery("select curdate()");
		Date curentDate = (Date) query.getResultList().get(0);
		long timeOfUsing = Math.abs(curentDate.getTime() - dateRegistration.getTime()) / (24 * 60 * 60 * 1000);
		return timeOfUsing;
	}

	public double getAvarageAgeUserByBookName(String bookName) {
		Query query = getEntityManager().createNamedQuery("getAvarageAgeByBookName");
		query.setParameter("bookName", bookName);
		double avagareAge = (Double) query.getResultList().get(0);
		return avagareAge;
	}

	public long countOfApplicationByTime(Date start, Date end, User user) {
		Query query = getEntityManager().createNamedQuery("showCountOfApplicatioByTime");
		query.setParameter("start", start);
		query.setParameter("end", end);
		query.setParameter("id", user.getId());
		long count = (Long) query.getResultList().get(0);
		return count;
	}
}
