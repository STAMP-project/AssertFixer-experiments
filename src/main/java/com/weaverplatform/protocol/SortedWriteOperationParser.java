package com.weaverplatform.protocol;


import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.weaverplatform.protocol.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.util.Set;
import java.util.TreeSet;


import static com.weaverplatform.util.SortUtil.*;


/**
 * @author bastbijl
 */
public class SortedWriteOperationParser extends WriteOperationParser {

  public static Character sortChar(String id) {
    if(id == null || id.trim().isEmpty()) {
      return Character.MIN_VALUE;
    }
    return id.charAt(id.length()-1); // use last character
  }

  public static Set<Character> startChars(InputStream stream) throws IOException {
    TreeSet<Character> set = new TreeSet<>(charComparator);
    JsonReader reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
    reader.beginArray();

    while(reader.hasNext()) {
      String id = sortKey(gson.fromJson(reader, new TypeToken<WriteOperation>(){}.getType()));
      Character sc = sortChar(id);
      set.add(sc);
    }
    return set;
  }

  public TreeSet<WriteOperation> parseNextSorted(InputStream stream, int chunkSize, Character filter) {
    TreeSet<WriteOperation> set = new TreeSet<>(writeOperationComparator);

    try {
      if (reader == null) {
        reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
        reader.beginArray();
      }

      while (reader.hasNext() && set.size() < chunkSize) {

        WriteOperation operation = gson.fromJson(reader, new TypeToken<WriteOperation>(){}.getType());
        if (filter == null || filter.equals(sortChar(sortKey(operation)))) {
          set.add(operation);
        }
      }
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return set;
  }
}

