package com.app.demo;

public class MyCalendar {

    private  int date;
    private String month;

    public MyCalendar(int day, String month) {
        this.date = day;
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
