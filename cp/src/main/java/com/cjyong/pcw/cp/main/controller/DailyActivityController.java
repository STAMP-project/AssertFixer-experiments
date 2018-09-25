package com.cjyong.pcw.cp.main.controller;

import com.cjyong.pcw.cp.conf.ApiInfo;
import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.service.DailyActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/12/1
 * Time: 13:57
 * Description: Daily interface class
 */
@RestController
@RequestMapping(ApiInfo.activityApi)
@Api("日常动态操作API")
public class DailyActivityController {

    private DailyActivityService daService;

    @Autowired
    public DailyActivityController(DailyActivityService daService) {
        this.daService = daService;
    }

    @ApiOperation(value = "发表动态")
    @PostMapping(ApiInfo.uploadActivity)
    public MyJsonResult uploadTodaySentence(@RequestParam Long useId,
                                            @RequestParam String content,
                                            @RequestParam(value = "files") MultipartFile[] files) throws Exception{
        return daService.uploadActivity(useId, content, files);
    }

    @ApiOperation(value = "对动态添加评论")
    @PostMapping(ApiInfo.addCommentsToDA)
    public MyJsonResult addCommentsToSentence(@RequestParam Long sentenceId, @RequestParam Long useId, @RequestParam String content)
            throws Exception{
        return daService.addComments(sentenceId, useId, content);
    }

    @ApiOperation(value = "获取所有的日常动态")
    @GetMapping(ApiInfo.getAllDA)
    public MyJsonResult getAllDA() throws Exception {
        return daService.getAllDA();
    }

    @ApiOperation(value = "根据ID删除对象")
    @GetMapping(ApiInfo.delOneSelf + "/{selfId}")
    public MyJsonResult delOneSelf(@PathVariable Long selfId) throws Exception {
        return daService.delOneSelf(selfId);
    }

    @ApiOperation(value = "根据ID获取对象")
    @GetMapping(ApiInfo.getOneDA + "/{selfId}")
    public MyJsonResult getOneDA(@PathVariable Long selfId) throws Exception {
        return daService.getOneDA(selfId);
    }
}
