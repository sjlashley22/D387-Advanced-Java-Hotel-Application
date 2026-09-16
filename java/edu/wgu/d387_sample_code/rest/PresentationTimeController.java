package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.model.response.PresentationTimeResponse;
import edu.wgu.d387_sample_code.util.TimeZoneConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@RestController
public class PresentationTimeController {

    @GetMapping("/api/presentation-time")
    public PresentationTimeResponse getPresentationTime() {

        ZonedDateTime presentationEt = ZonedDateTime.of(
                LocalDate.now(TimeZoneConverter.ET),
                LocalTime.of(14, 0),
                TimeZoneConverter.ET
        );

        TimeZoneConverter.ConvertedTimes times = TimeZoneConverter.convertFromEt(presentationEt);

        String message = String.format(
                "Live presentation times — ET: %s | MT: %s | UTC: %s",
                times.getEt(), times.getMt(), times.getUtc()
        );

        return new PresentationTimeResponse(times.getEt(), times.getMt(), times.getUtc(), message);
    }
}