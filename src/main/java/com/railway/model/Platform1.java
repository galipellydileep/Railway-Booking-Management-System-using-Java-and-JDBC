package com.railway.model;

import java.time.LocalDate;

public class Platform1 {

    private static String stationname = "Bolaram";
    private static int platforms = 3;
    private static String stationcode = "BMO";
    private static String curlocation = "Bolaram";

    private String customername;
    private long mobile;
    private String destlocation;

    public String getCustomername() { return customername; }
    public void setCustomername(String customername) { this.customername = customername; }

    public long getMobile() { return mobile; }
    public void setMobile(long mobile) { this.mobile = mobile; }

    public String getDestlocation() { return destlocation; }
    public void setDestlocation(String destlocation) { this.destlocation = destlocation; }

    public static String stationDetails() {
        return """
            Welcome to %s Railway Station
            Station Code : %s
            Platforms    : %d
            Tracks       : 5
            Mandal       : Alwal
            """.formatted(stationname, stationcode, platforms);
    }

    public String ticketDetails(LocalDate date) {
        return """
            Customer Name : %s
            Mobile        : %d
            From          : %s
            To            : %s
            Date          : %s
            ***** Happy Journey *****
            """.formatted(customername, mobile, curlocation, destlocation, date);
    }
}
