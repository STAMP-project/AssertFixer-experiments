package jg.alexa.speechlets;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.speechlet.services.DirectiveService;
import jg.alexa.config.AppConfig;
import jg.alexa.config.AppProperties;
import jg.alexa.helpers.SpeechletHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by jgreely on 3/28/18.
 */
public class SousChefSpeechlet implements SpeechletV2 {


    private AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    private AppProperties props = (AppProperties) context.getBean("applicationProperties");

    private static final Logger log = LoggerFactory.getLogger(SousChefSpeechlet.class);

    private SpeechletHelper helper;

    private static final String FIND_RECIPE_INTENT = "FindRecipe";
    private static final String SELECT_RECIPE_INTENT = "SelectRecipe";
    private static final String READ_INGREDIENTS_INTENT = "ReadIngredients";
    private static final String COOK_RECIPE_INTENT = "CookRecipe";

    public SousChefSpeechlet(DirectiveService directiveService){
        helper = new SpeechletHelper();
    }

    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope){
        SessionStartedRequest request = requestEnvelope.getRequest();
        Session session = requestEnvelope.getSession();

        log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope){
        LaunchRequest request = requestEnvelope.getRequest();
        Session session = requestEnvelope.getSession();

        log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        String speechOutput = props.getWelcomeMessage();
        String repromptOutput = props.getExplainIntents();

        return helper.newAskResponse(speechOutput, repromptOutput);
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope){
        log.info("onIntent requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
                requestEnvelope.getSession().getSessionId());

        Intent intent = requestEnvelope.getRequest().getIntent();
        String intentName = intent.getName();

        if(StringUtils.equalsIgnoreCase(FIND_RECIPE_INTENT, intentName)){
            return helper.findRecipe(intent);
        } else if(StringUtils.equalsIgnoreCase(SELECT_RECIPE_INTENT, intentName)){

        } else if(StringUtils.equalsIgnoreCase(READ_INGREDIENTS_INTENT, intentName)){
            return helper.readIngredients();
        } else if(StringUtils.equalsIgnoreCase(COOK_RECIPE_INTENT, intentName)){
            return helper.readDirections();
        }

        return new SpeechletResponse();
    }

    @Override
    public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope){

    }
}
