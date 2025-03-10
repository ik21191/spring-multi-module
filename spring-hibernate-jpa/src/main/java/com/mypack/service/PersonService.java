package com.mypack.service;

import java.util.List;

import com.mypack.entity.PersonEntity;
import com.mypack.model.PersonModel;

public interface PersonService {
    void add(PersonModel personModel);
    List<PersonEntity> listPersons();
    public PersonModel findPerson(long id);
    void loadSqlSript(String filePath);
}
