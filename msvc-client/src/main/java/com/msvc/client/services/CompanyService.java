package com.msvc.client.services;

import com.msvc.client.entities.Company;
import com.msvc.client.http.response.BuyBillByCompanyResponse;
import com.msvc.client.http.response.SaleBillByCompanyResponse;
import com.msvc.client.projection.CompanyProjection;

import java.util.List;

/**
 * @author David Santiago
 */
public interface CompanyService {

    Company create(Company company);

    Company update(Company company);

    List<CompanyProjection> findAllProjection();

    Company findById(Long id);

    void delete(Long id);

    BuyBillByCompanyResponse findBuyBillByIdCompany(Long companyId);

    SaleBillByCompanyResponse findSaleBillByIdCompany(Long companyId);
}
