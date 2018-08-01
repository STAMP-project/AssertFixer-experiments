package services;

import jg.alexa.model.Recipe;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jgreely on 3/29/18.
 */
public class RecipeSearchServiceTest {
    private static final Logger log = LoggerFactory.getLogger(RecipeSearchServiceTest.class);

    private static final String ALLRECIPE_URI = "https://www.allrecipes.com/search/results/?wt=vegan&ingIncl=tofu,spinach&sort=re";
    private static final String ALLRECIPE_RECIPE_URI = "https://www.allrecipes.com/recipe/214491/mushroom-melt-stuffed-chicken/";

    private static final String ALLRECIPE_IDENTIFIER = "h3.grid-col__h3 a";
    private static final String ALLRECIPE_INGREDIENT_IDENTIFIER = "ul[id^=lst_ingredients_]";
    private static final String ALLRECIPE_DIRECTION_IDENTIFIER = "ol.recipe-directions__list li.step";

    @Test
    public void allRecipeGetRecipes() throws IOException {
        log.debug("Testing AllRecipe.com retrieve recipes..");

        log.debug("Connecting to {}", ALLRECIPE_URI);
        Document searchResult = Jsoup.connect(ALLRECIPE_URI).get();

        Elements elements = searchResult.select(ALLRECIPE_IDENTIFIER);

        log.debug("{} results found using selector {}", elements.size(), ALLRECIPE_IDENTIFIER);

        List<Recipe> recipeList = new ArrayList();

        for(int i = 0; i < elements.size(); i++){
            Element element = elements.get(i);

            if(StringUtils.isNotBlank(element.text())){
                Recipe recipe = new Recipe();

                recipe.setTitle(element.text());
                recipe.setHref(element.attr("href"));
                recipe.setIndex(i);

                recipeList.add(recipe);
            }
        }
        log.debug("{} usable results..", recipeList.size());

        assert(!recipeList.isEmpty());
    }

    @Test
    public void allRecipeGetIngredients() throws IOException{
        List<String> ingredientsList = new ArrayList();

        log.debug("Testing AllRecipe.com get ingredients..");
        log.debug("Connecting to {}", ALLRECIPE_RECIPE_URI);

        Document recipe = Jsoup.connect(ALLRECIPE_RECIPE_URI).get();

        Elements recipeLists = recipe.select(ALLRECIPE_INGREDIENT_IDENTIFIER);

        log.debug("{} recipe lists found using selector {}", recipeLists.size(), ALLRECIPE_INGREDIENT_IDENTIFIER);

        for(Element list : recipeLists){
            Elements ingredients = list.select("label");

            for(Element ingredient : ingredients){
                ingredientsList.add(ingredient.attr("title"));
            }
        }

        assert(!ingredientsList.isEmpty());
    }

    @Test
    public void allRecipeGetDirections() throws IOException{
        List<String> directionsList = new ArrayList();

        log.debug("Testing AllRecipes.com get directions..");
        log.debug("Connecting to {}", ALLRECIPE_RECIPE_URI);

        Document recipe = Jsoup.connect(ALLRECIPE_RECIPE_URI).get();

        Elements steps = recipe.select(ALLRECIPE_DIRECTION_IDENTIFIER);

        log.debug("{} steps found using selector {}", steps.size(), ALLRECIPE_DIRECTION_IDENTIFIER);

        for(Element step : steps){
            String text = step.text();

            if(StringUtils.isNotBlank(text)) {
                directionsList.add(text);
            }
        }

        assert(!directionsList.isEmpty());
    }
}