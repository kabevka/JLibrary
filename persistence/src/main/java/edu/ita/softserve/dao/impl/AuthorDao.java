package edu.ita.softserve.dao.impl;

import java.util.List;

import edu.ita.softserve.dao.GenericDao;
import edu.ita.softserve.entity.Author;
import edu.ita.softserve.entity.Book;

public interface AuthorDao extends GenericDao<Author, Long> {
    public List<Book> findAllBooksByAutor(Author author);
}