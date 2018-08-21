package ru.job4j.map;

import java.util.*;

import static java.util.Objects.hash;

public class MapTest {

    public static final class User {

        private String name;
        private int children;
        private Calendar birthday;

        public User(String name, int children, Calendar birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return children == user.children
                    && Objects.equals(name, user.name)
                    && Objects.equals(birthday, user.birthday);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + hash(name);
            result = prime * result + hash(children);
            result = prime * result + hash(birthday);
            return result;
        }
    }

    public static void main(String[] args) {
        Calendar birthday = new GregorianCalendar(1990, 01, 31);
        User first = new User("Egor", 0, birthday);
        User second = new User("Egor", 0, birthday);
        Map<User, String> map = new HashMap<>();
        map.put(first, "First");
        map.put(second, "First");
        System.out.println(map);
        System.out.println(first.equals(second));
    }


    //Без переопределения методов equals() и hashCode().
    //При создании объекта типа User, создается уникальная ссылка для конкретного User.
    //При добавлении в Map генерируется хэш-код объекта User, по умолчанию генерируется хэш-код ссылки объекта User,
    //то есть для разных объектов с одинаковым содержимым, хэш-код будет разный. Далее на основе хэш-кода определяется индекс.
    //Под этим интексом в массиве созается цепочка в которой хранится хэш-код, ключ, ссылка на следующий элемент, и сам объект.


    //При переопределении только hashCode().
    //Получается хэш-код в котором учитывается содержание полей, но так как метод equals() не переопределен и по умолчанию сравниваются ссылки,
    //то в Map добавляются оба элемента.


    //При переопределении только equals().
    //При сравнении элементов сравниваются поля элемента. Но при добавлении в Map вычисляется key.hashCode(), и так как метод hashCode() не переопределен, по
    //умолчанию в основу его работы положен генератор случайных чисел, это означает что при каждом запуске программы у объекта будет разный хэш-код. Поэтому в
    //Map добавляется оба элемента.


    //После переропределения методов hashCode() и equals().
    //После переопределении обоих методов, перед добавлением сравниваются именно внутренние поля, и для одинаковых элементов хэш-коды будут тоже одинаковые.
    //В Map добавляется только первый элемент.
}
