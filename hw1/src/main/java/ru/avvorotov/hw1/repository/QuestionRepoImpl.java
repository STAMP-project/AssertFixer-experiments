package ru.avvorotov.hw1.repository;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import ru.avvorotov.hw1.ApplicationSettings;
import ru.avvorotov.hw1.localization.LocalizationProvider;
import ru.avvorotov.hw1.model.Question;
import ru.avvorotov.hw1.model.QuestionWithAnswer;
import ru.avvorotov.hw1.model.UserQuestion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Repository
public class QuestionRepoImpl implements QuestionRepo {

    private boolean isReadQuestion = false;

    private Set<QuestionWithAnswer> questionWithAnswers;

    private Set<Question> questions;

    private ApplicationSettings applicationSettings;

    public QuestionRepoImpl(ApplicationSettings applicationSettings) {
        this.applicationSettings = applicationSettings;
    }

    private void readQuestion() throws IOException {
        if (isReadQuestion) {
            return;
        }

        questionWithAnswers = new HashSet<>();
        ClassLoader classLoader = getClass().getClassLoader();

        CSVReader reader;
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        String fileName = applicationSettings.getQuestionFilepath();
        reader = new CSVReaderBuilder(new FileReader(classLoader.getResource(fileName).getFile()))
                .withCSVParser(csvParser).build();
        List<String[]> myEntries = reader.readAll();
        int i = 1;
        Iterator<String[]> iter = myEntries.iterator();
        iter.next();
        while (iter.hasNext()) {
            String[] next = iter.next();
            questionWithAnswers.add(new QuestionWithAnswer(i, next[0], next[1]));
            i++;
        }
        isReadQuestion = true;
    }

    @Override
    public Set<UserQuestion> getUserQuestion() {
        try {
            readQuestion();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<UserQuestion> userQuestions = new HashSet<>();
        for(QuestionWithAnswer question : questionWithAnswers) {
            userQuestions.add(new UserQuestion(question.getId(), question.getQuestion()));
        }

        return userQuestions;
    }

    @Override
    public QuestionWithAnswer getQuestionWithAnswers(int idQuestion) {
        try {
            readQuestion();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionWithAnswers.stream().filter(k->k.getId() == idQuestion).findFirst().get();
    }
}
