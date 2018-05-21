package com.bonjourcs.java.ltjl.cao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/13
 */
public class SpecialObjectTest {

    @Test
    public void test() {

        SpecialObject specialObject = new SpecialObject();

        specialObject.setUser("bonjourcs");
        specialObject.setVersion("1.0");

        SpecialObject.Content content = specialObject.new Content();
        content.setLength("100");
        content.setContent("yougotmehere.");

        specialObject.setContent(content);

        String sourceJsonString = JSON.toJSONString(specialObject);
        System.out.println("原始JSON： " + JSON.toJSONString(sourceJsonString));
        String contentString = JSON.toJSONString(content);
        System.out.println("原始Content JSON： " + JSON.toJSONString(contentString));

        JSONObject sourceJsonObject = JSONObject.parseObject(sourceJsonString);
        JSONObject contentJsonObject = JSONObject.parseObject(contentString);
        contentJsonObject.put("length", "1000");
        contentJsonObject.put("content", "10001000");
        sourceJsonObject.put("content", contentJsonObject);

        System.out.println("转换后的JSON： "+ sourceJsonObject.toJSONString());
        System.out.println("转换后的Content JSON: "+ contentJsonObject.toJSONString());

    }

}