package model.map;

import model.player.Player;

import java.util.List;
import java.util.UUID;

public class Country {
    private String id;
    private String name;
    private List<Country> adjacentCountries;
    private Player owner;
    private int armyCount;
    private int latitude;
    private int longitude;
    private int order;//this field is used for checking the connectivity of countries
    private int continentOrder;//this field is used for checking the connectivity in continent

    public Country(String name){
        this.id = UUID.randomUUID().toString();//make random id
        this.name = name;
    }

    public Country(String name, List<Country> adjacentCountries, Player owner) {
        this.id = UUID.randomUUID().toString();//make random id
        this.name = name;
        this.adjacentCountries = adjacentCountries;
        this.owner = owner;
        this.armyCount = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getAdjacentCountries() {
        return adjacentCountries;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getArmyCount() {
        return armyCount;
    }

    public void setArmyCount(int armyCount) {
        this.armyCount = armyCount;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setAdjacentCountries(List<Country> adjacentCountries) {
        this.adjacentCountries = adjacentCountries;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getContinentOrder() {
        return continentOrder;
    }

    public void setContinentOrder(int continentOrder) {
        this.continentOrder = continentOrder;
    }
}
