package cn.itcast.test;

import cn.itcast.dao.CustomerDaoDay2;
import cn.itcast.domain.CustomerDay2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

//Déclaration de l'environnement de test unitaire fourni par Spring
@RunWith(SpringJUnit4ClassRunner.class)
//Spécification des informations de configuration du conteneur Spring
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpqlTestDay2 {
    @Autowired
    private CustomerDaoDay2 customerDaoDay2;

    @Test
    public void  testFindJPQL() {
        CustomerDay2 customer = customerDaoDay2.findJpql("传智播客%");
        System.out.println(customer);
    }


    @Test
    public void testFindCustNameAndId() {
       // CustomerDay2 customer =  customerDaoDay2
        //.findCustNameAndId("传智播客",1l);
        CustomerDay2 customer =  customerDaoDay2.findCustNameAndId(1l,"传智播客");
        System.out.println(customer);
    }

    /**
     * Test de l'opération de mise à jour avec JPQL dans Spring Data JPA:
        * Nécessite l'ajout manuel de la prise en charge des transactions
        * Par défaut, la transaction est annulée après l'exécution
     * @Rollback : Définit si l'annulation automatique est activée
     *          false | true
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdateCustomerDay2() {
        customerDaoDay2.updateCustomerDay2(4l,"黑马程序员");
    }

    //test de l'opération avec sql
    @Test
    public void testFindSql() {
        List<Object[]> list = customerDaoDay2.findSql("传智播客%");
        for(Object [] obj : list) {
            System.out.println(Arrays.toString(obj));
        }
    }


    //Test de la requête basée sur les règles de nommage des méthodes.
    @Test
    public void testNaming() {
        CustomerDay2 customer = customerDaoDay2.findByCustName("传智播客%");
        System.out.println(customer);
    }



    @Test
    public void testFindByCustNameLike() {
        List<CustomerDay2> list = customerDaoDay2.findByCustNameLike("传智播客%");
        for (CustomerDay2 customer : list) {
            System.out.println(customer);
        }
    }



    @Test
    public void testFindByCustNameLikeAndCustIndustry() {
        CustomerDay2 customer = customerDaoDay2.findByCustNameLikeAndCustIndustry("传智播客1%", "it教育");
        System.out.println(customer);
    }
}
