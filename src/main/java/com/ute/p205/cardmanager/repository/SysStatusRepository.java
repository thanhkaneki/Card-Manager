package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.SysStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysStatusRepository extends CrudRepository<SysStatus, Integer> {
    List<SysStatus> findAll();
    SysStatus findByStatus(@Param("status") String status);
}
