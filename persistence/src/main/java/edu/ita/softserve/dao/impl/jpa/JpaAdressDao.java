package edu.ita.softserve.dao.impl.jpa;

import org.springframework.stereotype.Repository;

import edu.ita.softserve.dao.impl.AdressDao;
import edu.ita.softserve.entity.Adress;
@Repository
public class JpaAdressDao extends JpaGenericDao<Adress, Long> implements AdressDao {

}
