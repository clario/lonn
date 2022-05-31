package no.miles.lonn.api.service;

import no.miles.lonn.api.request.LonnRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LonnServiceTest {

    private LonnService lonnService;

    public LonnServiceTest() {
        this.lonnService = new LonnService();
    }

    @Test
    void name() {
        var lonnReq = new LonnRequest();
        lonnReq.setFixedSalary(valueOf(350000));
        lonnReq.setHours(valueOf(1));
        lonnReq.setPercentage(valueOf(0.33));
        lonnReq.setHourPrice(valueOf(1390));

        var lonn = lonnService.getLonn(lonnReq);

       assertEquals(valueOf(350000).divide(valueOf(12), RoundingMode.HALF_DOWN), lonn);
    }
}