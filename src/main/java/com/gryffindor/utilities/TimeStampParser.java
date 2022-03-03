package com.gryffindor.utilities;

import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeStampParser {

    public TimeStampParser() {}

    public static Timestamp parse(String stringTimeStamp) {
        try {
            DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD HH:MI:SS");
            Date date = formatter.parse(stringTimeStamp);

            return new Timestamp(date.getTime());
        } catch (ParseException e) {
            System.out.println("Exception :" + e);

            return null;
        }
    }
}