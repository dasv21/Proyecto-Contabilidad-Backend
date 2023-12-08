package com.msvc.bill.services;

import com.msvc.bill.entities.Company;
import com.msvc.bill.projection.CompanyProjection;

import java.util.List;


public interface CompanyService {

    Company create(Company company);

    Company update(Company company);


    List<CompanyProjection> findAllProjection();

    Company findById(Long id);

    void delete(Long id);
}
