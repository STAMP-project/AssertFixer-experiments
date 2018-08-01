package jg.alexa.model;

import org.jsoup.nodes.Document;

import java.util.List;

/**
 * Created by jgreely on 3/29/18.
 */
public class Recipe {
    private String title;
    private String href;
    private int index;
    private List<String> ingredientList;
    private List<String> directionsList;
    private Document document;

    public Recipe(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<String> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<String> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<String> getDirectionsList() {
        return directionsList;
    }

    public void setDirectionsList(List<String> directionsList) {
        this.directionsList = directionsList;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
