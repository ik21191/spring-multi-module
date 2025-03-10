package com.mypack.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.mypack.entity.PersonEntity;

class SavingThread implements Runnable {
  EntityManager em;

  public SavingThread(EntityManager em) {
    this.em = em;
  }

  @Override
  public void run() {

    em.getTransaction().begin();

    PersonEntity personEntity = new PersonEntity();

    personEntity.setFirstName("Imran");
    personEntity.setLastName("Khan");
    personEntity.setEmail("imrankhan@gmail.com");

    // saving entity
    em.persist(personEntity);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    em.getTransaction().commit();
  }
}


class FindThread implements Runnable {
  EntityManager em;

  public FindThread(EntityManager em) {
    this.em = em;
  }

  @Override
  public void run() {
    em.getTransaction().begin();
    // fetching entity
    PersonEntity personEntity = em.find(PersonEntity.class, 1L);
    em.getTransaction().commit();
    System.out.println(personEntity);
  }
}


class DeleteThread implements Runnable {
  EntityManager em;

  public DeleteThread(EntityManager em) {
    this.em = em;
  }

  @Override
  public void run() {

    em.getTransaction().begin();

    // fetching entity
    PersonEntity personEntity = em.find(PersonEntity.class, 1L);
    em.remove(personEntity);
    em.getTransaction().commit();
    System.out.println(personEntity);
  }
}


public class JPADemoSafeUseOfEntityManager {
  public static void main(String[] args) throws Exception {
    EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("LOCAL_PERSISTENCE2");

    Thread save =
        new Thread(new SavingThread(entityManagerFactory.createEntityManager()), "SavingThread");
    save.start();
    save.join();

    /*Thread save2 =
        new Thread(new SavingThread(entityManagerFactory.createEntityManager()), "SavingThread");
    save2.start();
    save2.join();

    
      Thread find = new Thread(new FindThread(entityManagerFactory.createEntityManager()),
      "FindThread"); find.start(); find.join();
      
      Thread delete = new Thread(new DeleteThread(entityManagerFactory.createEntityManager()),
      "DeleteThread"); delete.start(); delete.join();
     */

  }
}
