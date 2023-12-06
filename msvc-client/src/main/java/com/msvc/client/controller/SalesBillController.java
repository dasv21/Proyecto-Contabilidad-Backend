package com.msvc.client.controller;

import com.msvc.client.entities.SaleBill;
import com.msvc.client.services.SaleBillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client/sale-bill")
public class SalesBillController {

    @Autowired
    private SaleBillServiceImpl saleBillService;

    @PostMapping
    @ResponseBody
    public SaleBill create(@RequestBody SaleBill saleBill) {
        return saleBillService.create(saleBill);
    }

    @PutMapping
    @ResponseBody
    public SaleBill update(@RequestBody SaleBill saleBill) {
        return saleBillService.update(saleBill);
    }

    @GetMapping
    @ResponseBody
    public List<SaleBill> findAll(){
        return saleBillService.findAll();
    }


    @GetMapping("{id}")
    @ResponseBody
    public SaleBill findById(@PathVariable Long id){
        return saleBillService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteByid(@PathVariable Long id){
        saleBillService.delete(id);
    }
}
