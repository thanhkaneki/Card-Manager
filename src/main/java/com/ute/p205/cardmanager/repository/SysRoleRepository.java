package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, Integer> {
    SysRole findByRole(@Param("role") String roleName);
}
