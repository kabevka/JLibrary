package edu.ita.softserve.dao.impl;

import java.util.List;

import edu.ita.softserve.dao.GenericDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;

public interface BookDao extends GenericDao<Book, Long> {
public Book findbyName(String name);
public List<Instance> checkIfAvailable(Book book);
public List<Book> findbyYear(Integer year);
public List<Book> findbyYear(Integer year1, Integer year2);
}
