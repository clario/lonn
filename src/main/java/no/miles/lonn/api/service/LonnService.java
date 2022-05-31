package no.miles.lonn.api.service;

import no.miles.lonn.api.request.FerieLonnReq;
import no.miles.lonn.api.request.LonnRequest;
import no.miles.lonn.api.response.FerielonnResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.util.concurrent.TimeUnit;

import static java.math.BigDecimal.valueOf;

@Service
public class LonnService {

    private BigDecimal MONTH_IN_YEAR = valueOf(12);

    public BigDecimal getLonn(LonnRequest lr) {

        var sumBilled = lr.getHours().multiply(lr.getHourPrice());
        var fixedSalaryMonth = lr.getFixedSalary().divide(MONTH_IN_YEAR, RoundingMode.HALF_DOWN);
        var billedMinusFixed = fixedSalaryMonth;

        var commission = BigDecimal.ZERO;

        if (fixedSalaryMonth.compareTo(sumBilled) < 1) {
            billedMinusFixed = sumBilled.subtract(fixedSalaryMonth);
            commission = billedMinusFixed.multiply(lr.getPercentage());
        }


        return commission.add(fixedSalaryMonth);
    }

    public FerielonnResponse getFerieLonn(FerieLonnReq frq) {

        var H_IN_JULY = valueOf(157.5);
        var H_IN_AUGUST = valueOf(172.5);
        var H_IN_SEPTEMBER = valueOf(165);

        var hoursJuly = H_IN_JULY.subtract(frq.getBreakJuly().multiply(valueOf(7.5)));
        var hoursAugust = H_IN_AUGUST.subtract(frq.getBreakAugust().multiply(valueOf(7.5)));
        var hoursSeptember = H_IN_SEPTEMBER.subtract(frq.getBreakSeptember().multiply(valueOf(7.5)));


        var lonnJuly = getLonn(getRequest(hoursJuly, frq));
        var lonngAug = getLonn(getRequest(hoursAugust, frq));
        var lonnSept = getLonn(getRequest(hoursSeptember, frq));


        var sum = lonnJuly.add(lonngAug).add(lonnSept);

        return FerielonnResponse.builder()
                .hoursJuly(hoursJuly)
                .hoursAugust(hoursAugust)
                .hoursSeptember(hoursSeptember)
                .lonnJuly(lonnJuly)
                .lonnAugust(lonngAug)
                .lonnSeptember(lonnSept)
                .sumLonn(sum)
                .build();
    }

    private LonnRequest getRequest(BigDecimal hours, FerieLonnReq frq) {
        var req = new LonnRequest();
        req.setHourPrice(frq.getHourPrice());
        req.setHours(hours);
        req.setPercentage(frq.getPercentage());
        req.setFixedSalary(frq.getFixedSalary());

        return req;

    }
}
