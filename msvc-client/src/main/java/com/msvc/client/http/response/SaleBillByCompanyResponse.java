package com.msvc.client.http.response;

import com.msvc.client.dto.SaleBillDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleBillByCompanyResponse {

    private String companyLegalName;

    private String companyRif;

    private List<SaleBillDTO> saleBillDTOList;
}
