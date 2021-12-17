package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.LimitCreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimitCreditCardRepository extends JpaRepository<LimitCreditCard, Long> {
    LimitCreditCard findByLimitMoney(String limitMoney);
}
