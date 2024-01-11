package com.msvc.client.controller;

import com.msvc.client.entities.Company;
import com.msvc.client.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/client/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.create(company));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.update(company));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(companyService.findAllProjection());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.findById(id));
    }

    @GetMapping("/buy-bill/{companyId}")
    public ResponseEntity<?> findBuyBillByIdCompany(@PathVariable Long companyId){
        return ResponseEntity.ok(companyService.findBuyBillByIdCompany(companyId));
    }

    @GetMapping("/sale-bill/{companyId}")
    public ResponseEntity<?> findSaleBillByIdCompany(@PathVariable Long companyId){
        return ResponseEntity.ok(companyService.findSaleBillByIdCompany(companyId));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        companyService.delete(id);
    }
}
