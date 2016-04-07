package edu.ita.softserve.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ita.softserve.dao.GenericDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Publication;
@Repository
public interface PublicationDao extends GenericDao<Publication, Long> {
    public List<Book> findAllBooksByPublication(Publication publication);
    }