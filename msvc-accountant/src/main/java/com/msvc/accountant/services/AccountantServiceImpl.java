package com.msvc.accountant.services;

import com.msvc.accountant.entities.Accountant;
import com.msvc.accountant.exception.RequestValidateException;
import com.msvc.accountant.projection.AccountantProjection;
import com.msvc.accountant.repository.AccountantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountantServiceImpl implements AccountantService {

    @Autowired
    private AccountantRepository accountantRepository;

    @Override
    public Accountant create(Accountant accountant) {
        if (accountant == null || accountant.valid()) {
            throw new RequestValidateException("Bad request", HttpStatus.BAD_REQUEST);
        }
        if (accountantRepository.findByDni(accountant.getDni()) != null) {
            throw new RequestValidateException("Dni is already registered with another accountant", HttpStatus.CONFLICT);
        }
        if (accountantRepository.findByEmail(accountant.getEmail()) != null) {
            throw new RequestValidateException("Email is already registered with another accountant", HttpStatus.CONFLICT);
        }
        accountant.setCreateOn(LocalDateTime.now());
        accountant.setUpdateOn(LocalDateTime.now());
        return accountantRepository.save(accountant);
    }

    @Override
    public Accountant update(Accountant accountant) {
        if (accountant == null || accountant.valid()) {
            throw new RequestValidateException("Bad request", HttpStatus.BAD_REQUEST);
        }
        if (accountantRepository.findById(accountant.getId()).isEmpty()) {
            throw new RequestValidateException("Accountant no registered", HttpStatus.CONFLICT);
        }
        accountant.setUpdateOn(LocalDateTime.now());
        return accountantRepository.save(accountant);
    }

    @Override
    public List<AccountantProjection> findAllProjection() {
        return accountantRepository.findAllProjection();
    }

    @Override
    public Accountant findById(Long id) {
        return accountantRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        accountantRepository.deleteById(id);
    }
}

