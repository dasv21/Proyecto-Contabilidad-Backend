package com.msvc.bill.services;

import com.msvc.bill.entities.SaleBill;

import java.util.List;

public interface SaleBillService {

    SaleBill create(SaleBill saleBill);

    SaleBill update(SaleBill saleBill);

    SaleBill findById(Long id);

    List<SaleBill> findAll();

    void delete(Long id);
}
