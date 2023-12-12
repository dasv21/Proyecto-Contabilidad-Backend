package com.msvc.bill.repository;

import com.msvc.bill.entities.BuyBill;
import com.msvc.bill.projection.BuyBillProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyBillRepository extends JpaRepository<BuyBill, Long> {

    List<BuyBill> findAllByCompanyId(Long companyId);

    @Query("SELECT b.id AS id, b.number AS number, b.numControl AS numControl, b.nameProvider AS nameProvider, b.rifProvider AS rifProvider, b.companyId AS companyId FROM BuyBill b")
    List<BuyBillProjection> findAllProjection();
}
