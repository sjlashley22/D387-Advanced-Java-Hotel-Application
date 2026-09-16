package edu.wgu.d387_sample_code.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {


    public static final ZoneId ET = ZoneId.of("America/New_York");
    public static final ZoneId MT = ZoneId.of("America/Denver");
    public static final ZoneId UTC = ZoneId.of("UTC");

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static ConvertedTimes convertFromEt(ZonedDateTime etTime) {
        ZonedDateTime mtTime = etTime.withZoneSameInstant(MT);
        ZonedDateTime utcTime = etTime.withZoneSameInstant(UTC);

        return new ConvertedTimes(
                FORMATTER.format(etTime),
                FORMATTER.format(mtTime),
                FORMATTER.format(utcTime)
        );
    }


    public static class ConvertedTimes {
        private final String et;
        private final String mt;
        private final String utc;

        public ConvertedTimes(String et, String mt, String utc) {
            this.et = et;
            this.mt = mt;
            this.utc = utc;
        }

        public String getEt() { return et; }
        public String getMt() { return mt; }
        public String getUtc() { return utc; }
    }
}