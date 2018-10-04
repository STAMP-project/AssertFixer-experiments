package com.weaverplatform.sdk;

import com.weaverplatform.protocol.WriteOperationParser;
import com.weaverplatform.protocol.model.AttributeDataType;
import com.weaverplatform.protocol.model.CreateAttributeOperation;
import com.weaverplatform.protocol.model.WriteOperation;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


/**
 * Created by bastbijl
 */
public class ParseTest {


  static String readFile(String path, Charset encoding)
    throws IOException
  {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, encoding);
  }

  @Test
  public void test() throws IOException {


    String content = readFile("file.json", Charset.forName("UTF-8"));

    long start = System.currentTimeMillis();
    List<WriteOperation> list = WriteOperationParser.parse(content, null);
    long elapsedTime = System.currentTimeMillis() - start;
    System.out.println(elapsedTime);
    int CreateRelationOperation_count = 0;
    int CreateAttributeOperation_count = 0;
    int CreateNodeOperation_count = 0;

    for(WriteOperation item : list) {
      if(item != null) {
        if("CreateRelationOperation".equals(item.getClass().getSimpleName())) {
          CreateRelationOperation_count++;
        } else if("CreateAttributeOperation".equals(item.getClass().getSimpleName())) {
          CreateAttributeOperation_count++;
        } else if("CreateNodeOperation".equals(item.getClass().getSimpleName())) {
          CreateNodeOperation_count++;
        }
      } else {
        throw new Error();
      }
    }
    Assert.assertEquals(7695, CreateNodeOperation_count);
    Assert.assertEquals(10900, CreateAttributeOperation_count);
    Assert.assertEquals(21369, CreateRelationOperation_count);
  }


  @Test
  public void valueTest() {
    CreateAttributeOperation operation = new CreateAttributeOperation("user", "id", "sourceId", "key", 1, AttributeDataType.XSD_INT);
    String json = operation.toJson();
    System.out.println(json);
    CreateAttributeOperation op = (CreateAttributeOperation) WriteOperationParser.parse("["+json+"]").get(0);
    System.out.println(op.getValue().asDouble());
  }


}
