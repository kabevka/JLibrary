package edu.ita.softserve.dao.factory;

import edu.ita.softserve.dao.impl.AdressDao;
import edu.ita.softserve.dao.impl.AuthorDao;
import edu.ita.softserve.dao.impl.BookDao;
import edu.ita.softserve.dao.impl.InstanceDao;
import edu.ita.softserve.dao.impl.PublicationDao;
import edu.ita.softserve.dao.impl.UserDao;
import edu.ita.softserve.dao.impl.jpa.JpaAdressDao;
import edu.ita.softserve.dao.impl.jpa.JpaAuthorDao;
import edu.ita.softserve.dao.impl.jpa.JpaBookDao;
import edu.ita.softserve.dao.impl.jpa.JpaInstanceDao;
import edu.ita.softserve.dao.impl.jpa.JpaPublicationDao;
import edu.ita.softserve.dao.impl.jpa.JpaUserDao;

public class DaoFactory {
	
	private AdressDao adressDao = null;
	private UserDao userDao = null;
	private BookDao bookDao = null;
	private InstanceDao instanceDao = null;
	private AuthorDao authorDao = null;
	private PublicationDao publicationDao = null;
	
	private static DaoFactory instance = null;
	
	private DaoFactory(){
		adressDao = new JpaAdressDao();
		userDao = new JpaUserDao();
		bookDao = new JpaBookDao();
		instanceDao = new JpaInstanceDao();
		authorDao = new JpaAuthorDao();
		publicationDao = new JpaPublicationDao();
	}
	
	public static synchronized DaoFactory getInstance(){
		if(instance == null){
			instance = new DaoFactory();
		}
		return instance;
	}
	
	public AdressDao getAdressDao(){
		return adressDao;
	}
	
	public  UserDao getUserDao(){
		return userDao;
	}
	
	public BookDao getBookDao() {
	    return bookDao;
	}

	public InstanceDao getInstanceDao() {
	    return instanceDao;
	}

	public AuthorDao getAuthorDao() {
		return authorDao;
	}

	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	public PublicationDao getPublicationDao() {
		return publicationDao;
	}

	public void setPublicationDao(PublicationDao publicationDao) {
		this.publicationDao = publicationDao;
	}

	public void setAdressDao(AdressDao adressDao) {
		this.adressDao = adressDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void setInstanceDao(InstanceDao instanceDao) {
		this.instanceDao = instanceDao;
	}
	
	
}
