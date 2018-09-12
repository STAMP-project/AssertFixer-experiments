package com.weaverplatform.postgresql.database.query.model;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Mohamad Alamili
 */
public abstract class QueryResult {

  protected static final Gson gson;

  static {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
      @Override
      public Date deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
        throws JsonParseException {
        try {
          return df.parse(json.getAsString());
        } catch (ParseException e) {
          return null;
        }
      }
    });

    gson = gsonBuilder.create();
  }

  private HashMap<String, Long> times = new HashMap<>();

  public QueryResult(long executionTime) {
    setExecutionTime(executionTime);
  }


  public void setExecutionTime(long executionTime) {
    setTimes("executionTime", executionTime);
  }

  public void setExecutionTimeStart(long executionTimeStart) {
    setTimes("executionTimeStart", executionTimeStart);
  }

  public void setProcessingTime(long processingTime) {
    setTimes("processingTime", processingTime);
  }

  public void setProcessingTimeEnd(long processingTimeEnd) {
    setTimes("processingTimeEnd", processingTimeEnd);
  }

  public void setSubQueryTime(long subQueryTime) {
    setTimes("subQueryTime", subQueryTime);
  }

  public void setTotalTime(long totalTime) {
    setTimes("totalConnectorTime", totalTime);
  }

  public HashMap<String, Long> getTimes() {
    return times;
  }

  public void setTimes(String time, Long duration) {
    if (times.containsKey(time)) {
      times.replace(time, duration);
    } else {
      times.put(time, duration);
    }
  }

  public String toJson() {
    return gson.toJson(this);
  }

}
