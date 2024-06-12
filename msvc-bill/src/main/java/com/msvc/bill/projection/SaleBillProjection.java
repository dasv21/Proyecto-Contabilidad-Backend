package com.msvc.bill.projection;

/**
 * @author David Santiago
 */
public interface SaleBillProjection {

    Long getId();

    String getNumBill();

    String getNumControl();

    String getNameConsumer();

    String getRifConsumer();

    String getCompanyId();
}
