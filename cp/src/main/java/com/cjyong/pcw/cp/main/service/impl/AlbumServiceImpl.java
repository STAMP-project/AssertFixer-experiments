package com.cjyong.pcw.cp.main.service.impl;

import com.cjyong.pcw.cp.conf.redis.FastJsonRedisSerializer;
import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.dao.AlbumRepository;
import com.cjyong.pcw.cp.main.dao.CommentRepository;
import com.cjyong.pcw.cp.main.dao.UserRepository;
import com.cjyong.pcw.cp.main.entity.Album;
import com.cjyong.pcw.cp.main.entity.Comment;
import com.cjyong.pcw.cp.main.entity.Photo;
import com.cjyong.pcw.cp.main.exception.ParameterInValidException;
import com.cjyong.pcw.cp.main.service.AlbumService;
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

import java.math.BigInteger;
import java.util.EnumSet;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/12/7
 * Time: 16:35
 * Description:
 */
@Service
@Slf4j
public class AlbumServiceImpl implements AlbumService{

    private AlbumRepository albumRepository;
    private CommentRepository commentRepository;
    private EmailService emailService;
    private UserRepository userRepository;

    //For redis serialize
    FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository,
                            CommentRepository commentRepository,
                            EmailService emailService,
                            UserRepository userRepository) {
        this.albumRepository = albumRepository;
        this.commentRepository = commentRepository;
        this.emailService = emailService;
        this.userRepository = userRepository;
    }

    @Caching(evict = {
            @CacheEvict(value = "allablums", allEntries=true),
            @CacheEvict(value = "indexinfo", allEntries=true) })
    public MyJsonResult createAlbum(Long useId, String title, MultipartFile[] files) throws Exception{
        PCUtils.checkUserId(useId, "createAlbum");
        Album album = new Album()
                .setUseId(useId)
                .setTitle(title);
        for (MultipartFile file : files) {
            Photo photo = new Photo()
                    .setUrl(PCUtils.uploadImage(file));
            album.addPhoto(photo);
        }
        PCUtils.uploadFinished();
        albumRepository.save(album);
        //Send a notification
        emailService.sendAlbumCreateNotice(userRepository.findFirstByIdNot(useId).getEmail(), title);
        return new MyJsonResult();
    }

    @CacheEvict(value = "ablum", key = "#ablumId")
    public MyJsonResult addCommentsToAlbum(Long userId, Long ablumId, String conetent) throws Exception{
        PCUtils.checkUserId(userId, "addCommentsToAlbum");
        Album album = albumRepository.findById(ablumId).orElse(null);
        if (album == null) {
            throw new ParameterInValidException("AdCmTAB(" + userId + "," + ablumId + ") 相册不存在");
        }
        Comment comment = new Comment()
                .setContent(conetent)
                .setUseId(userId);
        comment = commentRepository.save(comment);
        album.addComment(comment);
        commentRepository.save(comment);
        return new MyJsonResult(album);
    }

    @Cacheable("allablums")
    public MyJsonResult getAllAblums() {
        PageRequest pr = PageRequest.of(0, 50, new Sort(Sort.Direction.DESC, "id"));
        MyJsonResult myJsonResult = new MyJsonResult(albumRepository.findAllByIdGreaterThan(0L, pr));
        fastJsonRedisSerializer.serialize(myJsonResult);
        return myJsonResult;
    }

    @Cacheable(value = "ablum", key = "#id")
    public MyJsonResult getOneAblum(Long id) {
        MyJsonResult myJsonResult = new MyJsonResult(albumRepository.findById(id).orElse(null));
        fastJsonRedisSerializer.serialize(myJsonResult);
        return myJsonResult;
    }
}
