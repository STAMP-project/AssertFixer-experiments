package com.cjyong.pcw.cp.main.controller;

import com.cjyong.pcw.cp.conf.ApiInfo;
import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.service.AlbumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/12/7
 * Time: 16:36
 * Description:
 */
@RestController
@RequestMapping(ApiInfo.ablumApi)
@Api("相册操作API")
public class AlbumController {

    private AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @ApiOperation(value = "创建相册")
    @PostMapping(ApiInfo.createAblum)
    public MyJsonResult createAblumWithPhotos(@RequestParam Long useId,
                                            @RequestParam String title,
                                            @RequestParam(value = "files") MultipartFile[] files)
            throws Exception{
        return albumService.createAlbum(useId, title, files);
    }

    @ApiOperation(value = "添加评论")
    @PostMapping(ApiInfo.addCommentsToAB)
    public MyJsonResult addCommentsToAB(@RequestParam Long userId,
                                              @RequestParam Long ablumId,
                                              @RequestParam String content)
            throws Exception{
        return albumService.addCommentsToAlbum(userId, ablumId, content);
    }

    @ApiOperation(value = "获取相册")
    @GetMapping(ApiInfo.getAllAblums)
    public MyJsonResult getAllAblums() {
        return albumService.getAllAblums();
    }

    @ApiOperation(value = "根据ID获取单个相册")
    @GetMapping(ApiInfo.getOneAblum + "/{selfId}")
    public MyJsonResult getOneAblum(@PathVariable Long selfId) {
        return albumService.getOneAblum(selfId);
    }
}
