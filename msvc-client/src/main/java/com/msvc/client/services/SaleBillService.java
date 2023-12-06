package com.msvc.client.services;

import com.msvc.client.entities.SaleBill;

public interface SaleBillService {

    SaleBill create(SaleBill saleBill);

    SaleBill update(SaleBill saleBill);

    SaleBill findById(Long id);

    void delete(Long id);
}
