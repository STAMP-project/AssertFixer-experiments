package io.vertx.core.net;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Converter for {@link io.vertx.core.net.Pkcs11Options}.
 * NOTE: This class has been automatically generated from the {@link io.vertx.core.net.Pkcs11Options} original class using Vert.x codegen.
 */
public class Pkcs11OptionsConverter {

  public static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, Pkcs11Options obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "password":
          if (member.getValue() instanceof String) {
            obj.setPassword((String)member.getValue());
          }
          break;
      }
    }
  }

  public static void toJson(Pkcs11Options obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

  public static void toJson(Pkcs11Options obj, java.util.Map<String, Object> json) {
    if (obj.getPassword() != null) {
      json.put("password", obj.getPassword());
    }
  }
}
