package ru.javawebinar.graduation.util.exception;

import org.springframework.http.HttpStatus;

import static ru.javawebinar.graduation.util.exception.ErrorType.APP_ERROR;

public class VoteTimeExpiredException extends ApplicationException {

    public static final String TIME_IS_UP_EXCEPTION = "exception.vote.timeIsUp";
    public static final String SUCCESSFULLY_VOTED = "vote.successfullyVoted";
    public static final String UNSUCCESSFULLY_VOTED = "vote.unsuccessfullyVoted";

    //  http://stackoverflow.com/a/22358422/548473
    public VoteTimeExpiredException(String arg) {
        super(APP_ERROR, TIME_IS_UP_EXCEPTION, HttpStatus.NOT_ACCEPTABLE, arg);
    }
}
