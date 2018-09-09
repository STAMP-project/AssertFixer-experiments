package zuryanov.servlets.presentation;

public class User {
    private String login;
    private String surname;
    private String country;
    private String city;

    public User() {
    }

    public User(String login, String surname) {
        this.login = login;
    }

    public User(String login, String country, String city) {
        this.login = login;
        this.country = country;
        this.city = city;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
