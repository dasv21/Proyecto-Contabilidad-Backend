package com.msvc.client.services;

import com.msvc.client.entities.SalesBill;
import com.msvc.client.repository.SalesBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SalesBillServiceImpl implements SalesBillService {

    @Autowired
    private SalesBillRepository salesBillRepository;

    @Override
    public SalesBill create(SalesBill salesBill) {
        salesBill.setCreateOn(LocalDateTime.now());
        salesBill.setUpdateOn(LocalDateTime.now());
        return salesBillRepository.save(salesBill);
    }

    @Override
    public SalesBill update(SalesBill salesBill) {
        salesBill.setUpdateOn(LocalDateTime.now());
        return salesBillRepository.save(salesBill);
    }

    public List<SalesBill> findAll(){
        return salesBillRepository.findAll();
    }

    @Override
    public SalesBill findById(Long id) {
        return salesBillRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        salesBillRepository.deleteById(id);
    }
}

