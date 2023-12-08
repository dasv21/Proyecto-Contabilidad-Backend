package com.msvc.bill.services;

import com.msvc.bill.entities.BuyBill;
import com.msvc.bill.repository.BuyBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BuyBillServiceImpl implements BuyBillService {

    @Autowired
    private BuyBillRepository buyBillRepository;

    @Override
    public BuyBill create(BuyBill buyBill) {
        buyBill.setCreateOn(LocalDateTime.now());
        buyBill.setUpdateOn(LocalDateTime.now());
        return buyBillRepository.save(buyBill);
    }

    @Override
    public BuyBill update(BuyBill buyBill) {
        buyBill.setUpdateOn(LocalDateTime.now());
        return buyBillRepository.save(buyBill);
    }

    @Override
    public List<BuyBill> findAll(){
        return buyBillRepository.findAll();
    }

    @Override
    public BuyBill findById(Long id) {
        return buyBillRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        buyBillRepository.deleteById(id);
    }
}

