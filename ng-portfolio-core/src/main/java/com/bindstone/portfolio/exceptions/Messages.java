package com.bindstone.portfolio.exceptions;

/**
 * General Message Library (ENUM), code can be used later for multi language
 */
public enum Messages {
    CURRENCY_NULL("CURRENCY_NULL", "Currency value may not be null!"),
    CURRENCY_ISO_NULL("CURRENCY_ISO_NULL", "ISO value of currency may not be null!"),
    DELETE_ID_WITHOUT_OBJECT("DELETE_ID_WITHOUT_OBJECT", "Try deleting an object without matching ID!");

    /**
     * Code for IN18
     */
    private String code;
    /**
     * Message in English
     */
    private String message;

    /**
     * Constructor
     *
     * @param code    code
     * @param message message
     */
    Messages(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Getter message
     *
     * @return message
     */
    public String message() {
        return message;
    }

    /**
     * Getter code
     *
     * @return code
     */
    public String code() {
        return code;
    }
}
