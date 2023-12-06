package com.msvc.client.repository;

import com.msvc.client.entities.SaleBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleBillRepository extends JpaRepository<SaleBill, Long> {
}
