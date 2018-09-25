package com.cjyong.pcw.cp.main.service.schedule;

import com.cjyong.pcw.cp.main.dao.UserRepository;
import com.cjyong.pcw.cp.main.entity.User;
import com.cjyong.pcw.cp.main.entity.enums.DialySiginStatus;
import com.cjyong.pcw.cp.main.service.BlogService;
import com.cjyong.pcw.cp.main.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/30
 * Time: 16:32
 * Description: A class use to finish some schedule task like update user's info in daily.
 */
@Service
@Slf4j
public class ScheduleService {

    private UserRepository userRepository;
    private EmailService emailService;
    private BlogService blogService;

    @Autowired
    public ScheduleService(UserRepository userRepository,
                           EmailService emailService,
                           BlogService blogService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.blogService = blogService;
    }

    /**
     * Update UserInfo like dialySigin.
     */
    @Scheduled(cron = "0 0 0 * * *") //Every day's 24h carry this task.
    public void updateUserInfo() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setDialySigin(DialySiginStatus.NOTCOMPLETE);
            userRepository.saveAndFlush(user);
        }
    }

    /**
     * Notice User to finish today sentence.
     */
    @Scheduled(cron = "0 0 22 * * *") //Every day's 22h carry this task.
    public void noticeUserToFinishDailySentence() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getDialySigin() == DialySiginStatus.NOTCOMPLETE) {
                emailService.sendNoticeToFinishToDaySentence(user.getEmail());
            }
        }
    }

    /**
     * Notice User to finish today sentence.
     */
    @Scheduled(cron = "0 0 */2 * * *")
    public void carryEveryTwoHour() {
        blogService.saveCache();
    }
}
