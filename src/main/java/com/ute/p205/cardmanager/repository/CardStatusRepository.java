package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardStatusRepository extends JpaRepository<CardStatus, Long> {
    CardStatus findByName(String name);
}
