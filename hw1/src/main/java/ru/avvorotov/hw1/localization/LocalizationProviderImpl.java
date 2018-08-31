package ru.avvorotov.hw1.localization;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.avvorotov.hw1.ApplicationSettings;

import java.util.Locale;

@Service
public class LocalizationProviderImpl implements LocalizationProvider {
    private final MessageSource messageSource;
    private final Locale locale;

    public LocalizationProviderImpl(MessageSource messageSource, ApplicationSettings settings) {
        this.messageSource = messageSource;
        String locale = settings.getLocale();
        this.locale = new Locale(locale);
    }

    @Override
    public String getMessage(String msgId, Object[] params) {
        return messageSource.getMessage(msgId, params, locale);
    }

    @Override
    public String getMessage(String msgId) {
        return this.getMessage(msgId, new Object[]{});
    }
}
