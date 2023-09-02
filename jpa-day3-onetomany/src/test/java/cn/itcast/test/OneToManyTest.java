package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;


    @Test
    @Transactional // Configurer la transaction
    @Rollback(false) //Ne pas effectuer de rollback automatique
    public void testAdd() {
        // Créer un client, créer un contact
        Customer customer = new Customer();
        customer.setCustName("百度");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小李");




        customerDao.save(customer);
        linkManDao.save(linkMan);
    }


    @Test
    @Transactional //Configurer la transaction
    @Rollback(false) //Ne pas effectuer de rollback automatique
    public void testAdd1() {
        //Créer un client, créer un contact
        Customer customer = new Customer();
        customer.setCustName("百度");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小李");

        /**
         * Pour configurer la relation entre un contact et un client en utilisant une relation "plusieurs vers un" (many-to-one),
         *
         */
        linkMan.setCustomer(customer);

        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    /**
     * Pour configurer la relation entre une entité "plusieurs" et une entité "un" (one-to-many),
     * et éviter la génération d'une requête de mise à jour supplémentaire,
     */

    @Test
    @Transactional
    @Rollback(false)
    public void testAdd2() {

        Customer customer = new Customer();
        customer.setCustName("百度");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小李");


        linkMan.setCustomer(customer);// Définit le côté "plusieurs" de la relation
        customer.getLinkMans().add(linkMan);//Définit le côté "un" de la relation

        // Enregistrer le client dans la base de données
        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    /**
     * Pour réaliser une opération de cascade lors de l'enregistrement d'un client et de tous ses contacts
     *       configurer la propriété "cascade" sur l'entité principale
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeAdd() {
        Customer customer = new Customer();
        customer.setCustName("百度1");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小李1");

        linkMan.setCustomer(customer);
        customer.getLinkMans().add(linkMan);

        customerDao.save(customer);
    }


    /**
     * Pour réaliser une opération de cascade lors de la suppression d'un client et de tous ses contacts
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeRemove() {
        Customer customer = customerDao.findOne(1l);
        customerDao.delete(customer);
    }
}
