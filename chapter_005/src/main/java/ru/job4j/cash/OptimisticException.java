package ru.job4j.cash;

public class OptimisticException extends RuntimeException {

    OptimisticException(String incorrectVersions) {
        super(incorrectVersions);
    }
}
