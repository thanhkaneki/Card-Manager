package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    Card findCardByNumber(String number);
}



