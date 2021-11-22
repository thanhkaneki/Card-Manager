package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    @Query("SELECT t from type t")
    List<Type> findAll();
}
