package com.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ResponseBodyBuilder {
    private String body = "";
    private String publicDir = "";
    private Hashtable bodyHashtable;
    private RequestRouter requestRouter;

    ResponseBodyBuilder(RequestRouter requestRouter, String directory){
        this.requestRouter = requestRouter;
        this.publicDir = directory;
        this.bodyHashtable = new Hashtable();
        bodyHashtable.put("/coffee", "I'm a teapot");
    }

    public String getBody(String path, String method) {
        int responseCode = this.requestRouter.getResponseCode(path, method);
        if( responseCode == 418 && path.equals("/coffee")){
            String value = (String)this.bodyHashtable.get(path);
            this.body = value;
        } else if ( responseCode == 200 && path.equals("/") ){
            String pathToDir = this.publicDir + path;
            this.body = getFiles(pathToDir);
        }
        return this.body == null ? "" : this.body;
    }

    private String getFiles(String path){
        List<String> results = new ArrayList<String>();
        File[] files = new File(path).listFiles();

        for (File file : files) {
            if (file.isFile()) {
                if(!file.getName().equals(".DS_Store")){
                    results.add(file.getName());
                }
            }
        }
        return String.join(", ", results);
    }
}
