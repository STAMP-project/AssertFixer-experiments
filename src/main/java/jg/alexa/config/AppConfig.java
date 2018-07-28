package jg.alexa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by jgreely on 3/28/18.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Autowired
    Environment env;

    @Bean
    AppProperties appProperties(){
        AppProperties props = new AppProperties();

        //Alexa
        //Launch
        props.setWelcomeMessage(env.getProperty("alexa.message.welcome"));
        props.setExplainIntents(env.getProperty("alexa.message.intents"));

        //FindRecipe intent
        props.setFindCategory(env.getProperty("alexa.message.find.category"));
        props.setFindIngredients(env.getProperty("alexa.message.find.ingredients"));
        props.setFindAsk(env.getProperty("alexa.message.find.ask"));

        //Search service
        //Allrecipe
        props.setAllRecipeBaseUri(env.getProperty("recipe.search.allrecipe.baseURI"));
        props.setAllRecipeSearch(env.getProperty("recipe.search.allrecipe.search"));
        props.setAllRecipeIdentifier(env.getProperty("recipe.search.allrecipe.identifier.recipe"));
        props.setAllRecipeIngredientIdentifier(env.getProperty("recipe.search.allrecipe.identifier.ingredients"));
        props.setAllRecipeDirectionIdentifier(env.getProperty("recipe.search.allrecipe.identifier.directions"));

        return props;
    }
}
