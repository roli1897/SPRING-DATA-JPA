package cn.itcast.test;

import cn.itcast.dao.RoleDaoDay3;
import cn.itcast.dao.UserDaoDay3;
import cn.itcast.domain.RoleDay3;
import cn.itcast.domain.UserDay3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ManyToManyTest {

    @Autowired
    private UserDaoDay3 userDaoDay3;
    @Autowired
    private RoleDaoDay3 roleDaoDay3;

    /**
     * Sauvegarder un rôle avec des utilisateurs et un utilisateur avec des rôles
     *
     */
    @Test
    @Transactional
    @Rollback(false)
    public void  testAdd() {
        UserDay3 userDay3 = new UserDay3();
        userDay3.setUserName("小李");

        RoleDay3 roleDay3 = new RoleDay3();
        roleDay3.setRoleName("java程序员");

        //Configurer la relation de l'utilisateur vers le rôle avec la possibilité de gérer les données de la table intermédiaire :
        userDay3.getRoles().add(roleDay3);

        //Configurer la relation de le rôle  vers l'utilisateur avec la possibilité de gérer les données de la table intermédiaire :
        roleDay3.getUsers().add(userDay3);

        userDaoDay3.save(userDay3);
        roleDaoDay3.save(roleDay3);
    }


    //Pour effectuer une opération de cascade pour ajouter en cascade (ou sauvegarder en cascade)
    @Test
    @Transactional
    @Rollback(false)
    public void  testCasCadeAdd() {
        UserDay3 userDay3 = new UserDay3();
        userDay3.setUserName("小李");

        RoleDay3 roleDay3 = new RoleDay3();
        roleDay3.setRoleName("java程序员");


        userDay3.getRoles().add(roleDay3);


        roleDay3.getUsers().add(userDay3);

        userDaoDay3.save(userDay3);
    }

    /**
     * Pour supprimer un utilisateur avec l'ID 1 et ses objets associés,
     * vous pouvez utiliser la fonctionnalité de cascade de votre ORM (Object-Relational Mapping) ou effectuer les opérations manuellement.
     */
    @Test
    @Transactional
    @Rollback(false)
    public void  testCasCadeRemove() {
        // rechercher l'utilisateur avec l'ID 1 et le supprimer,
        UserDay3 userDay3 = userDaoDay3.findOne(2l);

        userDaoDay3.delete(userDay3);

    }
}
