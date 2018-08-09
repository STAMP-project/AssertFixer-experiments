package com.mishima.twilio.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(TwilioRestController.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc(secure = false)
public class TwilioRestControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @Value("${twilio.baseUrl}")
  private String baseUrl;

  @Test
  public void givenIncomingCallThenReturnInstructions() throws Exception {
    mvc.perform(post("/api/receive")
        .param("CallSid", "12345")
        .param("From", "54321"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_XML))
        .andExpect(content().xml(
            "<Response><Gather timeout=\"20\" action=\"" + baseUrl + "/confirm\" method=\"POST\"><Say language=\"en-gb\" voice=\"alice\">Please enter the number you wish to call on your keypad followed by the pound key</Say></Gather><Say language=\"en-gb\" voice=\"alice\">Sorry I didn't get any input, Goodbye!</Say></Response>"
        ));
  }

  @Test
  public void givenDigitsToCallThenReturnConfirmation() throws Exception {
    mvc.perform(post("/api/confirm")
        .param("CallSid", "12345")
        .param("From", "54321")
        .param("Digits", "556677"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_XML))
        .andExpect(content().xml(
            "<Response><Gather timeout=\"20\" numDigits=\"1\" action=\"http://localhost:8080/api/confirmed?Number=556677\" method=\"POST\"><Say language=\"en-gb\" voice=\"alice\">I heard 5,5,6,6,7,7. Is that correct? Press 1 to confirm or any other key to try again.</Say></Gather><Say language=\"en-gb\" voice=\"alice\">Sorry I didn't get any input, Goodbye!</Say></Response>"
        ));
  }

  @Test
  public void givenNoDigitsToCallThenReturnRetry() throws Exception {
    mvc.perform(post("/api/confirm")
        .param("CallSid", "12345")
        .param("From", "54321"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_XML))
        .andExpect(content().xml(
            "<Response><Gather timeout=\"20\" action=\"http://localhost:8080/api/confirm\" method=\"POST\"><Say language=\"en-gb\" voice=\"alice\">Sorry, I didn't get that. Please enter the number you wish to call on your keypad followed by the pound key</Say></Gather><Say language=\"en-gb\" voice=\"alice\">Sorry I didn't get any input, Goodbye!</Say></Response>"
        ));
  }


  @Test
  public void givenDigitsConfirmedThenReturnDial() throws Exception {
    mvc.perform(post("/api/confirmed")
        .param("CallSid", "12345")
        .param("From", "54321")
        .param("Number", "556677")
        .param("Digits", "1"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_XML))
        .andExpect(content().xml(
            "<Response><Say language=\"en-gb\" voice=\"alice\">Connecting your call.</Say><Dial timeout=\"30\" action=\"http://localhost:8080/api/recording?CallSid=12345\" method=\"POST\" callerId=\"54321\" record=\"record-from-answer\"><Number>556677</Number></Dial></Response>"
        ));
  }

  @Test
  public void givenDigitsUnconfirmedThenReturnRetry() throws Exception {
    mvc.perform(post("/api/confirmed")
        .param("CallSid", "12345")
        .param("From", "54321")
        .param("Number", "556677")
        .param("Digits", "2"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_XML))
        .andExpect(content().xml(
            "<Response><Gather timeout=\"20\" action=\"http://localhost:8080/api/confirm\" method=\"POST\"><Say language=\"en-gb\" voice=\"alice\">Please enter the number you wish to call on your keypad followed by the pound key</Say></Gather><Say language=\"en-gb\" voice=\"alice\">Sorry I didn't get any input, Goodbye!</Say></Response>"
        ));
  }

  @Test
  public void givenNoDigitsConfirmingNumberThenReturnRetry() throws Exception {
    mvc.perform(post("/api/confirmed")
        .param("CallSid", "12345")
        .param("From", "54321")
        .param("Number", "556677"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_XML))
        .andExpect(content().xml(
            "<Response><Gather timeout=\"20\" action=\"http://localhost:8080/api/confirm\" method=\"POST\"><Say language=\"en-gb\" voice=\"alice\">Sorry, I didn't get that. Please enter the number you wish to call on your keypad followed by the pound key</Say></Gather><Say language=\"en-gb\" voice=\"alice\">Sorry I didn't get any input, Goodbye!</Say></Response>"
        ));
  }

  @Test
  public void givenRecordingThenReturnOK() throws Exception {
    mvc.perform(post("/api/recording")
        .param("CallSid", "12345")
        .param("DialCallSid", "2345")
        .param("DialCallDuration", "45")
        .param("RecordingUrl", "http://localhost")
        .param("DialCallStatus", "complete"))
        .andExpect(status().isOk());
  }

  @Test
  public void testBase54() {
    String user = "twilio:password";
    byte[] bytes = Base64.getEncoder().encode(user.getBytes());
    String encoded = new String(bytes);
    System.out.println(encoded);
  }

}
