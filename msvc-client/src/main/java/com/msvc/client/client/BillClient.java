package com.msvc.client.client;

import com.msvc.client.dto.BuyBillDTO;
import com.msvc.client.dto.SaleBillDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author David Santiago
 */
@FeignClient(name = "msvc-gateway", url = "msvc-gateway:8080/api/v1/bill")
public interface BillClient {

    @GetMapping("/buy-bill/company/{companyId}")
    List<BuyBillDTO> findAllBuyBillByCompany(@PathVariable Long companyId);

    @GetMapping("/sale-bill/company/{companyId}")
    List<SaleBillDTO> findAllSaleBillByCompany(@PathVariable Long companyId);
}
