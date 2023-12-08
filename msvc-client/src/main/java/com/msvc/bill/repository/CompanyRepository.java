package com.msvc.bill.repository;

import com.msvc.bill.entities.Company;
import com.msvc.bill.projection.CompanyProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByRif(String rif);

    Company findByEmail(String email);

    @Query("SELECT c.id AS id, c.rif AS rif, c.shortName AS shortName, c.email AS email FROM Company c")
    List<CompanyProjection> findAllProjection();

}
