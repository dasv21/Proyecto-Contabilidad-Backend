package com.msvc.bill.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "buy_bill")
public class BuyBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_bill")
    private String numBill;

    @Column(name = "num_control")
    private String numControl;

    @Column(name = "name_provider")
    private String nameProvider;

    @Column(name = "rif_provider")
    private String rifProvider;

    @Column(name = "date_created_on")
    private LocalDate dateCreatedOn;

    @Column(name = "date_application_on")
    private LocalDate dateApplicationOn;

    @Column(name = "buy_type")
    private String buyType;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "exempt_amount")
    private BigDecimal exemptAmount;

    @Column(name = "iva_amount")
    private BigDecimal ivaAmount;

    @Column(name = "total_Buy")
    private BigDecimal totalBuy;

    @Column(name = "tax_especial")
    private BigDecimal taxEspecial;

    private String observation;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "create_on", updatable = false)
    private LocalDateTime createOn;

    @Column(name = "update_on")
    private LocalDateTime updateOn;

}
