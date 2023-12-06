package com.msvc.client.services;

import com.msvc.client.entities.BuyBill;

public interface BuyBillService {

    BuyBill create(BuyBill buyBill);

    BuyBill update(BuyBill buyBill);

    BuyBill findById(Long id);

    void delete(Long id);
}
