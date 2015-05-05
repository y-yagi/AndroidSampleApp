package xyz.yyagi.sampleapp.models;

import java.util.TimeZone;

/**
 * Created by yaginuma on 15/05/05.
 */
public class Schedule {
    public String title;
    public String detail;
    public String startTime;
    public String endTime;

    public Schedule(String title, String detail, String startTime, String endTime) {
        this.title = title;
        this.detail = detail;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
