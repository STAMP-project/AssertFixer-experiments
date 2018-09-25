package com.cjyong.pcw.cp.main.service;

import com.cjyong.pcw.cp.conf.CPConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    private CPConfig cpConfig;
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String senderName;

    @Autowired
    public EmailService(CPConfig cpConfig, JavaMailSender sender) {
        this.cpConfig = cpConfig;
        this.sender = sender;
    }

    public void sendDailySentenceNotice(String address, String content) {
        //Makeup content.
        StringBuilder sb = new StringBuilder("亲爱的:\r\n");
        sb.append("今日情话已送达, 请注意查收哦!\r\n");
        sb.append(content + "\r\n");
        sb.append("点击这里("+ cpConfig.getDeployUrl() +")查看详情哦!");
        new SendEmailThread(address, "^今日情话^",sb.toString()).start();
    }

    public void sendNoticeToFinishToDaySentence(String address) {
        //Makeup content.
        StringBuilder sb = new StringBuilder("亲爱的:\r\n");
        sb.append("你今天还没有完成每日一句, 不要忘了. \r\n");
        sb.append("点击这里("+ cpConfig.getDeployUrl() +")进行完成.");
        new SendEmailThread(address, "^每日一句提醒^", sb.toString()).start();
    }

    public void sendAlbumCreateNotice(String address, String title) {
        //Makeup content.
        StringBuilder sb = new StringBuilder("亲爱的:\r\n");
        sb.append("你的另一半创建了一个新相册:" + title +" \r\n");
        sb.append("点击这里("+ cpConfig.getDeployUrl() +")进行查看.");
        new SendEmailThread(address, "^新建相册通知^", sb.toString()).start();
    }

    public void sendActivityNoticeToOther(String address) {
        //Makeup content.
        StringBuilder sb = new StringBuilder("亲爱的:\r\n");
        sb.append("你的另一半发表了一个新动态.\r\n");
        sb.append("点击这里("+ cpConfig.getDeployUrl() +")进行查看.");
        new SendEmailThread(address, "^新动态通知^", sb.toString()).start();
    }

    public void sendCommentsToOther(String address) {
        //Makeup content.
        StringBuilder sb = new StringBuilder("亲爱的:\r\n");
        sb.append("你的另一半在评论中提到你了哦.\r\n");
        sb.append("点击这里("+ cpConfig.getDeployUrl() +")进行查看.");
        new SendEmailThread(address, "^评论通知^", sb.toString()).start();
    }

    private class SendEmailThread extends Thread{
        private String to;
        private String subject;
        private String content;
        public SendEmailThread(String to, String subject, String content) {
            this.to = to;
            this.subject = subject;
            this.content = content;
        }
        public void run() {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(senderName);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);

            try {
                sender.send(message);
                log.info("Email Send Success!");
            } catch (Exception e) {
                log.error("Email Send Error", e);
            }
        }
    }
    //Below method is backup.
    /**
     * Send simle text email
     *
     * @param to
     * @param subject
     * @param content
     *//*
    private void sendSimpleMail(String to, String subject, String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderName);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            sender.send(message);
            log.info("Email Send Success!");
        } catch (Exception e) {
            log.error("Email Send Error", e);
        }
    }

    *//**
     * Send html former email.
     *
     * @param to
     * @param subject
     * @param content
     *//*
    private void sendHtmlMail(String to, String subject, String content){
        MimeMessage message = sender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(senderName);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            sender.send(message);
            log.info("html邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送html邮件时发生异常！", e);
        }
    }

    *//**
     * Send email with attachment.
     *
     * @param to
     * @param subject
     * @param content
     * @param filePath
     *//*
    private void sendAttachmentsMail(String to, String subject, String content, String filePath){
        MimeMessage message = sender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(senderName);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            sender.send(message);
            log.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送带附件的邮件时发生异常！", e);
        }
    }

    *//**
     * Send a email with static file.
     * @param to
     * @param subject
     * @param content 邮件内容，需要包括一个静态资源的id，比如：<img src=\"cid:rscId01\" >
     * @param rscPath 静态资源路径和文件名
     * @param rscId 静态资源id
     *//*
    private void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId){
        MimeMessage message = sender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(senderName);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            sender.send(message);
            log.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }*/
}
