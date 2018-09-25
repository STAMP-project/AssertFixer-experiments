package com.cjyong.pcw.cp.main.service.impl;

import com.cjyong.pcw.cp.conf.ApplicationInfo;
import com.cjyong.pcw.cp.conf.redis.FastJsonRedisSerializer;
import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.dao.CommentRepository;
import com.cjyong.pcw.cp.main.dao.DailyActivityRepository;
import com.cjyong.pcw.cp.main.dao.PhotoRepository;
import com.cjyong.pcw.cp.main.entity.Comment;
import com.cjyong.pcw.cp.main.entity.DailyActivity;
import com.cjyong.pcw.cp.main.entity.Photo;
import com.cjyong.pcw.cp.main.exception.ParameterInValidException;
import com.cjyong.pcw.cp.main.service.DailyActivityService;
import com.cjyong.pcw.cp.main.service.EmailService;
import com.cjyong.pcw.cp.util.PCUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/28
 * Time: 17:36
 * Description:
 */
@Service
@Slf4j
public class DailyActivityServiceImpl implements DailyActivityService {

    private DailyActivityRepository daRepository;
    private CommentRepository cRepository;
    private EmailService emailService;
    private PhotoRepository photoRepository;

    //For redis serialize
    FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);

    @Autowired
    public DailyActivityServiceImpl(DailyActivityRepository daRepository,
                                    CommentRepository cRepository,
                                    EmailService emailService,
                                    PhotoRepository photoRepository) {
        this.daRepository = daRepository;
        this.cRepository = cRepository;
        this.emailService = emailService;
        this.photoRepository = photoRepository;
    }

    @Caching(evict = {
            @CacheEvict(value = "allda", allEntries=true),
            @CacheEvict(value = "indexinfo", allEntries=true) })
    public MyJsonResult uploadActivity(Long userId, String content, MultipartFile[] files) throws Exception{
        PCUtils.checkUserId(userId, "uploadActivity");
        DailyActivity dailyActivity  = new DailyActivity();
        dailyActivity.setUseId(userId);
        dailyActivity.setContent(content);
        Set<Photo> photos = new HashSet<>();
        //Store photos
        for (MultipartFile file : files) {
            Photo photo = new Photo()
            .setUrl(PCUtils.uploadImage(file));
            photos.add(photoRepository.saveAndFlush(photo));
        }
        PCUtils.uploadFinished();
        dailyActivity.setPhotos(photos);
        daRepository.save(dailyActivity);
        emailService.sendActivityNoticeToOther(ApplicationInfo.getTheOtherEmail(userId));
        return new MyJsonResult();
    }

    @CacheEvict(value = "da", key = "#sentenceId")
    public MyJsonResult addComments(Long sentenceId, Long userId, String content) throws Exception{
        PCUtils.checkUserId(userId, "addCommentsToDA");
        DailyActivity dailyActivity = daRepository.findById(sentenceId).orElse(null);
        if (dailyActivity == null) {
            throw new ParameterInValidException("addCmTDA(" + sentenceId + "," + userId + ") 活动不存在");
        }
        //Save and keep
        Comment comment = new Comment().setUseId(userId)
                .setContent(content);
        comment = cRepository.saveAndFlush(comment);
        dailyActivity.addComment(comment);
        dailyActivity = daRepository.saveAndFlush(dailyActivity);
        emailService.sendCommentsToOther(ApplicationInfo.getTheOtherEmail(userId));
        return new MyJsonResult(dailyActivity);
    }

    @Cacheable("allda")
    public MyJsonResult getAllDA() {
        PageRequest pr = PageRequest.of(0, 50, new Sort(Sort.Direction.DESC, "id"));
        MyJsonResult myJsonResult = new MyJsonResult(daRepository.findAllByIdGreaterThan(0L, pr));
        fastJsonRedisSerializer.serialize(myJsonResult);
        return myJsonResult;
    }

    @Cacheable(value = "da", key = "#id")
    public MyJsonResult getOneDA(Long id) {
        MyJsonResult myJsonResult = new MyJsonResult(daRepository.findById(id).orElse(null));
        fastJsonRedisSerializer.serialize(myJsonResult);
        return myJsonResult;
    }

    @CacheEvict(value="da", key= "#id")
    public MyJsonResult delOneSelf(Long id) {
        daRepository.deleteById(id);
        return new MyJsonResult();
    }
}
