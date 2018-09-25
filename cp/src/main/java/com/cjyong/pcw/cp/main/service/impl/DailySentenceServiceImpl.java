package com.cjyong.pcw.cp.main.service.impl;

import com.cjyong.pcw.cp.conf.ApplicationInfo;
import com.cjyong.pcw.cp.conf.redis.FastJsonRedisSerializer;
import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.dao.*;
import com.cjyong.pcw.cp.main.entity.Comment;
import com.cjyong.pcw.cp.main.entity.DailySentence;
import com.cjyong.pcw.cp.main.entity.User;
import com.cjyong.pcw.cp.main.entity.dto.IndexInfo;
import com.cjyong.pcw.cp.main.entity.enums.DialySiginStatus;
import com.cjyong.pcw.cp.main.exception.ParameterInValidException;
import com.cjyong.pcw.cp.main.exception.PermissionInSufficientException;
import com.cjyong.pcw.cp.main.service.DailySentenceService;
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

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/28
 * Time: 17:37
 * Description: Service class which use to finish the work related to dailysentence.
 */
@Service
@Slf4j
public class DailySentenceServiceImpl implements DailySentenceService {

    private DailySentenceRepository dsRepository;
    private UserRepository userRepository;
    private CommentRepository commentRepository;
    private EmailService emailService;
    private AlbumRepository albumRepository;
    private DailyActivityRepository daRepository;

    //For redis serialize
    FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);

    @Autowired
    public DailySentenceServiceImpl(DailySentenceRepository dsRepository,
                                    UserRepository userRepository,
                                    CommentRepository commentRepository,
                                    EmailService emailService,
                                    AlbumRepository albumRepository,
                                    DailyActivityRepository daRepository) {
        this.dsRepository = dsRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.emailService = emailService;
        this.daRepository = daRepository;
        this.albumRepository = albumRepository;
    }

    @Caching(evict = {
            @CacheEvict(value = "allds", allEntries=true),
            @CacheEvict(value = "indexinfo", allEntries=true) })
    public MyJsonResult uploadDailySentence(Long userId, String content) throws Exception{
        //Make sure user can upload dailysentence(One time at one day!).
        PCUtils.checkUserId(userId, "uploadDailySentence");
        User currentUser = userRepository.findById(userId).orElse(null);
        if (currentUser.getDialySigin() == DialySiginStatus.COMPLETE) {
            log.warn("情话发表异常" + "(" + userId + ")超出次数");
            throw new PermissionInSufficientException("upDS(" + userId + ") 超出次数");
        }
        //Save this daily sentence.
        DailySentence dailySentence = new DailySentence().setUseId(userId)
                .setContent(content);
        dsRepository.save(dailySentence);
        //Change user status.
        currentUser.setDialySigin(DialySiginStatus.COMPLETE);
        userRepository.saveAndFlush(currentUser);
        ApplicationInfo.setUser(currentUser);
        //Send a notification to the other one.
        emailService.sendDailySentenceNotice(ApplicationInfo.getTheOtherEmail(userId), content);
        return new MyJsonResult();
    }

    @CacheEvict(value = "ds", key = "#sentenceId")
    public MyJsonResult addComments(Long sentenceId, Long userId, String content) throws Exception{
        //Verify user's rights and sentece's existe
        PCUtils.checkUserId(userId, "addCommentsToDS");
        DailySentence dailySentence = dsRepository.findById(sentenceId).orElse(null);
        if (dailySentence == null) {
            throw new ParameterInValidException("addCmTDS(" + sentenceId + "," + userId + ")情话不存在");
        }
        //Save and keep
        Comment comment = new Comment().setUseId(userId)
                .setContent(content);
        comment = commentRepository.saveAndFlush(comment);
        dailySentence.addComment(comment);
        DailySentence result = dsRepository.saveAndFlush(dailySentence);
        emailService.sendCommentsToOther(ApplicationInfo.getTheOtherEmail(userId));
        return new MyJsonResult(result);
    }

    @Cacheable("allds")
    public MyJsonResult getAllDS() {
        PageRequest pr = PageRequest.of(0, 50, new Sort(Sort.Direction.DESC, "id"));
        MyJsonResult myJsonResult = new MyJsonResult(dsRepository.findAllByIdGreaterThan(0L, pr));
        fastJsonRedisSerializer.serialize(myJsonResult);
        return myJsonResult;
    }

    @Cacheable("indexinfo")
    public MyJsonResult getIndexInfo() {
        PageRequest pr = PageRequest.of(0, 5, new Sort(Sort.Direction.DESC, "id"));
        IndexInfo indexInfo = new IndexInfo(dsRepository.findAllByIdGreaterThan(0L, pr),
                daRepository.findAllByIdGreaterThan(0L, pr),
                albumRepository.findAllByIdGreaterThan(0L, pr));
        MyJsonResult myJsonResult = new MyJsonResult(indexInfo);
        fastJsonRedisSerializer.serialize(myJsonResult);
        return myJsonResult;
    }

    @Cacheable(value = "ds", key = "#id")
    public MyJsonResult getOneDS(Long id) {
        MyJsonResult myJsonResult = new MyJsonResult(dsRepository.findById(id).orElse(null));
        fastJsonRedisSerializer.serialize(myJsonResult);
        return myJsonResult;
    }
}