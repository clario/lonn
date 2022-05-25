package no.miles.lonn.api.service;

import no.miles.lonn.api.request.LonnRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.*;

class LonnServiceTest {

    private LonnService lonnService;

    public LonnServiceTest() {
        this.lonnService = new LonnService();
    }

    @Test
    void name() {
        var lonnReq = new LonnRequest();
        lonnReq.setFixedSalary(valueOf(350000));
        lonnReq.setHours(valueOf(125));
        lonnReq.setPercentage(valueOf(0.33));
        lonnReq.setHourPrice(valueOf(1367.52));

        var lonn = lonnService.getLonn(lonnReq);

        System.out.println(lonn);
    }
}