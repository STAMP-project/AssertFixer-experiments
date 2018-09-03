package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTask {
    @Test
    public void whenCollisionTenResult() {
        Calendar calendar = new GregorianCalendar();
        User user1 = new User();
        user1.setName("Name1");
        user1.setChildren(2);
        user1.setBirthday(calendar);


        User user2 = new User();
        user2.setName("Name1");
        user2.setChildren(2);
        user2.setBirthday(calendar);

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
        /*
        объекты разные, поэтому несмотря на одинаковые поля
        поэтому они добавляются
         */

        /*
        Мы получаем олинаковый хэш-код, но эквал не дает тру, поэтому коллекция все равно
        будет содержать два объекта, но в одном бакете
         */
        /*
        как только мы все переопределим, то объекты будут действительно равными, и  второй
        просто не запишется
         */
        /*
        Про коллизии.
        все данные располагаются в зависимости от хэш кода
        если хэшкоды равны, но эквалс не равны, то образуется коллизия
        В джаве коллизия направляется в тот же бакет, но в нем образуется массив,
        сначала из 8 ячеек. и дальше элементы располагаются там.
        Как только элементов становится больше, то вместо массива
        на его месте образуется линкед лист. Сделано это для экономии
        времени для поиска
         */
    }

}
