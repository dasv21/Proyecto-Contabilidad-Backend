package com.msvc.bill.repository;

import com.msvc.bill.entities.SaleBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleBillRepository extends JpaRepository<SaleBill, Long> {
}
