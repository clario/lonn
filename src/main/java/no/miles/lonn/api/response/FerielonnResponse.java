package no.miles.lonn.api.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class FerielonnResponse {

    private BigDecimal hoursJuly;
    private BigDecimal hoursAugust;
    private BigDecimal hoursSeptember;
    private BigDecimal lonnJuly;
    private BigDecimal lonnAugust;
    private BigDecimal lonnSeptember;
    private BigDecimal sumLonn;

}
