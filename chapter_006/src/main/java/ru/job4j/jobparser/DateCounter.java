package ru.job4j.jobparser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * This class check date of creation and compare it with first day of year
 * according to paragraph 7 of task requirements
 */
public class DateCounter {


    public boolean fromBeginOfThisYear(ParsedRow row) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date postDate = new Date(row.getDate());
        LocalDate dateLocal = LocalDate.ofYearDay(year, 1);
        Date startDate = new Date();
        try {
            startDate = dateFormat.parse(String.valueOf(dateLocal));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return postDate.compareTo(startDate) > 0;
    }

}
