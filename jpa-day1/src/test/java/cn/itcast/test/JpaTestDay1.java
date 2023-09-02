package cn.itcast.test;

import cn.itcast.domain.CustomerDay1;
import cn.itcast.domain.CustomerDay1;
import cn.itcast.utils.JpaUtilsDay1;
import cn.itcast.utils.JpaUtilsDay1;
import cn.itcast.utils.JpaUtilsDay1;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTestDay1 {
    @Test
    public void testSave(){
        /*
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("myJpa");
        EntityManager em =factory.createEntityManager();
        */
        EntityManager em = JpaUtilsDay1.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        CustomerDay1 customer = new CustomerDay1();
        customer.setCustName("传智播客");
        customer.setCustIndustry("教育");
        em.persist(customer);
        tx.commit();
        em.close();
        //factory.close();
    }

    //chargement immédiat
    @Test
    public void testFind(){
        EntityManager entityManager = JpaUtilsDay1.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        CustomerDay1 customer=entityManager.find(CustomerDay1.class,  1l);
        System.out.println(customer);
        tx.commit();
        entityManager.close();



    }
    //chargement différé
    @Test
    public void testReference(){
        EntityManager entityManager = JpaUtilsDay1.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        CustomerDay1 customer=entityManager.getReference(CustomerDay1.class,  1l);
        System.out.println(customer);
        tx.commit();
        entityManager.close();



    }


    @Test
    public void testRemove(){
        EntityManager entityManager = JpaUtilsDay1.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        CustomerDay1 customer=entityManager.getReference(CustomerDay1.class,  2l);
        entityManager.remove(customer);
        tx.commit();
        entityManager.close();



    }



    @Test
    public void testUpdate(){
        EntityManager entityManager = JpaUtilsDay1.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        CustomerDay1 customer=entityManager.getReference(CustomerDay1.class,  3l);
        customer.setCustIndustry("itcast");
        entityManager.merge(customer);
        tx.commit();
        entityManager.close();



    }


}
