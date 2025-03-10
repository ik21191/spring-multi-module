package com.mypack.dao;

import java.util.List;

import com.mypack.entity.PersonEntity;
import com.mypack.model.PersonModel;

public interface PersonDao {
  void add(PersonModel personModel);

  List<PersonEntity> listPersons();

  public PersonModel findPerson(long id);

  void loadSqlSript(String filePath);
}
