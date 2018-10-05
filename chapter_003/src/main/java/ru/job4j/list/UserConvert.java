package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class UserConvert {
    HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
