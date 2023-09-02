package cn.itcast.test;

import cn.itcast.dao.CustomerDaoSpec;
import cn.itcast.domain.CustomerSpec;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpecTest {

    @Autowired
    private CustomerDaoSpec customerDao;

    /**
     * Recherche d'un objet unique en fonction des conditions
     *
     */
    @Test
    public void testSpec() {
        // Classe anonyme interne
        /**
         *  Personnaliser les conditions de recherche
         *  1. Implémenter l'interface Specification (en fournissant le type générique : type d'objet à rechercher)
         *  2. Implémenter la méthode toPredicate (construire les conditions de recherche)
         *  3. Utiliser les deux paramètres fournis dans la méthode (root : accéder aux attributs de l'objet à rechercher,
         * CriteriaBuilder : construire les conditions de recherche, incluant des correspondances floues, des correspondances exactes, etc.)
         *
         *  Exemple : Recherche des clients ayant le nom "传智播客"
         *  Conditions de recherche :
         *      1. Méthode de recherche : objet cb
         *      2. Nom de l'attribut à comparer : objet root
         *
         */
        Specification<CustomerSpec> spec = new Specification<CustomerSpec>() {
            @Override
            public Predicate toPredicate(Root<CustomerSpec> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // Comparaison du nom du client avec "传智播客"
                Path<Object> custName = root.get("custName");
                // select * from cst_customer where cust_name = '传智播客'
                /**
                 *  Premier paramètre : attribut à comparer (objet Path)
                 * Deuxième paramètre : valeur de comparaison actuelle
                 */
                Predicate predicate = cb.equal(custName, "传智播客%");//Correspondance exacte (attribut à comparer, valeur de comparaison)
                return predicate;
            }
        };
        CustomerSpec customer = customerDao.findOne(spec);
        System.out.println(customer);
    }

    /**
     * une requête de recherche avec plusieurs conditions,
     *
     */
    @Test
    public void testSpec1() {

        Specification<CustomerSpec> spec = new Specification<CustomerSpec>() {
            @Override
            public Predicate toPredicate(Root<CustomerSpec> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> custName = root.get("custName");//le mon du client
                Path<Object> custIndustry = root.get("custIndustry");//l'industry du client

                // Construction de la requête
                // 1. Construction d'une requête de correspondance exacte pour le nom du client
                Predicate p1 = cb.equal(custName, "传智播客");//Premier paramètre : attribut (path), Deuxième paramètre : valeur de l'attribut
                // 2. Construction d'une requête de correspondance exacte pour le secteur d'activité du client
                Predicate p2 = cb.equal(custIndustry, "it教育");
                //3. Combinaison des conditions de recherche : Combinaison en utilisant un opérateur "ET" (toutes les conditions doivent être satisfaites)
                Predicate and = cb.and(p1, p2);//以与的形式拼接多个查询条件
                // cb.or(); // Combinaison des prédicats avec un opérateur "OU" (au moins une condition doit être satisfaite)
                return and;
            }
        };
        CustomerSpec customer = customerDao.findOne(spec);
        System.out.println(customer);
    }


    /**
     *  réaliser une recherche avec une correspondance floue sur le nom du client et
     *  retourner une liste de clients dont le nom commence par "传智播客",
     */
    @Test
    public void testSpec3() {
        //Correspondance floue sur le nom du client
        Specification<CustomerSpec> spec = new Specification<CustomerSpec>() {
            @Override
            public Predicate toPredicate(Root<CustomerSpec> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> custName = root.get("custName");
                //// Recherche des noms commençant par "传智播客"
                Predicate like = cb.like(custName.as(String.class), "传智播客%");
                return like;
            }
        };
//        List<CustomerSpec> list = customerDao.findAll(spec);
//        for (CustomerSpec customer : list) {
//            System.out.println(customer);
//        }
        //Pour ajouter un tri à votre requête de recherche
        //   Sort.Direction.DESC
        //   Sort.Direction.ASC
        Sort sort = new Sort(Sort.Direction.DESC,"custId");
        List<CustomerSpec> list = customerDao.findAll(spec, sort);
        for (CustomerSpec customer : list) {
            System.out.println(customer);
        }
    }


    @Test
    public void testSpec4() {

        Specification spec = null;
        // pageNumber : numéro de page, pageSize : nombre d'éléments par page
        // Utilisation de la spécification et de la pagination pour exécuter la requête
        Pageable pageable = new PageRequest(0,2);
        Page<CustomerSpec> page = customerDao.findAll(null, pageable);
        System.out.println(page.getContent()); //Obtenir la liste des éléments de données
        System.out.println(page.getTotalElements());//Obtenir le nombre total d'éléments
        System.out.println(page.getTotalPages());//Obtenir le nombre total de pages
    }
}
