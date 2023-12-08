package com.msvc.bill.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "msvc-gateway", url = "localhost:8080/api/v1/bill")
public interface BillClient {


}