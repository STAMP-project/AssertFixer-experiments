package jg.alexa.speechlets;

import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import com.amazon.speech.speechlet.services.DirectiveServiceClient;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jgreely on 3/28/18.
 */
public class SousChefRequestStreamHandler extends SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds;

    static {
        supportedApplicationIds = new HashSet<String>();
        supportedApplicationIds.add("amzn1.ask.skill.07a30b55-82b4-4763-a2a8-e7767587f534");
    }

    public SousChefRequestStreamHandler() {
        super(new SousChefSpeechlet(new DirectiveServiceClient()), supportedApplicationIds);
    }

    public SousChefRequestStreamHandler(Speechlet speechlet,
                                               Set<String> supportedApplicationIds) {
        super(speechlet, supportedApplicationIds);
    }
}
