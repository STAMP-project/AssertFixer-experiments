package com.weaverplatform.postgresql.performance;

import com.weaverplatform.postgresql.util.Resource;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Mohamad Alamili
 */
public class NounGenerator {

  private String[] nouns;
  private Set<String> generatedNouns = new HashSet<>();
  private Random random;

  public NounGenerator(String fileName) {
    this.nouns    = StringUtils.split(Resource.get(fileName), "\n");

    for (int i=0; i < nouns.length; i++){
      nouns[i] = capitalize(nouns[i]);
    }

    this.random = new Random();
  }

  private String capitalize(String input) {
    return input.substring(0, 1).toUpperCase() + input.substring(1);
  }

  private int getRandomIndex(){
    return random.nextInt(nouns.length - 1);
  }

  public String getNoun() {
    return nouns[getRandomIndex()];
  }

  public String getSomeNouns() {
    int count = random.nextInt(3) + 1;
    String noun = "";
    while(count-- > 0){
      noun += getNoun();
    }

    // try again if already generated
    if (generatedNouns.contains(noun)) {
      return getSomeNouns();
    }
    else {
      generatedNouns.add(noun);
      return noun;
    }
  }
}
