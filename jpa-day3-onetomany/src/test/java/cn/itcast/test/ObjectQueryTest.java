package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ObjectQueryTest {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    //could not initialize proxy - no Session
    /**requête de navigation d'objet de test
     * (Cela fait référence à une requête qui permet de récupérer tous les objets associés à un objet
     * donné en utilisant la navigation entre les relations d'objets.)
     */
    @Test
    @Transactional
    public void  testQuery1() {

        Customer customer = customerDao.getOne(2l);
        Set<LinkMan> linkMans = customer.getLinkMans();

        for (LinkMan linkMan : linkMans) {
            System.out.println(linkMan);
        }
    }



    @Test
    @Transactional
    public void  testQuery2() {

        Customer customer = customerDao.findOne(2l);
        Set<LinkMan> linkMans = customer.getLinkMans();

        System.out.println(linkMans.size());
    }


    @Test
    @Transactional
    public void  testQuery3() {
        LinkMan linkMan = linkManDao.findOne(2l);
        Customer customer = linkMan.getCustomer();
        System.out.println(customer);
    }

}
