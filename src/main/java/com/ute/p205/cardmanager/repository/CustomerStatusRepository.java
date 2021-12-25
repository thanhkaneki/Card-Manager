package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.CustomerStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerStatusRepository extends CrudRepository<CustomerStatus, Integer> {
    List<CustomerStatus> findAll();
    CustomerStatus findByStatus(@Param("status") String status);
}
  


