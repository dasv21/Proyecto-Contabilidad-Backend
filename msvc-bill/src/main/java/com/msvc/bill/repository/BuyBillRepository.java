package com.msvc.bill.repository;

import com.msvc.bill.entities.BuyBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyBillRepository extends JpaRepository<BuyBill, Long> {

  //  @Query("SELECT b.id AS id, b.number AS number, b.numberControl AS numberControl, b.nameProvider AS nameProvider, b.companyId AS companyId FROM BuyBill b")
  //  List<BuyBillProjection> findAllProjection();
}
