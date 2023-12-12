package com.msvc.client.client;

import com.msvc.client.dto.BuyBillDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-gateway", url = "localhost:8080/api/v1/bill")
public interface BillClient {

    @GetMapping("/buy-bill/company/{companyId}")
    List<BuyBillDTO> findAllBuyBillByCompany(@PathVariable Long companyId);
}
