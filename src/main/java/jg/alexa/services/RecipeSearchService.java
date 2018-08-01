package jg.alexa.services;

import jg.alexa.config.AppConfig;
import jg.alexa.config.AppProperties;
import jg.alexa.model.Recipe;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jgreely on 3/29/18.
 */
public class RecipeSearchService {

    private AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    private AppProperties props = (AppProperties) context.getBean("applicationProperties");

    private String category;
    private String ingredients;

    private static final String LABEL_TAG = "label";

    private static final String HREF_ATTRIBUTE = "href";
    private static final String TITLE_ATTRIBUTE = "title";

    public RecipeSearchService(){ super(); }

    public RecipeSearchService(String category, String ingredients){
        this.category = category;
        this.ingredients = ingredients;
    }

    public List<Recipe> getRecipes() throws IOException{
        String uri = props.getAllRecipeBaseUri() + String.format(props.getAllRecipeSearch(), category, ingredients);

        Document allRecipeSearchResult = Jsoup.connect(uri).get();
        Elements elements = allRecipeSearchResult.select(props.getAllRecipeIdentifier());

        List<Recipe> recipeList = new ArrayList();

        for(Element element : elements){
            if(StringUtils.isNotBlank(element.text())){
                Recipe recipe = new Recipe();

                recipe.setTitle(element.text());
                recipe.setHref(element.attr(HREF_ATTRIBUTE));

                recipeList.add(recipe);
            }
        }
        return recipeList;
    }

    public List<String> getIngredients(Document recipe){
        List<String> ingredientList = new ArrayList();

        Elements lists = recipe.select(props.getAllRecipeIngredientIdentifier());

        if(!lists.isEmpty()) {
            for (Element list : lists) {
                Elements ingredients = list.select(LABEL_TAG);

                for(Element ingredient : ingredients){
                    String title = ingredient.attr(TITLE_ATTRIBUTE);

                    if(StringUtils.isNotBlank(title)){
                        ingredientList.add(title);
                    }
                }
            }
        }
        return ingredientList;
    }

    public List<String> getDirections(Document recipe){
        List<String> directionsList = new ArrayList();

        Elements steps = recipe.select(props.getAllRecipeDirectionIdentifier());

        if(!steps.isEmpty()){
            for(Element step : steps){
                String text = step.text();

                if(StringUtils.isNotBlank(text)){
                    directionsList.add(text);
                }
            }
        }

        return directionsList;
    }

    public Document getDocument(String href) throws IOException{
        Document document = Jsoup.connect(href).get();

        return document;
    }
}
