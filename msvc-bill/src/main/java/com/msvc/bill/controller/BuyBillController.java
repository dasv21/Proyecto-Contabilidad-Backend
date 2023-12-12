package com.msvc.bill.controller;

import com.msvc.bill.entities.BuyBill;
import com.msvc.bill.services.BuyBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/bill/buy-bill")
public class BuyBillController {

    @Autowired
    private BuyBillService buyBillService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BuyBill buyBill) {
        return ResponseEntity.ok(buyBillService.create(buyBill));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BuyBill buyBill) {
        return ResponseEntity.ok(buyBillService.update(buyBill));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(buyBillService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(buyBillService.findById(id));
    }

    @GetMapping("company/{companyId}")
    public ResponseEntity<?> findAllByCompanyId(@PathVariable Long companyId){
        return ResponseEntity.ok(buyBillService.findAllByCompanyId(companyId));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        buyBillService.delete(id);
    }
}
