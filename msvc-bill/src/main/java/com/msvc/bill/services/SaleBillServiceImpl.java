package com.msvc.bill.services;

import com.msvc.bill.entities.SaleBill;
import com.msvc.bill.projection.SaleBillProjection;
import com.msvc.bill.repository.SaleBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author David Santiago
 */
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

    @Override
    public List<SaleBillProjection> findAll(){
        return saleBillRepository.findAllProjection();
    }

    @Override
    public SaleBill findById(Long id) {
        return saleBillRepository.findById(id).orElse(null);
    }

    @Override
    public List<SaleBill> findAllByCompanyId(Long companyId) {
        return saleBillRepository.findAllByCompanyId(companyId);
    }

    @Override
    public void delete(Long id) {
        saleBillRepository.deleteById(id);
    }
}

