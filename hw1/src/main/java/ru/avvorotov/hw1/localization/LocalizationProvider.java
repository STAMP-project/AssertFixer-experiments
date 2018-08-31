package ru.avvorotov.hw1.localization;

public interface LocalizationProvider {
    String getMessage(String msgId, Object[] params);

    String getMessage(String msgId);
}
