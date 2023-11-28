package com.msvc.accountant.controller;

import com.msvc.accountant.entities.Accountant;
import com.msvc.accountant.projection.AccountantProjection;
import com.msvc.accountant.services.AccountantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accountant")
public class AccountantController {

    @Autowired
    private AccountantService accountantService;

    @PostMapping
    @ResponseBody
    public Accountant create(@RequestBody Accountant accountant) {
        return accountantService.create(accountant);
    }

    @PutMapping
    @ResponseBody
    public Accountant update(@RequestBody Accountant accountant) {
        return accountantService.update(accountant);
    }

    @GetMapping
    @ResponseBody
    public List<AccountantProjection> findAll(){
        return accountantService.findAllProjection();
    }

    @GetMapping("{id}")
    @ResponseBody
    public Accountant findById(@PathVariable Long id){
        return accountantService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteByid(@PathVariable Long id){
        accountantService.delete(id);
    }
}
