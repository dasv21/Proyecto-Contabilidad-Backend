package com.msvc.bill.projection;

/**
 * @author David Santiago
 */
public interface BuyBillProjection {

    Long getId();

    String getNumBill();

    String getNumControl();

    String getNameProvider();

    String getRifProvider();

    String getCompanyId();
}
