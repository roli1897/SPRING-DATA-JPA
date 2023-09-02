package cn.itcast.test;

import cn.itcast.dao.CustomerDaoDay2;
import cn.itcast.domain.CustomerDay2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Déclaration de l'environnement de test unitaire fourni par Spring
@RunWith(SpringJUnit4ClassRunner.class)
//Spécification des informations de configuration du conteneur Spring
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTestDay2 {
    @Autowired
    private CustomerDaoDay2 customerDao;


    @Test
    public void testFindOne() {
        CustomerDay2 customer = customerDao.findOne(2l);
        System.out.println(customer);
    }


    @Test
    public void testSave() {
        CustomerDay2 customer  = new CustomerDay2();
        customer.setCustName("黑马程序员");
        customer.setCustLevel("vip");
        customer.setCustIndustry("it教育");
        customerDao.save(customer);
    }

    @Test
    public void testUpdate() {
        CustomerDay2 customer  = new CustomerDay2();
        customer.setCustId(4l);
        customer.setCustName("黑马程序员很厉害");
        customerDao.save(customer);
    }

    @Test
    public void testDelete () {
        customerDao.delete(3l);
    }



    @Test
    public void testFindAll() {
        List<CustomerDay2> list = customerDao.findAll();
        for(CustomerDay2 customer : list) {
            System.out.println(customer);
        }
    }


    @Test
    public void testCount() {
        long count = customerDao.count();
        System.out.println(count);
    }

    /**
     * Test : Vérifier si le client avec l'ID 4 existe
     * 1. On peut rechercher le client avec l'ID 4
     *   Si la valeur est nulle, cela signifie qu'il n'existe pas, sinon il existe
     * 2. Vérifier le nombre de clients avec l'ID 4 dans la base de données
     *   Si le nombre est égal à 0, cela signifie qu'il n'existe pas, sinon il existe
     */
    @Test
    public void  testExists() {
        boolean exists = customerDao.exists(4l);
        System.out.println("id=4,il existe ou pas"+exists);
    }


    /**
     * Requête basée sur l'ID pour récupérer depuis la base de données
     * @Transactional : Assure le bon fonctionnement de getOne()
     *
     * findOne :
     *      em.find() : Chargement immédiat
     * getOne :
     *      em.getReference : Chargement différé
     *  Renvoie un objet proxy dynamique du client
     * La requête est effectuée lorsque nécessaire
     */
    @Test
    @Transactional
    public void  testGetOne() {
        CustomerDay2 customer = customerDao.getOne(4l);
        System.out.println(customer);
    }

}
