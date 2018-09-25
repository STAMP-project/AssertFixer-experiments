package com.cjyong.pcw.cp.main.service;

import com.cjyong.pcw.cp.main.MyJsonResult;
import org.springframework.web.multipart.MultipartFile;

public interface DailyActivityService{
    /**
     * Upload activity to system.
     *
     * @param userId
     * @param content
     * @param files
     * @return
     */
    MyJsonResult uploadActivity(Long userId, String content, MultipartFile[] files) throws Exception;

    /**
     * Add comments to activity
     *
     * @param sentenceId
     * @param userId
     * @param content
     * @return
     */
    MyJsonResult addComments(Long sentenceId, Long userId, String content) throws Exception;

    /**
     * Get ALL DA, default 50
     *
     * @return
     */
    MyJsonResult getAllDA();

    /**
     * Get One by id
     *
     * @param id
     * @return
     */
    MyJsonResult getOneDA(Long id);

    /**
     * Del One self by id
     *
     * @param id
     * @return
     */
    MyJsonResult delOneSelf(Long id);
}
