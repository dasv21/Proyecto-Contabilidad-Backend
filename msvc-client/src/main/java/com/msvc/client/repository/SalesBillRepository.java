package com.msvc.client.repository;

import com.msvc.client.entities.SalesBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesBillRepository extends JpaRepository<SalesBill, Long> {
}
