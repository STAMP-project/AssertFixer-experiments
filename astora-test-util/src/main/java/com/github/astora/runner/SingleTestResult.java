package com.github.astora.runner;

public final class SingleTestResult {

    private final String name;
    private final String displayName;
    private final TestStatus status;
    private final Throwable exception;

    public SingleTestResult(String name, String displayName, TestStatus status, Throwable exception) {
        if ((status == TestStatus.FAILURE || status == TestStatus.ASSUMPTION_FAILURE) && exception == null) {
            throw new IllegalArgumentException("Missing exception for failed test");
        }

        this.name = name;
        this.displayName = displayName;
        this.status = status;
        this.exception = exception;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public TestStatus getStatus() {
        return status;
    }

    public Throwable getException() {
        return exception;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "SingleTestResult{" + "name='" + name + '\'' + ", displayName='" + displayName + '\'' + ", status=" + status + ", exception=" + exception + '}';
    }
}
