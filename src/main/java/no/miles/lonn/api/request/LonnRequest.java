package no.miles.lonn.api.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LonnRequest {

    private BigDecimal hourPrice;
    private BigDecimal hours;
    private BigDecimal fixedSalary;
    private BigDecimal percentage;

}
