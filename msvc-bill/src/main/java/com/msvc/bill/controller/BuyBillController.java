package com.msvc.bill.controller;

import com.msvc.bill.entities.BuyBill;
import com.msvc.bill.services.BuyBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bill/buy-bill")
public class BuyBillController {

    @Autowired
    private BuyBillService buyBillService;

    @PostMapping
    @ResponseBody
    public BuyBill create(@RequestBody BuyBill buyBill) {
        return buyBillService.create(buyBill);
    }

    @PutMapping
    @ResponseBody
    public BuyBill update(@RequestBody BuyBill buyBill) {
        return buyBillService.update(buyBill);
    }

    @GetMapping
    @ResponseBody
    public List<BuyBill> findAll(){
        return buyBillService.findAll();
    }


    @GetMapping("{id}")
    @ResponseBody
    public BuyBill findById(@PathVariable Long id){
        return buyBillService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteByid(@PathVariable Long id){
        buyBillService.delete(id);
    }
}
