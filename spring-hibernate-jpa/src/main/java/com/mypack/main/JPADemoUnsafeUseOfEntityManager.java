package com.mypack.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.mypack.entity.PersonEntity;

/**
 * EntityManager is not thread safe, so we should not shared the same entity manager instance with
 * two threads.
 */

class UnsafeWayToSaveEntity implements Runnable {
  EntityManager em;

  public UnsafeWayToSaveEntity(EntityManager em) {
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


public class JPADemoUnsafeUseOfEntityManager {
  public static void main(String[] args) throws Exception {
    EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("LOCAL_PERSISTENCE2");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    Thread save = new Thread(new UnsafeWayToSaveEntity(entityManager), "SavingThread");
    save.start();

    Thread save2 = new Thread(new UnsafeWayToSaveEntity(entityManager), "SavingThread");
    save2.start();

  }
}
