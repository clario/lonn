package no.miles.lonn.api;

import no.miles.lonn.api.request.FerieLonnReq;
import no.miles.lonn.api.request.LonnRequest;
import no.miles.lonn.api.response.FerielonnResponse;
import no.miles.lonn.api.service.LonnService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/")
public class LonnController {

    private LonnService lonnService;

    public LonnController(LonnService lonnService) {
        this.lonnService = lonnService;
    }

    @RequestMapping(path = "/lonn", method = RequestMethod.POST)
    public BigDecimal getSum(@RequestBody LonnRequest lonnRequest) {

        return lonnService.getLonn(lonnRequest);

    }

    @RequestMapping(path = "/ferielonn", method = RequestMethod.POST)
    public FerielonnResponse getSum(@RequestBody FerieLonnReq ferieLonnReq) {

        return lonnService.getFerieLonn(ferieLonnReq);

    }

    @GetMapping("/test")
    public String test(){
        return "Hei";
    }

}
