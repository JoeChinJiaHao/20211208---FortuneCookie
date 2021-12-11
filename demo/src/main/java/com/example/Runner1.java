package com.example;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;

public class Runner1 {
    public static void main(String[] args) throws IOException, ParseException {
        DirCon wc = new DirCon();
        //System.out.println(wc.GetWorkingDirStr());
        //wc.MakeFile("users.txt");//file creation done
        ///printout time
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dTF.format(LocalDateTime.now()));
        DateFormat dF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        java.util.Date bDate =  dF.parse("2021/12/10 14:37:15");
        java.util.Date bDate1 = dF.parse(dTF.format(LocalDateTime.now()));
        long TimeDiff1 = bDate1.getTime() - bDate.getTime();

        
        System.out.println("Time preiously is " + dF.format(bDate));
        System.out.println("Time when I am done with you is " + LocalDateTime.now());
        System.out.printf("Time has stopped for %s minutes",TimeDiff1/60000);
    }

    private static String dTF(LocalDateTime now1) {
        return null;
    }
}
