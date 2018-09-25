package com.cjyong.pcw.cp.main.service;


import com.cjyong.pcw.cp.main.MyJsonResult;

public interface DailySentenceService {
    /**
     * publish daily love letter.
     *
     * @param userId
     * @param content
     */
    MyJsonResult uploadDailySentence(Long userId, String content) throws Exception;

    /**
     * add comments to daily sentence.
     *
     * @param sentenceId
     * @param userId
     * @param content
     */
    MyJsonResult addComments(Long sentenceId, Long userId, String content) throws Exception;

    /**
     * Get all daily sentence, default 50
     *
     * @return
     */
    MyJsonResult getAllDS();

    /**
     * Get index page info
     *
     * @return
     */
    MyJsonResult getIndexInfo();

    /**
     * Get One by id
     *
     * @param id
     * @return
     */
    MyJsonResult getOneDS(Long id);
}
