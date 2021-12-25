package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(@Param("role") String roleName);
}
   


