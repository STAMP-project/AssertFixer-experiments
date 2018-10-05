package ru.job4j.bank;

public class User {

    private String name;
    private String passport;

    User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    String getName() {
        return name;
    }

    String getPassport() {
        return passport;
    }

    /**
     * Переопределение метода equals.
     *
     * @param obj объект.
     * @return true, если объекты равны.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return this.passport.equals(user.passport);
    }

    /**
     * Переопределение метода hashCode.
     *
     * @return hashCode, объекта, ориентируясь на поле паспорт.
     */
    @Override
    public int hashCode() {
        return this.passport.hashCode();
    }
}
