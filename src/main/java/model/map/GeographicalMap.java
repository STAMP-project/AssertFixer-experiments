package model.map;

import java.util.HashMap;

public class GeographicalMap {
    private HashMap<String, Country> countries;
    private HashMap<String, Continent> continents;

    //info in the file of map
    private String author;
    private String imageName;
    private Boolean wrap;
    private Boolean warn;
    private String scroll;
    private String filePath;


    public GeographicalMap() {
        this.countries = new HashMap<String, Country>();
        this.continents = new HashMap<String, Continent>();
    }

    public GeographicalMap(String author) {
        this.countries = new HashMap<String, Country>();
        this.continents = new HashMap<String, Continent>();
        this.author = author;
    }

    public Country getCountry(String id) {
        return countries.get(id);
    }

    public Continent getContinent(String id) {
        return continents.get(id);
    }


    public HashMap<String, Country> getCountries() {
        return countries;
    }

    public void setCountries(HashMap<String, Country> countries) {
        this.countries = countries;
    }

    public HashMap<String, Continent> getContinents() {
        return continents;
    }

    public void setContinents(HashMap<String, Continent> continents) {
        this.continents = continents;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Boolean getWrap() {
        return wrap;
    }

    public void setWrap(Boolean wrap) {
        this.wrap = wrap;
    }

    public Boolean getWarn() {
        return warn;
    }

    public void setWarn(Boolean warn) {
        this.warn = warn;
    }

    public String getScroll() {
        return scroll;
    }

    public void setScroll(String scroll) {
        this.scroll = scroll;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void print(){
        System.out.println("*********************");
        System.out.println("name of file : "+ getFilePath());
        System.out.println("size of country : "+getCountries().size());
        System.out.println("size of continent : "+getContinents().size());

    }
}
