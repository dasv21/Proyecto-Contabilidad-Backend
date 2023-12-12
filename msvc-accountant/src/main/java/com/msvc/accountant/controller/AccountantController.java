package com.msvc.accountant.controller;

import com.msvc.accountant.entities.Accountant;
import com.msvc.accountant.services.AccountantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/accountant")
public class AccountantController {

    @Autowired
    private AccountantService accountantService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Accountant accountant) {
        return ResponseEntity.ok(accountantService.create(accountant));
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Accountant accountant) {
        return ResponseEntity.ok(accountantService.update(accountant));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(accountantService.findAllProjection());
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(accountantService.findById(id));
    }

    @DeleteMapping("{id}")
    public void deleteByid(@PathVariable Long id){
        accountantService.delete(id);
    }
}
