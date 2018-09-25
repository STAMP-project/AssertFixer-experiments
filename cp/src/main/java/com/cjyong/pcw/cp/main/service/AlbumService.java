package com.cjyong.pcw.cp.main.service;

import com.cjyong.pcw.cp.main.MyJsonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/12/7
 * Time: 16:35
 * Description:
 */
public interface AlbumService {
    /**
     * Create an ablum with photos
     *
     * @param useId
     * @param title
     * @param files
     * @return
     */
    MyJsonResult createAlbum(Long useId, String title, MultipartFile[] files) throws Exception;

    /**
     * Add commets to ablum
     *
     * @param userId
     * @param ablumId
     * @param conetent
     * @return
     */
    MyJsonResult addCommentsToAlbum(Long userId, Long ablumId, String conetent) throws Exception;

    /**
     * Get all ablum information
     *
     * @return
     */
    MyJsonResult getAllAblums();

    /**
     * Get one by id.
     *
     * @param id
     * @return
     */
    MyJsonResult getOneAblum(Long id);
}
