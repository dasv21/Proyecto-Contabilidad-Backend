package com.msvc.client.controller;

import com.msvc.client.entities.SalesBill;
import com.msvc.client.projection.CompanyProjection;
import com.msvc.client.services.SalesBillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client/sales-bill")
public class SalesBillController {

    @Autowired
    private SalesBillServiceImpl salesBillService;

    @PostMapping
    @ResponseBody
    public SalesBill create(@RequestBody SalesBill salesBill) {
        return salesBillService.create(salesBill);
    }

    @PutMapping
    @ResponseBody
    public SalesBill update(@RequestBody SalesBill salesBill) {
        return salesBillService.update(salesBill);
    }

    @GetMapping
    @ResponseBody
    public List<SalesBill> findAll(){
        return salesBillService.findAll();
    }


    @GetMapping("{id}")
    @ResponseBody
    public SalesBill findById(@PathVariable Long id){
        return salesBillService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteByid(@PathVariable Long id){
        salesBillService.delete(id);
    }
}
