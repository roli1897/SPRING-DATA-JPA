package cn.itcast.dao;

import cn.itcast.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * JpaRepository<Contact, Long> : Cette interface fournit des méthodes prédéfinies pour les opérations CRUD
 * (Create, Read, Update, Delete) sur l'entité Contact. Elle inclut des méthodes telles que save, findOne, findAll, delete, etc.
 *
 * JpaSpecificationExecutor<Contact> : Cette interface permet d'exécuter des requêtes plus complexes et prend en charge les fonctionnalités de pagination.
 * Elle inclut des méthodes telles que findAll(Specification<T> spec, Pageable pageable), count(Specification<T> spec), etc.
 *
 */
public interface CustomerDao extends JpaRepository<Customer,Long> ,JpaSpecificationExecutor<Customer> {

}
