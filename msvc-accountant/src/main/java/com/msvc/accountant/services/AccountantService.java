package com.msvc.accountant.services;

import com.msvc.accountant.entities.Accountant;

import java.util.List;

public interface AccountantService {

    Accountant create(Accountant accountant);

    Accountant update(Accountant accountant);

    List<Accountant> findAll();

    Accountant findById(Long id);

    void delete(Long id);
}
