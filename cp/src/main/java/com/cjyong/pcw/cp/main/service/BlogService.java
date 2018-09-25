package com.cjyong.pcw.cp.main.service;

import com.cjyong.pcw.cp.conf.ApplicationInfo;
import com.cjyong.pcw.cp.main.MyJsonResult;
import com.cjyong.pcw.cp.main.dao.PaperRepository;
import com.cjyong.pcw.cp.main.entity.Paper;
import com.cjyong.pcw.cp.main.exception.ParameterInValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Class created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/9/11
 * Time: 16:43
 * Description: Blog读取次数的控制
 */
@Service
@Slf4j
public class BlogService {

    private PaperRepository paperRepository;
    private static final int PAGE_LENGTH = 6;

    @Autowired
    public BlogService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }


    /**
     * 插入新的Blog
     *
     * @param titles 标题信息
     * @return
     */
    public Paper insertNewBlog(String[] titles) {
        String names = titles[2].substring(0, titles[2].length() - 3);
        int count  = (int) paperRepository.count();
        Paper paper = new Paper(count, titles[0].toUpperCase(), titles[1].toUpperCase(), names);
        return paperRepository.saveAndFlush(paper);
    }

    /**
     * 获取相同类型的博文,进行更新
     *
     * @param type 类型ID号
     * @return
     */
    public List<Paper> getSameBlog(int type) {
        return paperRepository.findByTypeOrderByIdAsc(type);
    }

    /**
     * 根据标题获取文章
     *
     * @param title
     * @return
     */
    public Paper updatePaperTitle(String title) {
        String names = title.substring(0, title.length() - 3);
        Paper paper = paperRepository.findFirstBySmallType(names);
        //更新Paper的更新时间
        paper.setUpdateTime(System.currentTimeMillis());
        return paperRepository.saveAndFlush(paper);
    }

    /**
     * 获取首页计数
     *
     * @param page 当前页数
     * @return
     */
    public MyJsonResult incAndGetIndex(int page) throws Exception{
        int[] datas = ApplicationInfo.incAndGetByPage((page - 1) * PAGE_LENGTH, PAGE_LENGTH);
        return new MyJsonResult(datas);
    }

    /**
     * 根据类型获取数据
     *
     * @param type
     * @param page
     * @return
     * @throws Exception
     */
    public MyJsonResult incAndGetType(int type, int page) throws Exception{
        int[] datas = ApplicationInfo.incAndGetType(type, (page - 1) * PAGE_LENGTH, PAGE_LENGTH);
        return new MyJsonResult(datas);
    }

    /**
     * 根据ID获取计数
     *
     * @param id
     * @return
     * @throws ParameterInValidException
     */
    public MyJsonResult incAndGetPaper(int id) throws ParameterInValidException{
        try {
            int[] datas = ApplicationInfo.incAndGetById(id);
            return new MyJsonResult(datas);
        } catch (Exception ex) {
            if (saveCache())
                initCache();
            throw ex;
        }
    }

    /**
     * 初始化缓存
     *
     */
    public void initCache() {
        List<Paper> papers = paperRepository.findByIdAfterOrderByIdAsc(-1);
        ApplicationInfo.init(papers);
    }

    /**
     * 获取所有的blog
     *
     * @return
     */
    public List<Paper> getAllPaperByIdDesc() {
        return paperRepository.findByIdAfterOrderByIdAsc(0);
    }

    /**
     * 持久化缓存
     *
     */
    public boolean saveCache() {
        List<Paper> papers = paperRepository.findByIdAfterOrderByIdAsc(-1);
        int[] datas = ApplicationInfo.getAllData();
        for (int i = 0; i < datas.length; i++)
            papers.get(i).setViewsCount(datas[i]);
        for (Paper paper : papers)
            paperRepository.saveAndFlush(paper);
        return true;
    }

    //缓存基本的数据, 约定ID是从0递增的
/*    private static class  ApplicationInfo {
        static AtomicInteger size;
        static AtomicInteger count;
        static int[] orders;
        static AtomicInteger[] datas;
        static Map<Integer, List<Integer>> types;

        static int[] getAllData() {
            int[] result = new int[datas.length];
            for (int i = 0; i < datas.length; i++) {
                result[i] = datas[i].get();
            }
            count = new AtomicInteger();
            return result;
        }

        *//**
         * 初始化
         *
         * @param papers
         *//*
        public static void  init(List<Paper> papers) {
            size = new AtomicInteger(papers.size() - 1);
            count = new AtomicInteger();
            datas = new AtomicInteger[papers.size()];
            types = new HashMap<>();
            orders = new int[papers.size() - 1];
            for(Paper paper : papers) {
                datas[paper.getId()] = new AtomicInteger(paper.getViewsCount());
                addByType(paper.getType(), paper.getId());
            }
            papers = papers.stream().sorted().collect(Collectors.toList());
            for(int i = 0; i < orders.length; i++)
                orders[i] = papers.get(i).getId();
        }

        *//**
         * 分页获取所有的数据
         *
         * @param start
         * @param maxlength
         * @return
         * @throws ParameterInValidException
         *//*
        public static int[] incAndGetByPage (int start, int maxlength) throws ParameterInValidException{
            if (start >= datas.length) {
                throw new ParameterInValidException("页码超出限制不存在");
            }
            int length = Math.min(datas.length - start - 1, maxlength);
            int[] result = new int[length + 1];
            count.incrementAndGet();
            result[0] = datas[0].incrementAndGet();
            for (int i = start; i < (start + length); i++) {
                result[i - start + 1] = datas[orders[i]].get();
            }

            return result;
        }

        *//**
         * 根据type获取对应次数
         *
         * @param type
         * @return
         * @throws ParameterInValidException
         *//*
        public static int[] incAndGetType (int type, int start, int maxlength) throws ParameterInValidException{
            List<Integer> details = types.get(type);
            if (details.size() == 0) {
                throw new ParameterInValidException("该博文类型不存在");
            }
            int length = Math.min(details.size() - start, maxlength);
            int[] result = new int[length + 1];
            count.incrementAndGet();
            result[0] = datas[0].incrementAndGet();
            for (int i = start; i < (start + length); i++) {
                result[i - start + 1] = datas[details.get(i)].get();
            }
            return result;
        }

        *//**
         * 根据ID获取对应次数
         *
         * @param id
         * @return
         * @throws ParameterInValidException
         *//*
        public static int[] incAndGetById (int id) throws ParameterInValidException{
            if (id >= datas.length) {
                throw new ParameterInValidException("该博文ID不存在");
            }
            count.incrementAndGet();
            int[] result = new int[2];
            result[0] = datas[0].incrementAndGet();
            result[1] = datas[id].incrementAndGet();
            return result;
        }

        *//**
         * 统计类型ID
         *
         * @param key
         * @param value
         *//*
        private static void addByType(int key, int value) {
            if (types.containsKey(key)) {
                List<Integer> values = types.get(key);
                values.add(value);
            } else {
                List<Integer> values = new ArrayList<>();
                values.add(value);
                types.put(key, values);
            }
        }
    } */
}
