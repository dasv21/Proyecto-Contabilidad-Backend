package com.msvc.bill.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author David Santiago
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sale_bill")
public class SaleBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_bill")
    private String numBill;

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

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "create_on", updatable = false)
    private LocalDateTime createOn;

    @Column(name = "update_on")
    private LocalDateTime updateOn;

}
