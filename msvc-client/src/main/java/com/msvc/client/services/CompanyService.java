package com.msvc.client.services;

import com.msvc.client.entities.Company;
import com.msvc.client.projection.CompanyProjection;

import java.util.List;


public interface CompanyService {

    Company create(Company company);

    Company update(Company company);


    List<CompanyProjection> findAllProjection();

    Company findById(Long id);

    void delete(Long id);
}
