package com.weaverplatform.postgresql.controllers;

import com.google.gson.Gson;
import com.weaverplatform.postgresql.database.Postgres;
import com.weaverplatform.postgresql.database.query.model.CloneOperation;
import com.weaverplatform.postgresql.database.query.model.FindExistingNodesOperation;
import com.weaverplatform.postgresql.database.query.model.QueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import com.weaverplatform.postgresql.util.File;
import com.weaverplatform.postgresql.util.Props;
import com.weaverplatform.protocol.WriteOperationParser;
import com.weaverplatform.protocol.model.WriteOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.servlet.ServletInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * @author Mohamad Alamili
 */
public class NodeController {

  static Logger logger = LoggerFactory.getLogger(NodeController.class);

  public static int UPLOAD_ZIP_CHUNK_SIZE;
  public static int WRITE_OPS_CHUNK_SIZE;
  static {
    UPLOAD_ZIP_CHUNK_SIZE = Integer.parseInt(Props.get("UPLOAD_ZIP_CHUNK_SIZE", "file.upload_zip_chunk_size"));
    WRITE_OPS_CHUNK_SIZE = 5000;
  }
  /**
   * Write route: writes WriteOperations to the database.
   */
  public static Route write = (Request req, Response res) -> {
    String database = req.queryParams("database");
    String creator  = req.queryParams("creator");

    ServletInputStream body = req.raw().getInputStream();
    List<WriteOperation> writeOperations = new ArrayList<>();

    WriteOperationParser parser = new WriteOperationParser();

    List<WriteOperation> nextSet;
    do {
      nextSet = parser.parseNext(body, WRITE_OPS_CHUNK_SIZE);
      if (creator != null){
        nextSet.forEach(operation -> operation.setUser(creator));
      }
      writeOperations.addAll(nextSet);
    } while(!nextSet.isEmpty());

    Postgres.INSTANCE.getDatabase(database).write(writeOperations);
    return "Success";
  };

  /**
   * Query route: Uses Weaver.Query to read nodes.
   */
  public static Route query = (Request req, Response res) -> {
    String database   = req.queryParams("database");
    WeaverQuery query = new Gson().fromJson(req.body(), WeaverQuery.class);

    QueryResult result = Postgres.INSTANCE.getDatabase(database).query(query);
    return result.toJson();
  };

  /**
   * This route will accept a file which is a .GZ (gunzip) file. This file should
   * contain only valid WriteOperation in a JSON structure. This logic has been
   * implemented in the connector for scalabiliy issues, previous attempts where this
   * logic was implemented in weaver-server crashed the server when large zips
   * were used. This route has succesfully been tested with a 13mb zip file
   * containing 600k+ nodes, 90k+ relations and 400k+ attributes. It took approx.
   * 6min for this zip to execute on a 2016 Macbook Pro.
   */
  public static Route uploadZip = (Request req, Response res) -> {

    String database = req.queryParams("database");

    InputStream file = File.get(req, false).getInputStream();
    GZIPInputStream gunZip = new GZIPInputStream(file);

    WriteOperationParser parser = new WriteOperationParser();
    List<WriteOperation> writeOperations = parser.parseNext(gunZip, UPLOAD_ZIP_CHUNK_SIZE);
    while(!writeOperations.isEmpty()) {
      logger.info("Import next "+UPLOAD_ZIP_CHUNK_SIZE);
      Postgres.INSTANCE.getDatabase(database).write(writeOperations);
      writeOperations = parser.parseNext(gunZip, UPLOAD_ZIP_CHUNK_SIZE);
    }

    gunZip.close();
    return "Success";
  };

  public static Route clone = (Request req, Response res) -> {
    String database   = req.queryParams("database");
    logger.trace("Received clone request: " + req.body());
    CloneOperation query = new Gson().fromJson(req.body(), CloneOperation.class);

    Postgres.INSTANCE.getDatabase(database).clone(query);
    return "Success";
  };

  public static Route findExistingNodes = (Request req, Response res) -> {
    String database = req.queryParams("database");
    logger.trace("Received find existing nodes request: " + req.body());
    FindExistingNodesOperation query = new Gson().fromJson(req.body(), FindExistingNodesOperation.class);

    return Postgres.INSTANCE.getDatabase(database).findExistingNodes(query);
  };
}
