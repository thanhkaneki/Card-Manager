package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.TypeOfMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TypeOfMoneyRepository extends JpaRepository<TypeOfMoney, Long> {
    TypeOfMoney findTypeOfMoneyByName(String name);
}
