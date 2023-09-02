package cn.itcast.test;

import cn.itcast.domain.CustomerDay1;
import cn.itcast.utils.JpaUtilsDay1;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpqlTestDay1 {
    /**
     * rechercher tous
     * jpql: from cn.itcast.domain.CustomerDay1
     * sql: SELECT * FROM cst_customer
     */
    @Test
    public void testFindAll(){
        EntityManager em = JpaUtilsDay1.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql="from cn.itcast.domain.CustomerDay1";
        Query query = em.createQuery(jpql);
        List list=query.getResultList();

        for (Object obj:list){
            System.out.println(obj);
        }

        tx.commit();
        em.close();
    }

    /**
     * Requête en ordre décroissant selon ID
     * sql:SELECT * FROM cst_customer ORDER BY cust_id DESC
     * jpql:from CustomerDay1 order by custId desc
     */
    @Test
    public void testOrders(){
        EntityManager em = JpaUtilsDay1.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql="from CustomerDay1 order by custId desc";
        Query query = em.createQuery(jpql);
        List list=query.getResultList();

        for (Object obj:list){
            System.out.println(obj);
        }

        tx.commit();
        em.close();
    }

    /**
     * Décompte des clients
     * sql:SELECT COUNT(cust_id) FROM cst_customer
     * jpql: select count(custId) from CustomerDay1
     */
    @Test
    public void testCount(){
        EntityManager em = JpaUtilsDay1.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql="select count(custId) from CustomerDay1";
        Query query = em.createQuery(jpql);
        List list=query.getResultList();

        for (Object obj:list){
            System.out.println(obj);
        }

        tx.commit();
        em.close();
    }
    /**
     * Requête de pagination
     * sql:select * from cst_customer limit ?,?
     * jpql:from CustomerDay1
     */

    @Test
    public void testPage(){
        EntityManager em = JpaUtilsDay1.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql="from CustomerDay1";
        Query query = em.createQuery(jpql);
        //le premier résultat
        query.setFirstResult(0);
        //numbre par chaque page
        query.setMaxResults(2);
        List list=query.getResultList();

        for (Object obj:list){
            System.out.println(obj);
        }

        tx.commit();
        em.close();
    }


    /**
     * Requête conditionnelle
     * sql:SELECT * FROM cst_customer WHERE cust_name LIKE ?
     * jpql:from CustomerDay1 where custName like ?
     */

    @Test
    public void testCondition(){
        EntityManager em = JpaUtilsDay1.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql="from CustomerDay1 where custName like ?";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "传智播客%");

        List list=query.getResultList();

        for (Object obj:list){
            System.out.println(obj);
        }

        tx.commit();
        em.close();
    }

}
