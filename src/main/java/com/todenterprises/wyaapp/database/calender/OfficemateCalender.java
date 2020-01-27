package com.todenterprises.wyaapp.database.calender;

public class OfficemateCalender {
    private int numberOfDays = 30;

    public Day[] createCalender () {
        Day[] days = new Day [30];

        for (int i = 0; i < numberOfDays; i++) {
            Day newDay = new Day (); 

            days[i] = newDay;
        }

        return days;
    }
}