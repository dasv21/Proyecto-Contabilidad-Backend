package com.msvc.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author David Santiago
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleBillDTO {

    Long id;

    String numBill;

    String numControl;

    String nameConsumer;

    String rifConsumer;

    String companyId;
}
