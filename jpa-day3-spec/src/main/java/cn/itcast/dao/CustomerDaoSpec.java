package cn.itcast.dao;

import cn.itcast.domain.CustomerSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * La spécification du DAO (Data Access Object) conforme à Spring Data JPA est la suivante :
 *
 * JpaRepository<T, ID> : Cette interface fournit des méthodes prédéfinies pour effectuer les opérations CRUD (Create, Read, Update, Delete) de base sur une entité.
 * Elle étend l'interface PagingAndSortingRepository<T, ID>. Vous devez spécifier le type de l'entité (T) et le type de la clé primaire de l'entité (ID).
 *
 * JpaSpecificationExecutor<T> : Cette interface fournit des méthodes pour effectuer des requêtes de recherche complexes en utilisant des spécifications
 * (Specifications) dans Spring Data JPA. Elle permet d'effectuer des recherches avec pagination. Vous devez spécifier le type de l'entité (T).
 */
public interface CustomerDaoSpec extends JpaRepository<CustomerSpec,Long> ,JpaSpecificationExecutor<CustomerSpec> {

    /**
         * ex： effectuer une recherche de clients par leur nom en utilisant JPQL
         * jpql：from CustomerSpec where custName = ?

     */
    @Query(value="from CustomerSpec where custName = ?")
    public CustomerSpec findJpql(String custName);


    /**
     * ex：effectuer une recherche de clients par leur nom et ID
     *      jpql： from CustomerSpec where custName = ? and custId = ?
     */
    @Query(value = "from CustomerSpec where custName = ?2 and custId = ?1")
    public CustomerSpec findCustNameAndId(Long id, String name);

    /**
     *
     *      ex ： mettre à jour le nom d'un client en utilisant l'ID dans Spring Data JPA
     *
     *  sql  ：update cst_customer set cust_name = ? where cust_id = ?
     *  jpql : update CustomerSpec set custName = ? where custId = ?
     *
     *  @Query :
     *      pour spécifier la requête JPQL de mise à jour. La requête JPQL
     *
     *  @Modifying :
     *      est utilisée pour indiquer que cette méthode effectue une opération de mise à jour.
     *
     */
    @Query(value = " update CustomerSpec set custName = ?2 where custId = ?1 ")
    @Modifying
    public void updateCustomerSpec(long custId, String custName);




    //@Query(value = " select * from cst_customer" ,nativeQuery = true)
    @Query(value="select * from cst_customer where cust_name like ?1",nativeQuery = true)
    public List<Object [] > findSql(String name);


    /**
     *  les conventions de nommage courantes ：
     *      findBy : Utilisé pour effectuer une recherche basée sur une seule condition égale (par défaut).
     *      findBy + Nom de l'attribut + "QueryMethod" : Utilisé pour effectuer une recherche en utilisant une méthode de requête spécifique, telle que Like, IsNull, etc.
     *
     *      Recherche multi-conditions :
     *      findBy + Nom de l'attribut + "QueryMethod" + "Connector" + Nom de l'attribut + "QueryMethod"
     */
    public CustomerSpec findByCustName(String custName);


    public List<CustomerSpec> findByCustNameLike(String custName);

    //
    //Pour effectuer une recherche basée sur une correspondance floue du nom du client et une correspondance précise du secteur d'activité dans Spring Data JPA,
    public CustomerSpec findByCustNameLikeAndCustIndustry(String custName, String custIndustry);
}
