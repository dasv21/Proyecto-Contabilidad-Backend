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
@FeignClient(name = "msvc-bill")
public interface BillClient {

    @GetMapping("/api/v1/bill/buy-bill/company/{companyId}")
    List<BuyBillDTO> findAllBuyBillByCompany(@PathVariable Long companyId);

    @GetMapping("/api/v1/bill/sale-bill/company/{companyId}")
    List<SaleBillDTO> findAllSaleBillByCompany(@PathVariable Long companyId);
}
