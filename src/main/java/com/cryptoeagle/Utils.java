package com.cryptoeagle;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.HttpURLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class Utils {

    public static String cut(String s){
        char[] raw = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0 ; i < raw.length ; i++){
            if (raw[i] == '.'){
                count++;
                continue;
            }
            if (count == 1){
                builder.append(raw[i]);
            }
        }
        return builder.toString();

    }

    public static String clearString(String s){

        String s2 = s.replaceAll("<p>","")
                .replaceAll("</a> appeared first on <a rel=\"nofollow\" href=\"https://www.ccn.com\">CCN</a></p>", "")
                .replaceAll("<div class=\"kg-card-markdown\"><p>","").replaceAll("</p></div>","")
                .replaceAll("<div class=\"kg-card-markdown\">","")
                .replaceAll("<p><img width=\"696\" height=\"696\" src=\"https://news.bitcoin.com/wp-content/uploads/2018/08/investments-768x768.jpg\" class=\"attachment-medium_large size-medium_large wp-post-image\" alt=\"The Daily: Shapeshift Acquires Bitfract, Bitmain Invests in Tribeos\" style=\"float:left; margin:0 15px 15px 0;\" srcset=\"https://news.bitcoin.com/wp-content/uploads/2018/08/investments-768x768.jpg 768w, https://news.bitcoin.com/wp-content/uploads/2018/08/investments-150x150.jpg 150w, https://news.bitcoin.com/wp-content/uploads/2018/08/investments-300x300.jpg 300w, https://news.bitcoin.com/wp-content/uploads/2018/08/investments-1024x1024.jpg 1024w, https://news.bitcoin.com/wp-content/uploads/2018/08/investments-696x696.jpg 696w, https://news.bitcoin.com/wp-content/uploads/2018/08/investments-1392x1392.jpg 1392w, https://news.bitcoin.com/wp-content/uploads/2018/08/investments-1068x1068.jpg 1068w, https://news.bitcoin.com/wp-content/uploads/2018/08/investments-420x420.jpg 420w, https://news.bitcoin.com/wp-content/uploads/2018/08/investments.jpg 1600w\" sizes=\"(max-width: 696px) 100vw, 696px\" />","")
                .replaceAll(" [&#8230;]</p> <p>The post <a rel=\"nofollow\" href=\"https://news.bitcoin.com/the-daily-shapeshift-acquires-bitfract-bitmain-invests-in-tribeos/\">The Daily: Shapeshift Acquires Bitfract, Bitmain Invests in Tribeos</a> appeared first on <a rel=\"nofollow\" href=\"https://news.bitcoin.com\">Bitcoin News</a>.</p>...","");
        return s2;
    }
}
