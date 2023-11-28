package com.msvc.accountant.services;

import com.msvc.accountant.entities.Accountant;
import com.msvc.accountant.projection.AccountantProjection;

import java.util.List;

public interface AccountantService {

    Accountant create(Accountant accountant);

    Accountant update(Accountant accountant);


    List<AccountantProjection> findAllProjection();

    Accountant findById(Long id);

    void delete(Long id);
}
