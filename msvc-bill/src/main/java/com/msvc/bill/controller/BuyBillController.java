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
    @ResponseBody
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(buyBillService.findAll());
    }


    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(buyBillService.findById(id));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        buyBillService.delete(id);
    }
}
