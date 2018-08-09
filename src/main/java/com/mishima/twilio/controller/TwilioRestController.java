package com.mishima.twilio.controller;

import com.twilio.twiml.Dial;
import com.twilio.twiml.Gather;
import com.twilio.twiml.Method;
import com.twilio.twiml.Number;
import com.twilio.twiml.Say;
import com.twilio.twiml.Say.Voice;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;
import java.io.UnsupportedEncodingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class TwilioRestController {

  @Value("${twilio.baseUrl}")
  private String baseUrl;

  @ResponseBody
  @PostMapping(value = "/receive", produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<byte[]> receive(@RequestParam("CallSid") String callSid,
      @RequestParam("From") String from) throws TwiMLException {
    log.info("Received call sid {} from number {}", callSid, from);
    Gather gather = new Gather.Builder().action(baseUrl + "/confirm").method(Method.POST)
        .timeout(20).say(instructions()).build();
    VoiceResponse response = new VoiceResponse.Builder().gather(gather).say(noResponse()).build();
    return buildResponseEntity(response.toXml());
  }

  @ResponseBody
  @PostMapping(value = "/confirm", produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<byte[]> confirm(@RequestParam("CallSid") String callSid,
      @RequestParam("From") String from,
      @RequestParam(value = "Digits", defaultValue = "") String digits) throws TwiMLException {
    log.info("Received call sid {} from number {} with captured digits {}", callSid, from, digits);
    VoiceResponse response;
    if (!StringUtils.hasText(digits)) {
      log.info("Did not capture any digits from the call");
      Gather gather = new Gather.Builder().action(baseUrl + "/confirm").method(Method.POST)
          .timeout(20).say(noDigits()).build();
      response = new VoiceResponse.Builder().gather(gather).say(noResponse()).build();
      return buildResponseEntity(response.toXml());
    } else {
      log.info("Confirming digits with caller");
      Gather gather = new Gather.Builder().action(baseUrl + "/confirmed?Number=" + digits)
          .method(Method.POST).numDigits(1).timeout(20).say(confirm(digits)).build();
      response = new VoiceResponse.Builder().gather(gather).say(noResponse()).build();
    }
    return buildResponseEntity(response.toXml());
  }

  @ResponseBody
  @PostMapping(value = "/confirmed", produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<byte[]> confirmed(@RequestParam("CallSid") String callSid,
      @RequestParam("From") String from,
      @RequestParam(value = "Digits", defaultValue = "") String digits,
      @RequestParam(value = "Number", defaultValue="") String number) throws TwiMLException {
    log.info("Received call sid {} from number {} with captured digits {}", callSid, from, digits);
    VoiceResponse response;
    if (!StringUtils.hasText(digits)) {
      log.info("Did not capture any digits from the call");
      Gather gather = new Gather.Builder().action(baseUrl + "/confirm").method(Method.POST)
          .timeout(20).say(noDigits()).build();
      response = new VoiceResponse.Builder().gather(gather).say(noResponse()).build();
    } else {
      if ("1".equals(digits)) {
        log.info("Caller confirmed number, dialling...");
        Say say = say("Connecting your call.");
        Dial dial = new Dial.Builder().callerId(from).action(baseUrl + "/recording?CallSid=" + callSid).method(Method.POST)
            .record(Dial.Record.RECORD_FROM_ANSWER).timeout(30).number(new Number.Builder(number).build()).build();
        response = new VoiceResponse.Builder().say(say).dial(dial).build();
      } else {
        log.info("Caller did not confirm number, ask for digits again");
        Gather gather = new Gather.Builder().action(baseUrl + "/confirm").method(Method.POST)
            .timeout(20).say(instructions()).build();
        response = new VoiceResponse.Builder().gather(gather).say(noResponse()).build();
      }
    }
    return buildResponseEntity(response.toXml());
  }

  @ResponseBody
  @PostMapping(value = "/recording", produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<byte[]> recording(@RequestParam("CallSid") String callSid,
                       @RequestParam("DialCallSid") String dialCallSid,
                       @RequestParam("DialCallStatus") String dialCallStatus,
                       @RequestParam("DialCallDuration") int dialCallDuration,
                       @RequestParam("RecordingUrl") String recordingUrl) {
    log.info("Received call sid {}, dial call sid {}, status {}, recording url {}", callSid, dialCallSid, dialCallStatus, recordingUrl);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private ResponseEntity<byte[]> buildResponseEntity(String xml) {
    log.info("Sending response xml: {}", xml);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.TEXT_XML);
    headers.setCacheControl("no-cache");
    try {
      return new ResponseEntity<>(xml.getBytes("utf-8"), headers, HttpStatus.OK);
    } catch (UnsupportedEncodingException ex) {
      log.error("Caught unexpected encoding exception {}", ex);
      throw new IllegalStateException(ex);
    }
  }


  private Say instructions() {
    return say("Please enter the number you wish to call on your keypad followed by the pound key");
  }

  private Say confirm(String digits) {
    StringBuilder confirmDigits = new StringBuilder();
    String delim = "";
    for (char c : digits.toCharArray()) {
      confirmDigits.append(delim).append(c);
      delim = ",";
    }
    return say("I heard " + confirmDigits
        + ". Is that correct? Press 1 to confirm or any other key to try again.");
  }

  private Say noDigits() {
    return say(
        "Sorry, I didn't get that. Please enter the number you wish to call on your keypad followed by the pound key");
  }

  private Say noResponse() {
    return say("Sorry I didn't get any input, Goodbye!");
  }

  private Say say(String message) {
    return new Say.Builder(message).voice(Voice.WOMAN).build();
  }

}
