package com.msvc.client.repository;

import com.msvc.client.entities.Company;
import com.msvc.client.projection.CompanyProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author David Santiago
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByRif(String rif);

    Company findByEmail(String email);

    @Query("SELECT c.id AS id, c.rif AS rif, c.shortName AS shortName, c.email AS email FROM Company c")
    List<CompanyProjection> findAllProjection();

}
