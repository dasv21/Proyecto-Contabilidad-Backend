package com.msvc.client.services;

import com.msvc.client.client.BillClient;
import com.msvc.client.dto.BuyBillDTO;
import com.msvc.client.dto.SaleBillDTO;
import com.msvc.client.entities.Company;
import com.msvc.client.exception.RequestValidateException;
import com.msvc.client.http.response.BuyBillByCompanyResponse;
import com.msvc.client.http.response.SaleBillByCompanyResponse;
import com.msvc.client.projection.CompanyProjection;
import com.msvc.client.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author David Santiago
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private BillClient billClient;

    @Override
    public Company create(Company company) {
        if (company == null || company.valid()) {
            throw new RequestValidateException("Bad request", HttpStatus.BAD_REQUEST);
        }
        if (companyRepository.findByRif(company.getRif()) != null) {
            throw new RequestValidateException("Rif is already registered with another Company", HttpStatus.CONFLICT);
        }
        if (companyRepository.findByEmail(company.getEmail()) != null) {
            throw new RequestValidateException("Email is already registered with another Company", HttpStatus.CONFLICT);
        }
        company.setCreateOn(LocalDateTime.now());
        company.setUpdateOn(LocalDateTime.now());
        return companyRepository.save(company);
    }

    @Override
    public Company update(Company company) {
        if (company == null || company.valid()) {
            throw new RequestValidateException("Bad request", HttpStatus.BAD_REQUEST);
        }
        if (companyRepository.findById(company.getId()).isEmpty()) {
            throw new RequestValidateException("Company no registered", HttpStatus.CONFLICT);
        }
        company.setUpdateOn(LocalDateTime.now());
        return companyRepository.save(company);
    }

    @Override
    public List<CompanyProjection> findAllProjection() {
        return companyRepository.findAllProjection();
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public BuyBillByCompanyResponse findBuyBillByIdCompany(Long companyId) {

        Company company = companyRepository.findById(companyId).orElseThrow();

        List<BuyBillDTO> buyBillDTOList = billClient.findAllBuyBillByCompany(companyId);

        return BuyBillByCompanyResponse.builder()
                .companyLegalName(company.getLegalName())
                .companyRif(company.getRif())
                .buyBillDTOList(buyBillDTOList)
                .build();
    }

    @Override
    public SaleBillByCompanyResponse findSaleBillByIdCompany(Long companyId) {

        Company company = companyRepository.findById(companyId).orElseThrow();

        List<SaleBillDTO> saleBillDTOList = billClient.findAllSaleBillByCompany(companyId);

        return SaleBillByCompanyResponse.builder()
                .companyLegalName(company.getLegalName())
                .companyRif(company.getRif())
                .saleBillDTOList(saleBillDTOList)
                .build();
    }
}

