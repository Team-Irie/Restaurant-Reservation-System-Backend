package com.hotelReservation.utilities;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampParser {

    public TimeStampParser() {}

    public static Timestamp parse(String stringTimeStamp) {
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date date = formatter.parse(stringTimeStamp);

            return new Timestamp(date.getTime());
        } catch (ParseException e) {
            System.out.println("Exception :" + e);

            return null;
        }
    }
}