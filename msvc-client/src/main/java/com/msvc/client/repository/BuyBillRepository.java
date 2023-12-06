package com.msvc.client.repository;

import com.msvc.client.entities.BuyBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyBillRepository extends JpaRepository<BuyBill, Long> {
}
