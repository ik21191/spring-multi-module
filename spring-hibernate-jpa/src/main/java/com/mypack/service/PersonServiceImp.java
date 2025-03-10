package com.mypack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mypack.dao.PersonDao;
import com.mypack.entity.PersonEntity;
import com.mypack.model.PersonModel;

/**
 * @author Imran
 *
 */
@Service
public class PersonServiceImp implements PersonService {

  @Autowired
  private PersonDao userDao;

  @Transactional
  @Override
  public void loadSqlSript(String scriptContents) {
    userDao.loadSqlSript(scriptContents);
  }

  @Transactional
  @Override
  public void add(PersonModel personModel) {
    userDao.add(personModel);
  }

  @Transactional(readOnly = true)
  @Override
  public List<PersonEntity> listPersons() {
    return userDao.listPersons();
  }

  @Transactional(readOnly = true)
  @Override
  public PersonModel findPerson(long id) {
    return userDao.findPerson(id);
  }

}
