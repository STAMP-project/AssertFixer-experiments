package com.weaverplatform.postgresql.controllers;

import com.google.common.net.MediaType;
import com.google.gson.Gson;
import com.weaverplatform.postgresql.database.Database;
import com.weaverplatform.postgresql.database.Postgres;
import com.weaverplatform.postgresql.util.WeaverError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Mohamad Alamili
 */
public class DatabaseController {
  private static final Logger log = LoggerFactory.getLogger(DatabaseController.class);

  private static Pattern legalDatabaseNames = Pattern.compile("[0-9a-zA-Z\\.\\-\\_]{3,30}");

  /**
   * Wipe route: wipes the provided database. Note: it actually removes all data.
   * You're unable to retrieve wiped data after this call.
   */
  public static Route wipe = (Request req, Response res) -> {
    String database = req.queryParams("database");
    log.debug(String.format("Going to wipe database %s", database));
    Postgres.INSTANCE.getDatabase(database).wipe();
    log.info(String.format("Wiped database %s", database));
    return "Success";
  };


  /**
   * Execute a Postgres native query
   */
  public static Route postgresQuery = (Request req, Response res) -> {
    String database = req.queryParams("database");
    String query = req.body();
    return new Gson().toJson(Postgres.INSTANCE.getDatabase(database).executePostgresQuery(query));
  };

  /**
   * RelationKeys route: collects and returns all the labels of relationKeys in
   * the database.
   */
  public static Route relationKeys = (Request req, Response res) -> {
    String database = req.queryParams("database");
    List<String> relationKeys = Postgres.INSTANCE.getDatabase(database).getRelationKeys();
    return new Gson().toJson(relationKeys);
  };

  public static Route dump = (Request req, Response res) -> {
    String database = req.queryParams("database");
    boolean zipped = req.queryParams().contains("zipped") && "true".equals(req.queryParams("zipped"));
    if(zipped) {
      res.type(MediaType.OCTET_STREAM.toString());
    }

    Postgres.INSTANCE.getDatabase(database).streamDump(res.raw().getOutputStream(), zipped);
    return res.raw();
  };

  private static List<String> getGraphQueryParams(Request req, String key) {
    List<String> graphs = new ArrayList<>();
    String[] graphsList = req.queryParamsValues(key);
    if (graphsList != null) {
      for (String graph : graphsList) {
        if (graph == null || graph.isEmpty() || graph.equals("null")) {
          graphs.add(null); // For default graph
        } else {
          graphs.add(graph);
        }
      }
    }
    return graphs;
  }

  public static Route dumpGraph = (Request req, Response res) -> {
    String database = req.queryParams("database");
    boolean zipped = req.queryParams().contains("zipped") && "true".equals(req.queryParams("zipped"));
    if(zipped) {
      res.type(MediaType.OCTET_STREAM.toString());
    }

    List<String> graphs = getGraphQueryParams(req, "graph");
    List<String> fromGraphs = getGraphQueryParams(req, "fromGraph");
    List<String> toGraphs = getGraphQueryParams(req, "toGraph");

    log.info("Start streaming a snapshot with graph filters, " +
    "zipped: "+zipped+", " +
    "graphs: ["+ String.join(", ", graphs)+"], " +
    "fromGraphs: ["+ String.join(", ", fromGraphs)+"], " +
    "toGraphs: ["+ String.join(", ", toGraphs)+"] ");

    Postgres.INSTANCE.getDatabase(database).streamGraphDump(res.raw().getOutputStream(), graphs, fromGraphs, toGraphs, zipped);
    return res.raw();
  };

  public static Route load = (Request req, Response res) -> {
    // TODO: Implement
    return "Not implemented";
  };

  public static Route createDatabase = (Request req, Response res) -> {
    String database = req.queryParams("database");
    Postgres.INSTANCE.createDatabase(database);
    log.info("Successfully created database " + database);
    return "Success";
  };

  /**
   * A route which duplicates a given database and adds _copy_x to the
   * database name to differentiate it from the original. This route's
   * functionality differs from the getDump() as getDump() only copies
   * some of the data in the database into WriteOperations, where this
   * route actually creates an indistinguishable (except for the name)
   * copy from the original.
   *
   * It will use the selected database as a template to create the new
   * one. Use this route with caution, it will force drop all open
   * connections to the selected database if it can't be used as a
   * template.
   */
  public static Route duplicateDatabase = (Request req, Response res) -> {
    String database = req.queryParams("database");
    String cloned_database = req.queryParams("cloned_database");
    log.info(String.format("Got request to clone database %s into %s", database, cloned_database));
    Postgres.INSTANCE.duplicateDatabase(database, cloned_database);
    log.info("Successfully duplicated database " + database);
    return "Success";
  };

  public static Route deleteDatabase = (Request req, Response res) -> {
    String database = req.queryParams("database");
    Postgres.INSTANCE.getDatabase(database).delete();
    log.info("Successfully deleted database " + database);
    return "Success";
  };

  public static Route databases = (Request req, Response res) -> {
    return new Gson().toJson(Postgres.INSTANCE.databases());
  };

  public static Route cleanupDatabase = (Request req, Response res) -> {
    String database   = req.queryParams("database");

    Postgres.INSTANCE.getDatabase(database).cleanupDatabase();
    return "Success";
  };

  /**
   * Redirect graph route: Copy all relations from graph a to graph b, so graph a has the same relations to node with
   * matching id's in graph c.
   */
  public static Route redirectGraph = (Request req, Response res) -> {
    String database = req.queryParams("database");
    String sourceGraph = req.queryParams("sourceGraph");
    String oldTargetGraph = req.queryParams("oldTargetGraph");
    String newTargetGraph = req.queryParams("newTargetGraph");
    boolean dryRun = Boolean.parseBoolean(req.queryParams("dryrun"));
    boolean performPartial = Boolean.parseBoolean(req.queryParams("performPartial"));

    Database db = Postgres.INSTANCE.getDatabase(database);
    return db.redirectGraph(sourceGraph, oldTargetGraph, newTargetGraph, dryRun, performPartial);
  };

  public static boolean isLegalDatabaseName(String s) {
    return legalDatabaseNames.matcher(s).matches();
  }
}
