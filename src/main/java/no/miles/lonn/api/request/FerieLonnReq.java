package no.miles.lonn.api.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FerieLonnReq {

    private BigDecimal breakJuly;
    private BigDecimal breakAugust;
    private BigDecimal breakSeptember;

    private BigDecimal hourPrice;
    private BigDecimal fixedSalary;
    private BigDecimal percentage;

}
