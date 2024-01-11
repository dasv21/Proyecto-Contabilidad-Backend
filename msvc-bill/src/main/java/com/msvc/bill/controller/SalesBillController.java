package com.msvc.bill.controller;

import com.msvc.bill.entities.SaleBill;
import com.msvc.bill.services.SaleBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/bill/sale-bill")
public class SalesBillController {

    @Autowired
    private SaleBillService saleBillService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SaleBill saleBill) {
        return ResponseEntity.ok(saleBillService.create(saleBill));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody SaleBill saleBill) {
        return ResponseEntity.ok(saleBillService.update(saleBill));
    }

    @GetMapping
    public ResponseEntity<?>findAll(){
        return ResponseEntity.ok(saleBillService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(saleBillService.findById(id));
    }

    @GetMapping("company/{companyId}")
    public ResponseEntity<?> findAllByCompanyId(@PathVariable Long companyId){
        return ResponseEntity.ok(saleBillService.findAllByCompanyId(companyId));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        saleBillService.delete(id);
    }
}
