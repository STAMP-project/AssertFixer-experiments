package com.cjyong.pcw.cp.main.controller;

import com.cjyong.pcw.cp.conf.ApiInfo;
import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.service.BlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Class created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/9/11
 * Time: 16:19
 * Description: Blog interface class
 */
@RestController
@RequestMapping(ApiInfo.blogApi)
@Api("博客相关API")
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @ApiOperation(value = "获取首页读取次数")
    @GetMapping(ApiInfo.getIndexCount)
    public MyJsonResult getIndexCount(@RequestParam int page) throws Exception{
        return blogService.incAndGetIndex(page);
    }

    @ApiOperation(value = "获取类型页面读取次数")
    @GetMapping(ApiInfo.getTypeCount)
    public MyJsonResult incAndGetType(@RequestParam int type, @RequestParam int page) throws Exception{
        return blogService.incAndGetType(type, page);
    }

    @ApiOperation(value = "获取文章读取次数")
    @GetMapping(ApiInfo.getPaperCount)
    public MyJsonResult incAndGetPaper(@RequestParam int id) throws Exception{
        return blogService.incAndGetPaper(id);
    }
}
