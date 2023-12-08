package com.msvc.client.controller;

import com.msvc.client.entities.Company;
import com.msvc.client.projection.CompanyProjection;
import com.msvc.client.services.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client/company")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @PostMapping
    @ResponseBody
    public Company create(@RequestBody Company company) {
        return companyService.create(company);
    }

    @PutMapping
    @ResponseBody
    public Company update(@RequestBody Company company) {
        return companyService.update(company);
    }

    @GetMapping
    @ResponseBody
    public List<CompanyProjection> findAll(){
        return companyService.findAllProjection();
    }

    @GetMapping("{id}")
    @ResponseBody
    public Company findById(@PathVariable Long id){
        return companyService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteByid(@PathVariable Long id){
        companyService.delete(id);
    }
}
