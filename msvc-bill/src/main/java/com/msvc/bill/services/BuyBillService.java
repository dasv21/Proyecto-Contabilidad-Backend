package com.msvc.bill.services;

import com.msvc.bill.entities.BuyBill;

import java.util.List;

public interface BuyBillService {

    BuyBill create(BuyBill buyBill);

    BuyBill update(BuyBill buyBill);

    BuyBill findById(Long id);

    List<BuyBill> findAll();

    void delete(Long id);
}
