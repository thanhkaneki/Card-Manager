package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {
    Status findByStatus(@Param("status") String status);
}
