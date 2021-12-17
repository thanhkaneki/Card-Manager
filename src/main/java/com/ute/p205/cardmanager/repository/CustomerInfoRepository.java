package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
}
