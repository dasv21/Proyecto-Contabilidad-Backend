package com.msvc.client.services;

import com.msvc.client.entities.SaleBill;
import com.msvc.client.repository.SaleBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleBillServiceImpl implements SaleBillService {

    @Autowired
    private SaleBillRepository saleBillRepository;

    @Override
    public SaleBill create(SaleBill saleBill) {
        saleBill.setCreateOn(LocalDateTime.now());
        saleBill.setUpdateOn(LocalDateTime.now());
        return saleBillRepository.save(saleBill);
    }

    @Override
    public SaleBill update(SaleBill saleBill) {
        saleBill.setUpdateOn(LocalDateTime.now());
        return saleBillRepository.save(saleBill);
    }

    public List<SaleBill> findAll(){
        return saleBillRepository.findAll();
    }

    @Override
    public SaleBill findById(Long id) {
        return saleBillRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        saleBillRepository.deleteById(id);
    }
}

