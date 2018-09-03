package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateService {

    private static ValidateService ourInstance = new ValidateService();
    private final Store logic = MemoryStore.getInstance();
    private static final Logger LOG = LoggerFactory.getLogger(ValidateService.class);

    public static ValidateService getInstance() {
        return ourInstance;
    }

    private ValidateService() {
    }


    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[-a-z0-9~!$%^&*_=+}{\\'?]+(\\.[-a-z0-9~!$%^&*_=+}{\\'?]+)*@([a-z0-9_][-a-z0-9_]*(\\.[-a-z0-9_]+)*\\."
                    + "(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|"
                    + "([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,5})?$", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_LOGIN_REGEX = Pattern.compile("[A-Z0-9]", Pattern.UNICODE_CASE);


    public void deleteUser(int id) {
        logic.deleteUser(id);
        LOG.info("User has been deleted.");
    }

    public void updateUser(int id, User user) {
        if (logic.findById(id) != null
                && isValidLogin(user.getLogin())
                && isValidPassword(user.getPassword())
                && isValidName(user.getName())
                && isValidEmail(user.getEmail())
                ) {
            logic.updateUser(id, user);
            LOG.info("User has been updated.");
        } else {
            LOG.error("Invalid user data.");
        }
    }

    public void addUser(User user) {
        if (isValidLogin(user.getLogin())
                && isValidPassword(user.getPassword())
                && isValidName(user.getName())
                && isValidEmail(user.getEmail())
                ) {
            logic.addUser(user);
            LOG.info("User has been added.");
        } else {
            LOG.error("Invalid user data.");
        }
    }


    public List<User> findAll() {
        return logic.findAll();
    }

    private User findById(int id) {
        return logic.findById(id);
    }

    private boolean isValidLogin(String login) {
        Matcher matcher = VALID_LOGIN_REGEX.matcher(login);
        return matcher.find();
    }

    private boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    private boolean isValidPassword(String password) {
        Matcher matcher = VALID_LOGIN_REGEX.matcher(password);
        return matcher.find() && password.length() > 7;
    }

    private boolean isValidName(String name) {
        return name.length() >= 2;
    }

}
