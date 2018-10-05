package com.weaverplatform.postgresql.loading;

import com.google.common.collect.Lists;
import com.weaverplatform.postgresql.database.Postgres;
import com.weaverplatform.postgresql.util.Resource;
import com.weaverplatform.protocol.WriteOperationParser;
import com.weaverplatform.protocol.model.WriteOperation;

import java.util.List;

/**
 * @author Mohamad Alamili
 */
public class OTLLoader {

  public static void main(String[] args) {
    final String DATABASE = "ocms-rijnland-test";

    String snapshot_json = Resource.get("otl-2.1-with-import-cli-0.0.6.json");

    Postgres.INSTANCE.getDatabase(DATABASE).wipe();
    List<WriteOperation> operations = WriteOperationParser.parse(snapshot_json);

    int i=0;
    for(List<WriteOperation> part : Lists.partition(operations, 500)) {
      System.out.println("Writing 500 of " + (operations.size() - 500 * i++) + " operations");
      Postgres.INSTANCE.getDatabase(DATABASE).write(part);
    }
  }
}
