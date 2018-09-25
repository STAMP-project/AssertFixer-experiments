package com.cjyong.pcw.cp.main.controller;

import com.cjyong.pcw.cp.conf.ApiInfo;
import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.service.DailySentenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/29
 * Time: 15:00
 * Description: LoveLetter interface class
 */
@RestController
@RequestMapping(ApiInfo.dailySentenceApi)
@Api("每日一句API")
public class DailySentenceController {

    private DailySentenceService dailySentenceService;

    @Autowired
    public DailySentenceController(DailySentenceService dailySentenceService) {
        this.dailySentenceService = dailySentenceService;
    }

    @ApiOperation(value = "发表今日情话")
    @PostMapping(ApiInfo.uploadDailySentence)
    public MyJsonResult uploadTodaySentence(@RequestParam Long useId, @RequestParam String content) throws Exception{
        return dailySentenceService.uploadDailySentence(useId, content);
    }

    @ApiOperation(value = "对情话添加评论")
    @PostMapping(ApiInfo.addCommentsToDS)
    public MyJsonResult addCommentsToSentence(@RequestParam Long sentenceId, @RequestParam Long useId, @RequestParam String content)
            throws Exception{
        return dailySentenceService.addComments(sentenceId, useId, content);
    }

    @ApiOperation(value = "获取所有的情话")
    @GetMapping(ApiInfo.getAllDS)
    public MyJsonResult getAllDS() {
        return dailySentenceService.getAllDS();
    }

    @ApiOperation(value = "获取首页活动信息")
    @GetMapping(ApiInfo.indexApi)
    public MyJsonResult getIndexInfo() {
        return dailySentenceService.getIndexInfo();
    }

    @ApiOperation(value = "根据ID获取一个对象")
    @GetMapping(ApiInfo.getOneDS + "/{selfId}")
    public MyJsonResult getOneDS(@PathVariable Long selfId) {
        return dailySentenceService.getOneDS(selfId);
    }
}
