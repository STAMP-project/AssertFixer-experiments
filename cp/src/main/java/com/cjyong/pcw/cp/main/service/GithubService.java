package com.cjyong.pcw.cp.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cjyong.pcw.blog.MarkToHtmlUtil;
import com.cjyong.pcw.blog.directory.SPaper;
import com.cjyong.pcw.blog.paper.ClassifyInfo;
import com.cjyong.pcw.cp.conf.CPConfig;
import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.entity.Paper;
import com.cjyong.pcw.cp.main.exception.ParameterInValidException;
import com.sun.tools.javac.util.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/9/17
 * Time: 10:53
 * Description: Use to receive and handle git webhook infos.
 */

@Service
@Slf4j
public class GithubService {

    private CPConfig cpConfig;
    private BlogService blogService;

    @Autowired
    public GithubService(CPConfig cpConfig, BlogService blogService) {
        this.cpConfig = cpConfig;
        this.blogService = blogService;
    }

    /**
     * 处理Github发送过来的更新信息
     *
     * @param json json字符串
     * @return
     * @throws RuntimeException
     */
    public MyJsonResult updatePersonalNoteInfo(String json) throws Exception{
        //执行更新本地脚本
        execGitUpdate(cpConfig.getScriptLocation() + "pn.sh");
        //获取对应的更新和新增的数据
        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray commits = jsonObject.getJSONArray("commits");
        JSONArray added = null;
        JSONArray modified = null;
        for (int i = 0; i < commits.size(); i++) {
            JSONObject object = commits.getJSONObject(i);
            if (object.getJSONArray("added") != null) {
                added = object.getJSONArray("added");
            }
            if (object.getJSONArray("modified") != null) {
                modified = object.getJSONArray("modified");
            }
        }
        List<Paper> news = addNewBlog(added);
        modifyBlog(modified, news);
        if (blogService.saveCache())
            blogService.initCache();
        return new MyJsonResult("date success!");
    }

    /**
     * 新增Blog
     *
     * @param datas 新增列表
     */
    private List<Paper> addNewBlog(JSONArray datas) throws Exception{
        List<Paper> papers = new ArrayList();
        Set<Integer> newOne = new HashSet<>();
        for (int i = 0; i < datas.size(); i++) {
            String info = (String) datas.get(i);
            //添加Summary.md的过滤
            if (info.endsWith(".md") && (!info.endsWith("Summary.md"))) {
                String[] titles = info.split("/");
                if (titles.length != 3)
                    throw new ParameterInValidException("博文插入失败: " + info);
                Paper paper = blogService.insertNewBlog(titles);
                papers.add(paper);
                newOne.add(paper.getType());
            }
        }
        for (int type : newOne) {
            List<Paper> samePapers = blogService.getSameBlog(type);
            List<SPaper> sPapers = samePapers.stream().map(
                    x -> new SPaper(x.getId(), x.getBigType(),x.getMediumType(), x.getSmallType(),
                            Instant.ofEpochMilli(x.getCreateTime()).atOffset(ZoneOffset.of("+08:00")).toLocalDateTime(),
                            Instant.ofEpochMilli(x.getUpdateTime()).atOffset(ZoneOffset.of("+08:00")).toLocalDateTime(),
                            x.getTitle())).collect(Collectors.toList());
            MarkToHtmlUtil.printDirectoryFile(sPapers, type);
        }
        if (newOne.size() != 0) {
            List<Paper> samePapers = blogService.getAllPaperByIdDesc();
            List<SPaper> sPapers = samePapers.stream().map(
                    x -> new SPaper(x.getId(), x.getBigType(),x.getMediumType(), x.getSmallType(),
                            Instant.ofEpochMilli(x.getCreateTime()).atOffset(ZoneOffset.of("+08:00")).toLocalDateTime(),
                            Instant.ofEpochMilli(x.getUpdateTime()).atOffset(ZoneOffset.of("+08:00")).toLocalDateTime(),
                            x.getTitle())).collect(Collectors.toList());
            MarkToHtmlUtil.printDirectoryFile(sPapers, 0);
        }
        return papers;
    }

    /**
     * 更新首页
     *
     * @throws Exception
     */
    public void updateDirectory() throws Exception{
        List<Paper> samePapers = blogService.getAllPaperByIdDesc();
        List<SPaper> sPapers = samePapers.stream().map(
                x -> new SPaper(x.getId(), x.getBigType(),x.getMediumType(), x.getSmallType(),
                        Instant.ofEpochMilli(x.getCreateTime()).atOffset(ZoneOffset.of("+08:00")).toLocalDateTime(),
                        Instant.ofEpochMilli(x.getUpdateTime()).atOffset(ZoneOffset.of("+08:00")).toLocalDateTime(),
                        x.getTitle())).collect(Collectors.toList());
        MarkToHtmlUtil.printDirectoryFile(sPapers, 0);
    }

    /**
     * 更新Blog
     *
     * @param datas 修改列表
     */
    private void modifyBlog(JSONArray datas, List<Paper> news) throws Exception{
        List<Paper> papers = new ArrayList();
        if (news != null)
            papers.addAll(news);
        for (int i = 0; i < datas.size(); i++) {
            String info = (String) datas.get(i);
            if (info.endsWith(".md") && (!info.endsWith("Summary.md"))) {
                String[] titles = info.split("/");
                if (titles.length != 3)
                    throw new ParameterInValidException("博文更新异常: " + info);
                papers.add(blogService.updatePaperTitle(titles[2]));
            }
        }
        List<ClassifyInfo> infos = papers.stream()
                .map(x -> new ClassifyInfo(
                        x.getBigType(),
                        x.getMediumType(),
                        x.getSmallType(),
                        x.getId(),
                        Instant.ofEpochMilli(x.getCreateTime()).atOffset(ZoneOffset.of("+08:00")).toLocalDateTime(),
                        Instant.ofEpochMilli(x.getUpdateTime()).atOffset(ZoneOffset.of("+08:00")).toLocalDateTime()))
                .collect(Collectors.toList());
        MarkToHtmlUtil.writePapers(infos);
    }

    /**
     * Linux下执行本地SH脚本
     *
     * @param scriptPath 脚本路径
     * @throws RuntimeException 可能抛出的异常
     */
    private void execGitUpdate(String scriptPath) throws RuntimeException{
        String[] cmdA = { "/bin/sh", "-c", scriptPath};
        try {
            Process process = Runtime.getRuntime().exec(cmdA);
            try(LineNumberReader br = new LineNumberReader(new InputStreamReader(process.getInputStream()))) {
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    sb.append(line).append("\n");
                }
                log.info("sh -c " + scriptPath + " result: " + sb.toString());
            }
        } catch (Exception ex) {
            throw new RuntimeException("exec git update error");
        }
    }
}
