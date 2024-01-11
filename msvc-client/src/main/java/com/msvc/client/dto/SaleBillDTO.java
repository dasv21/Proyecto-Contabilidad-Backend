package com.msvc.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleBillDTO {

    Long id;

    String number;

    String numControl;

    String nameConsumer;

    String rifConsumer;

    String companyId;
}
