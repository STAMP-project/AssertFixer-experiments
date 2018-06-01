package jg.alexa.helpers;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SsmlOutputSpeech;
import jg.alexa.config.AppConfig;
import jg.alexa.config.AppProperties;
import jg.alexa.model.Recipe;
import jg.alexa.services.RecipeSearchService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jgreely on 3/28/18.
 */
public class SpeechletHelper {

    private AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    private AppProperties props = (AppProperties) context.getBean("applicationProperties");

    private static final Logger log = LoggerFactory.getLogger(SpeechletHelper.class);

    private List<Recipe> recipeList;
    private Recipe selectedRecipe;

    private static final String CATEGORY_SLOT = "category";
    private static final String INGREDIENTS_SLOT = "ingredients";
    private static final String ID_SLOT = "id";

    private static final String INGREDIENTS_REGEX = " ";
    private static final String BLANK = "";

    public SpeechletHelper(){
        recipeList = new ArrayList();
    }

    public SpeechletResponse findRecipe(Intent intent){
        Slot categorySlot = intent.getSlot(CATEGORY_SLOT);
        Slot ingredientsSlot = intent.getSlot(INGREDIENTS_SLOT);

        if(categorySlot == null || StringUtils.isBlank(categorySlot.getValue())){
            String output = props.getFindCategory().concat(" " + props.getFindAsk());
            String reprompt = props.getExplainIntents();

            return newAskResponse(output, reprompt);
        } else if(ingredientsSlot == null || StringUtils.isBlank(ingredientsSlot.getValue())){
            String output = props.getFindIngredients().concat(" " + props.getFindAsk());
            String reprompt = props.getExplainIntents();

            return newAskResponse(output, reprompt);
        } else {
            log.info(String.format("Searching for {} recipes, utilizing {}", categorySlot.getValue(), ingredientsSlot.getValue()));

            String category = categorySlot.getValue();
            String ingredients = ingredientsSlot.getValue();

            ingredients = ingredients.replaceAll(INGREDIENTS_REGEX, BLANK);

            RecipeSearchService searchService = new RecipeSearchService(category, ingredients);

            try {
                recipeList = searchService.getRecipes();
            } catch (IOException e){
                log.error("Error occurred while searching for recipes: " + e);
            }

            if(!recipeList.isEmpty()){
                StringBuilder speechBuilder = new StringBuilder();
                speechBuilder.append(String.format("Here are some {} recipes- ", category));

                for(Recipe recipe : recipeList){
                    speechBuilder.append(recipe.getTitle());
                    speechBuilder.append(". ");
                }

                speechBuilder.append("Hear anything you like?");

                String output = speechBuilder.toString();
                String reprompt = "Which recipe would you like to check?";

                return newAskResponse(output, reprompt);

            } else {
                String output = "I'm sorry, I couldn't find any recipes like that. Would you like to try again?";
                String reprompt = props.getFindAsk();

                return newAskResponse(output, reprompt);
            }
        }
    }

    public SpeechletResponse selectRecipe(Intent intent){
        Slot idSlot = intent.getSlot(ID_SLOT);

        Recipe recipe;

        if(StringUtils.isNotBlank(idSlot.getValue())){
            try{
                Integer index = Integer.valueOf(idSlot.getValue());
                recipe = identifyRecipe(index);
            } catch (RuntimeException e){
                String index = idSlot.getValue();
                recipe = identifyRecipe(index);
            }

            if (recipe != null){
                RecipeSearchService service = new RecipeSearchService();

                selectedRecipe = recipe;

                try {
                    selectedRecipe.setDocument(service.getDocument(selectedRecipe.getHref()));
                } catch (IOException e){
                    log.error("Error occurred while setting recipe document for {}:{}", selectedRecipe.getTitle(), e);
                }
            }
        }

        return new SpeechletResponse();
    }

    public SpeechletResponse readIngredients(){
        if(selectedRecipe != null) {
            RecipeSearchService searchService = new RecipeSearchService();

            selectedRecipe.setIngredientList(searchService.getIngredients(selectedRecipe.getDocument()));

            if(!selectedRecipe.getIngredientList().isEmpty()){
                StringBuilder speechBuilder = new StringBuilder();
                speechBuilder.append(String.format("Here are the ingredients for {}", selectedRecipe.getTitle()));
                speechBuilder.append("- ");

                for(String ingredient : selectedRecipe.getIngredientList()){
                    speechBuilder.append(ingredient);
                    speechBuilder.append(", ");
                }

                speechBuilder.append(". Sound good?");

                String output = speechBuilder.toString();
                String reprompt = "Would you like to cook this recipe?";

                return newAskResponse(output, reprompt);
            } else {
                String output = "I couldn't find any ingredients for this recipe. Let's try again.";
                return SpeechletResponse.newTellResponse(getOutputSpeech(output));
            }
        } else {
            String output = "You haven't selected a recipe yet. Which recipe would you like to try?";
            String reprompt = "Which recipe would you like to try?";

            return newAskResponse(output, reprompt);
        }
    }

    public Recipe identifyRecipe(int index){
        return recipeList.get(index);
    }

    public Recipe identifyRecipe(String title){
        Recipe recipe = null;

        for(Recipe r : recipeList){
            if(StringUtils.contains(r.getTitle(), title)){
                return r;
            }
        }

        return recipe;
    }

    public SpeechletResponse readDirections(){
        if(selectedRecipe != null && StringUtils.isNotBlank(selectedRecipe.getHref())){
            RecipeSearchService service = new RecipeSearchService();

            selectedRecipe.setDirectionsList(service.getDirections(selectedRecipe.getDocument()));

            if(!selectedRecipe.getDirectionsList().isEmpty()){
                StringBuilder builder = new StringBuilder();

            } else {

            }
        } else {
            //return same message as ingredients
        }
        return new SpeechletResponse();
    }

    public SpeechletResponse newAskResponse(String output, String repropmt){
        SsmlOutputSpeech outputSpeech = getOutputSpeech(output);
        SsmlOutputSpeech repromptSpeech = getOutputSpeech(repropmt);

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptSpeech);

        return SpeechletResponse.newAskResponse(outputSpeech, reprompt);
    }

    private SsmlOutputSpeech getOutputSpeech(String speechContent){
        StringBuilder outputBuilder = new StringBuilder();

        outputBuilder.append("<speak>");
        outputBuilder.append(speechContent);
        outputBuilder.append("</speak>");

        SsmlOutputSpeech outputSpeech = new SsmlOutputSpeech();
        outputSpeech.setSsml(outputBuilder.toString());

        return outputSpeech;
    }
}
