package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.CardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardTypeRepository extends JpaRepository<CardType, Long> {
    CardType findByName(String name);
}


