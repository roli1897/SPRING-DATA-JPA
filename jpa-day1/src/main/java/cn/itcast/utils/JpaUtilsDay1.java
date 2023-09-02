package cn.itcast.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Pour résoudre les problèmes de gaspillage de ressources et de temps associés à la EntityManagerFactory
 *          utiliser un bloc de code statique pour créer une seule instance de l'usine d'entités et la rendre accessible à chaque fois que vous en avez besoin.
 */
public class JpaUtilsDay1 {

    private static EntityManagerFactory factory;
    static{

        // charger un fichier de configuration et créer un EntityManagerFactory
        factory = Persistence.createEntityManagerFactory("myJpa");


    }
    //Pour obtenir un objet EntityManager en utilisant JPA

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
