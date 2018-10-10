package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App {

    public static boolean stringToByte(ArrayList<Integer> array1, Integer[] array2, String s1, String s2 ) {
      System.out.println("inside search");
      if (array1 == null || array2 == null) return false;
      if (s1.equals("") || s2.equals("")) return false;
      if(array1.isEmpty() || array2.length == 0) return false;

      String str1 = "";
      String str2 = "";
      for(int e : array1){
        char c = (char)e;  
        str1 += c;
      }

      for(int e : array2){
          char c = (char) e;
          str2 += c;
      }

      return s1.equals(str1) && s2.equals(str2);
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);

          String input2 = req.queryParams("input2").replaceAll("\\s","");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
            Integer[] input = (Integer[]) inputList2.toArray();
            System.out.println(inputList2);

          String input3 = req.queryParams("input3").replaceAll("\\s","");
          String input4 = req.queryParams("input4").replaceAll("\\s","");

          boolean result = App.stringToByte(inputList, input,input3,input4);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
