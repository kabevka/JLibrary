package edu.ita.softserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ita.softserve.dao.impl.AuthorDao;
import edu.ita.softserve.entity.Author;

@Service
public class AuthorService {
	@Autowired
	AuthorDao authorDao;

	public void update(final Author currentAuthor, final Author updatedAuthor) {
		authorDao.update(updatedAuthor);
	}

	public void add(Author author) {
		authorDao.add(author);
	}

	public void delete(Author author) {
		authorDao.delete(author);
	}

	public List<Author> getAll() {
		return authorDao.getAll();
	}

	public Author getById(long id) {
		return authorDao.findById(id);
	}

}
