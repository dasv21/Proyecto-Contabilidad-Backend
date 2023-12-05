package com.msvc.client.entities;

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
@Table(name = "sales_bill")
public class SalesBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @Column(name = "num_control")
    private String numControl;

    @Column(name = "name_consumer")
    private String nameConsumer;

    @Column(name = "rif_consumer")
    private String rifConsumer;

    @Column(name = "date_created_on")
    private LocalDate dateCreatedOn;

    @Column(name = "date_application_on")
    private LocalDate dateApplicationOn;

    @Column(name = "sale_type")
    private String saleType;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "exempt_amount")
    private BigDecimal exemptAmount;

    @Column(name = "iva_amount")
    private BigDecimal ivaAmount;

    @Column(name = "total_sale")
    private BigDecimal totalSale;

    private String observation;

    private String company; // aqui hay que crear una asociacion con company

    @Column(name = "create_on", updatable = false)
    private LocalDateTime createOn;

    @Column(name = "update_on")
    private LocalDateTime updateOn;

}
