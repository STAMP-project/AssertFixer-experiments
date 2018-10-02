package com.mycompany.app;
import java.util.ArrayList;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
/**
 * Hello world!
 *
 */
public class App {
    public static StringBuilder build(ArrayList<Integer> array, ArrayList<Integer> array2, ArrayList<String> array3, int e) {
        System.out.println("inside search");
        int size = array3.size();
        String chosenString = array3.get((int)(Math.random()*size));
        String builtString = "";
        //Even numbers are chosen from list 1 and added to the builtString.
        for(int a: array)
        	if(a%2==0 && a<chosenString.length())
        		builtString = builtString + chosenString.charAt(a);
        //Odd numbers are chosen from list 2 and added to the builtString.
        for(int a: array2)
        	if(a%2==1 && a<chosenString.length())
        		builtString = builtString + chosenString.charAt(a);
        //Repeats the builtstring e times.
        StringBuilder sb1 = new StringBuilder(builtString);
        StringBuilder sb2 = new StringBuilder("null");
        for(int i = 0; i<e-1; i++)
        	sb1.append(builtString);
        if(chosenString.length()<1)
        	return sb2;
        return sb1;
    }    
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "BIL 481 Homework(Alper Kaan YILDIZ) "
        		+ "\nadd /compute to the url to reach the algorithm and its description");
        
        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          String input2 = req.queryParams("input2");
          String input3 = req.queryParams("input3");
          String input4 = req.queryParams("input4");
          int input4AsInt = Integer.parseInt(input4);
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          java.util.Scanner sc3 = new java.util.Scanner(input3);
          sc3.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          java.util.ArrayList<String> inputList3 = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
          while (sc3.hasNext())
          {
            String word = sc3.next().replaceAll("\\s","");
            inputList3.add(word);
          }
         StringBuilder result = App.build(inputList, inputList2, inputList3, input4AsInt);
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


