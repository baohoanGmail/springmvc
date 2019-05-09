package com.ntatvr.springmvc.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ntatvr.springmvc.entity.Customer;
import com.ntatvr.springmvc.repository.CustomerRepositoryCustom;

@Repository("customersRepository")
@Transactional(rollbackFor = Exception.class)
public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {

  @PersistenceContext
  protected EntityManager entityManager;

  @SuppressWarnings("unchecked")
  @Override
  public List<Customer> excuteQuery() {
    String querySQL = "SELECT c FROM Customer c WHERE customerNumber < 120 ORDER BY customerNumber";
    Query query = entityManager.createQuery(querySQL);
    return (List<Customer>) query.getResultList();
  }

}
