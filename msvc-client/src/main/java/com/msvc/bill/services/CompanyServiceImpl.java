package com.msvc.bill.services;

import com.msvc.bill.entities.Company;
import com.msvc.bill.exception.RequestValidateException;
import com.msvc.bill.projection.CompanyProjection;
import com.msvc.bill.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

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
}

