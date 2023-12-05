package com.msvc.client.services;

import com.msvc.client.entities.SalesBill;

public interface SalesBillService {

    SalesBill create(SalesBill salesBill);

    SalesBill update(SalesBill salesBill);

    SalesBill findById(Long id);

    void delete(Long id);
}
