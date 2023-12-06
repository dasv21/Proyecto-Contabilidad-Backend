package com.msvc.client.controller;

import com.msvc.client.entities.BuyBill;
import com.msvc.client.services.BuyBillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client/buy-bill")
public class BuyBillController {

    @Autowired
    private BuyBillServiceImpl buyBillService;

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
