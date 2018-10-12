package ru.javawebinar.graduation.util.exception;

import org.springframework.http.HttpStatus;

import static ru.javawebinar.graduation.util.exception.ErrorType.DATA_NOT_FOUND;


public class NotFoundException extends ApplicationException {
    public static final String NOT_FOUND_EXCEPTION = "exception.common.notFound";

    //  http://stackoverflow.com/a/22358422/548473
    public NotFoundException(String arg) {
        super(DATA_NOT_FOUND, NOT_FOUND_EXCEPTION, HttpStatus.UNPROCESSABLE_ENTITY, arg);
    }
}