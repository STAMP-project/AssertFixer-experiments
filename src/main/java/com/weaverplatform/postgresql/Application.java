package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.controllers.ApplicationController;
import com.weaverplatform.postgresql.controllers.DatabaseController;
import com.weaverplatform.postgresql.controllers.NodeController;
import com.weaverplatform.postgresql.util.CORS;
import com.weaverplatform.postgresql.util.Props;
import com.weaverplatform.postgresql.util.WeaverError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

/**
 * The main Application class in which all processes are bootstrapped and
 * initialized. Default properties are loaded, Spark routing controllers are
 * initialised and mapped to their respective routes. Spark itself gets setup
 * and started.
 *
 * @author alex
 *
 */
public class Application {

  static Logger logger = LoggerFactory.getLogger(Application.class);

  final int PORT        = Props.getInt("PORT", "application.port");

  public Application() {

    // Read properties
    final String NAME     = Props.get("application.name");
    final String VERSION  = Props.get("application.version");

    // Port for Spark to listen on
    port(PORT);

    // Setup thread pool
    threadPool(100, 5, 30000);

    // For all requests, enable cross origin headers
    CORS.enable();

    // Route registration and mapping
    get("/",                   ApplicationController.about);
    get("/about",              ApplicationController.about);
    get("/connection",         ApplicationController.connection);

    post("/upload",            NodeController.uploadZip);
    post("/write",             NodeController.write);
    post("/query",             NodeController.query);
    post("/node/clone",        NodeController.clone);
    post("/findExistingNodes", NodeController.findExistingNodes);

    post("/graph/redirect",     DatabaseController.redirectGraph);

    post("/createDatabase",    DatabaseController.createDatabase);
    post("/duplicateDatabase", DatabaseController.duplicateDatabase);
    post("/deleteDatabase",    DatabaseController.deleteDatabase);
    post("/postgresQuery",     DatabaseController.postgresQuery);
    get("/databases",          DatabaseController.databases);
    get("/cleanup",            DatabaseController.cleanupDatabase);

    get("/relationKeys",       DatabaseController.relationKeys);
    get("/dump",               DatabaseController.dump);
    get("/dumpGraph",          DatabaseController.dumpGraph);
    get("/load",               DatabaseController.load);
    get("/wipe",               DatabaseController.wipe);
    get("*",                   ApplicationController.notFound);

    // Wait for server initialization
    awaitInitialization();

    // Catch WeaverError exceptions
    exception(WeaverError.class, (e, request, response) -> {
      response.status(400);
      response.body(e.toJson());
    });

    // Catch all other exceptions
    exception(Exception.class, (e, request, response) -> {
      logger.error("Server Error", e);
      response.status(503);
      response.body("503 - Server Error");
    });

    // Running
    logger.info("Running " + NAME + " " + VERSION + " on port " + PORT);
  }

  public int getPort() {
    return PORT;
  }

  public static void main(String[] args) {
    new Application();
  }
}
