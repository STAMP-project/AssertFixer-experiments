package com.weaverplatform.postgresql.performance;

import com.weaverplatform.postgresql.database.Postgres;
import com.weaverplatform.postgresql.database.query.model.QueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;

import java.util.TimeZone;

/**
 * @author Mohamad Alamili
 */
public class QueryPerformance {
  public static void main(String[] args){
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

    // Warming up
    Postgres.INSTANCE.getDatabase("postgres").query(new WeaverQuery());

    // Get all
    QueryResult result = Postgres.INSTANCE.getDatabase("postgres").query(new WeaverQuery());
    System.out.println(result);
  }
}
