package cn.itcast.dao;

import cn.itcast.domain.CustomerDay2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Pour respecter les conventions de l'interface de la couche DAO (Data Access Object) de Spring Data JPA,
 * utiliser les interfaces JpaRepository et JpaSpecificationExecutor.
 * <p>
 * JpaRepository: Cette interface fournit des méthodes prédéfinies pour les opérations de base de création, lecture,
 * mise à jour et suppression (CRUD) sur une entité.(CRUD)
 * <p>
 * JpaSpecificationExecutor:Cette interface fournit des méthodes pour effectuer des requêtes complexes et paginées
 * en utilisant des spécifications.
 */
public interface CustomerDaoDay2 extends JpaRepository<CustomerDay2, Long>, JpaSpecificationExecutor<CustomerDay2> {

    /**
     * Exemple : Recherche de clients par les nom de client .
     * <p>
     * jpql：from CustomerDay2 where custName = ?
     *
     * @Query
     */
    @Query(value = "from CustomerDay2 where custName = ?")
    public CustomerDay2 findJpql(String custName);


    /**
     * Exemple : Recherche de clients par ID .
     *      jpql： from CustomerDay2 where custName = ? and custId = ?
     */
    @Query(value = "from CustomerDay2 where custName = ?2 and custId = ?1")
    public CustomerDay2 findCustNameAndId(Long id, String name);

    /**
     *
     *  Exemple :  Mise à jour du nom du client en fonction de l'identifiant
     *
     *  sql  ：update cst_customer set cust_name = ? where cust_id = ?
     *  jpql : update CustomerDay2 set custName = ? where custId = ?
     *
     */
    @Query(value = " update CustomerDay2 set custName = ?2 where custId = ?1 ")
    @Modifying
    public void updateCustomerDay2(long custId,String custName);


    /**
     * Utilisation de la forme SQL pour interroger
     * Requête de tous les clients
     * SQL : select * from cst_customer;
     * Requête : Configuration de la requête SQL
     * value : Requête SQL
     * nativeQuery : Mode de requête
     * true : Requête SQL
     * false : Requête JPQL
     */
    //@Query(value = " select * from cst_customer" ,nativeQuery = true)
    @Query(value = "select * from cst_customer where cust_name like ?1", nativeQuery = true)
    public List<Object[]> findSql(String name);


    /**
     * findBy : Requête
     * Nom de propriété dans l'objet (avec la première lettre en majuscule) : Condition de la requête
     * CustName
     * * Par défaut : Utilisation de l'égalité pour la requête
     * Méthodes de requête spéciales
     * <p>
     * findByCustName   --   Requête basée sur le nom du client
     * <p>
     * Lors de l'exécution de Spring Data JPA,
     * la méthode sera analysée en fonction de son nom : findBy    from  xxx (nom de l'entité)
     * Nom de propriété      where  custName =
     * <p>
     * 1.findBy  + Nom de propriété (Requête d'égalité basée sur le nom de propriété)
     * 2.findBy  + Nom de propriété + "Méthode de requête (Like | isnull)"
     * findByCustNameLike
     * 3.Requête à plusieurs critères
     * findBy + Nom de propriété + "Méthode de requête" + "Connecteur de critères multiples (and|or)" + Nom de propriété + "Méthode de requête"
     */
    public CustomerDay2 findByCustName(String custName);


    public List<CustomerDay2> findByCustNameLike(String custName);

    //Requête de correspondance floue basée sur le nom du client et correspondance précise sur le secteur d'activité du client
    public CustomerDay2 findByCustNameLikeAndCustIndustry(String custName, String custIndustry);
}
