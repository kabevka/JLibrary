package edu.ita.softserve.dao.impl;

import java.util.List;

import edu.ita.softserve.dao.GenericDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;

public interface InstanceDao extends GenericDao<Instance, Long> {
    public List<Instance> findAllInstanceByBook(Book book);
}
