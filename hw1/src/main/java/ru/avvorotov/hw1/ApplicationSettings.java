package ru.avvorotov.hw1;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application")
public class ApplicationSettings {
    private String locale;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getQuestionFilepath() {
        return questionFilepath;
    }

    public void setQuestionFilepath(String questionFilepath) {
        this.questionFilepath = questionFilepath;
    }

    public String questionFilepath;

}
