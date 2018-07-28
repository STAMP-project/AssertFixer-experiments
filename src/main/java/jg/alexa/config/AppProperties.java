package jg.alexa.config;

/**
 * Created by jgreely on 3/28/18.
 */
public class AppProperties {

    //Alexa
    //Launch
    private String welcomeMessage;
    private String explainIntents;

    //FindRecipe intent
    private String findCategory;
    private String findIngredients;
    private String findAsk;

    //Search service
    //AllRecipes
    private String allRecipeBaseUri;
    private String allRecipeSearch;
    private String allRecipeIdentifier;
    private String allRecipeIngredientIdentifier;
    private String allRecipeDirectionIdentifier;

    //Alexa
    //Launch
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getExplainIntents() {
        return explainIntents;
    }

    public void setExplainIntents(String explainIntents) {
        this.explainIntents = explainIntents;
    }

    //FindRecipe intent
    public String getFindCategory() {
        return findCategory;
    }

    public void setFindCategory(String findCategory) {
        this.findCategory = findCategory;
    }

    public String getFindIngredients() {
        return findIngredients;
    }

    public void setFindIngredients(String findIngredients) {
        this.findIngredients = findIngredients;
    }

    public String getFindAsk() {
        return findAsk;
    }

    public void setFindAsk(String findAsk) {
        this.findAsk = findAsk;
    }

    //Search service

    //Allrecipes
    public String getAllRecipeBaseUri() {
        return allRecipeBaseUri;
    }

    public void setAllRecipeBaseUri(String allRecipeBaseUri) {
        this.allRecipeBaseUri = allRecipeBaseUri;
    }

    public String getAllRecipeSearch() {
        return allRecipeSearch;
    }

    public void setAllRecipeSearch(String allRecipeSearch) {
        this.allRecipeSearch = allRecipeSearch;
    }

    public String getAllRecipeIdentifier() {
        return allRecipeIdentifier;
    }

    public void setAllRecipeIdentifier(String allRecipeIdentifier) {
        this.allRecipeIdentifier = allRecipeIdentifier;
    }

    public String getAllRecipeIngredientIdentifier() {
        return allRecipeIngredientIdentifier;
    }

    public void setAllRecipeIngredientIdentifier(String allRecipeIngredientIdentifier) {
        this.allRecipeIngredientIdentifier = allRecipeIngredientIdentifier;
    }

    public String getAllRecipeDirectionIdentifier() {
        return allRecipeDirectionIdentifier;
    }

    public void setAllRecipeDirectionIdentifier(String allRecipeDirectionIdentifier) {
        this.allRecipeDirectionIdentifier = allRecipeDirectionIdentifier;
    }
}
