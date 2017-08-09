package com.realdolmen.j.hibernate;

import com.realdolmen.j.entities.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class HibernateTest {
    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        UserDetails user2 = new UserDetails();

        user2.setUsername("second user");
        user2.setUserId(2);

        user.setUserId(1);
        user.setUsername("First User");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("j");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(user);
        em.persist(user2);
        tx.commit();

        List<UserDetails> personList= em.createQuery("select p from UserDetails p",UserDetails.class).getResultList();
        personList.forEach(System.out::println);

        emf.close();





    }
}
