package ru.job4j.list;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Класс принимает List пользователей и возвращает Map c ключом id.
 */
import java.util.HashMap;
import java.util.List;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
