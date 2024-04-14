package com.msvc.bill.repository;

import com.msvc.bill.entities.SaleBill;
import com.msvc.bill.projection.SaleBillProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleBillRepository extends JpaRepository<SaleBill, Long> {

    List<SaleBill> findAllByCompanyId(Long companyId);

    @Query("SELECT b.id AS id, b.numBill AS numBill, b.numControl AS numControl, b.nameConsumer AS nameConsumer, b.rifConsumer AS rifConsumer, b.companyId AS companyId FROM SaleBill b")
    List<SaleBillProjection> findAllProjection();
}
