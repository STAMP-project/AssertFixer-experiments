package model.map;

import model.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Continent {

    private String id;
    private String name;
    private List<Country> adjacentContinents;
    private HashMap<String, Country> countries;
    private Player owner;
    private int controlValue;

    public Continent(String name,HashMap<String, Country> countries,int controlValue){
        this.id = UUID.randomUUID().toString();//make random id
        this.name = name;
        this.controlValue=controlValue;
        this.adjacentContinents =new ArrayList<Country>();
        this.countries=countries;
    }

    public Continent(String name, List<Country> adjacentContinents, HashMap<String, Country> countries, Player player,int controlValue) {
        this.id = UUID.randomUUID().toString();//make random id
        this.name = name;
        this.adjacentContinents = adjacentContinents;
        this.countries = countries;
        this.owner = player;
        this.controlValue=controlValue;
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

    public List<Country> getAdjacentContinents() {
        return adjacentContinents;
    }

    public HashMap<String, Country> getCountries() {
        return countries;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getControlValue() {
        return controlValue;
    }

    public void setControlValue(int controlValue) {
        this.controlValue = controlValue;
    }
}
