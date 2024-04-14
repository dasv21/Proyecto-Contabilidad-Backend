package com.msvc.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuyBillDTO {

    Long id;

    String numBill;

    String numControl;

    String nameProvider;

    String rifProvider;

    String companyId;
}
