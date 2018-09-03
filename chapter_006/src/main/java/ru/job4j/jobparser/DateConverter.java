package ru.job4j.jobparser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * 25 июл 18, 13:04
 * Using Simple Date format yyyy/MM/dd HH:mm:ss
 * and returns millis or Date instance
 */
public class DateConverter {

    private String input;
    //todo decide what I want to send as output
    Date date = new Date();


    public DateConverter(String input) {
        this.input = input;
    }

    public long convert() {
        long result = 0;
        if (todayOrYesterdayDate() != -1) {
            result = todayOrYesterdayDate();
        } else {
            if (isOneDigit()) {
                addZeroFirst();
            }
            try {
                LocalDateTime localDateTime = LocalDateTime.parse(dateConstruct(input),
                        DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
                result = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

            } catch (DateTimeParseException e) {
                //todo attach logger to app
                e.printStackTrace();
                result = System.currentTimeMillis();
            }
        }
        return result;
    }

    private String convertMonth(String month) {
        switch (month) {
            case "янв":
                return "01";
            case "фев":
                return ("02");
            case "мар":
                return ("03");
            case "апр":
                return ("04");
            case "май":
                return ("05");
            case "июн":
                return ("06");
            case "июл":
                return ("07");
            case "авг":
                return ("08");
            case "сен":
                return ("09");
            case "окт":
                return ("10");
            case "ноя":
                return ("11");
            case "дек":
                return ("12");
            default:
                break;
        }
        return "mis";
    }

    private String dateConstruct(String input) {
        String result = "";
        result = String.format("20%s/%s/%s %s:00",
                input.substring(7, 9),
                this.convertMonth(input.substring(3, 6)),
                input.substring(0, 2),
                input.substring(11, 16)
        );
        return result;
    }

    private boolean isOneDigit() {
        return !this.input.substring(1, 2).matches("[0-9]");
    }

    //is it a shitcode
    private long todayOrYesterdayDate() {
        if (input.contains("сегодня")) {
            return System.currentTimeMillis();
        } else if (input.contains("вчера")) {
            return System.currentTimeMillis() - 86400000;
        } else {
            return -1;
        }
    }

    private void addZeroFirst() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0")
                .append(this.input);
        input = stringBuilder.toString();
    }

}
