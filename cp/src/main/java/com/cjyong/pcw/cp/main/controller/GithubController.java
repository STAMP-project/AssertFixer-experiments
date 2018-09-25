package com.cjyong.pcw.cp.main.controller;

import com.cjyong.pcw.cp.conf.ApiInfo;
import com.cjyong.pcw.cp.conf.CPConfig;
import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.service.GithubService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URLDecoder;
import java.util.Map;


/**
 * Class created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/9/17
 * Time: 10:27
 * Description: Use to accept github hooks information.
 */
@RestController
@RequestMapping(ApiInfo.gitApi)
@Api("Github相关API")
@Slf4j
public class GithubController {

    private GithubService githubService;


    @Autowired
    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @ApiOperation(value = "接收PersonalNote的Webhook信息")
    @PostMapping(ApiInfo.updatePersonalNote)
    public MyJsonResult updatePersonalNoteInfo(HttpServletRequest request) throws Exception{
        //简单校验是否来自Github的请求(后续进行HMAC-SHA1)校验
        String type = request.getHeader("X-GitHub-Event");
        String delivery = request.getHeader("X-GitHub-Delivery");
        String signature = request.getHeader("X-Hub-Signature");
        if (type == null || !type.equalsIgnoreCase("push") || signature == null || delivery == null) {
            return new MyJsonResult("Received success!");
        }
        //读取内部的信息
        StringBuilder sb = new StringBuilder("");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            String oneLine = null;
            while((oneLine = br.readLine()) != null) {
                sb.append(oneLine);
            }
        }
        return githubService.updatePersonalNoteInfo(sb.toString());
    }
}
