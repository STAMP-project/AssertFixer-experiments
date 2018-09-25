package com.cjyong.pcw.cp.conf;


import com.cjyong.pcw.cp.main.entity.Paper;
import com.cjyong.pcw.cp.main.entity.User;
import com.cjyong.pcw.cp.main.exception.ParameterInValidException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/12/5
 * Time: 15:19
 * Description: an class which store application information for the system.
 */
public class ApplicationInfo {
    private static String jwtKey;
    private static long jwtLife;
    private static String qiniuAccessKey;
    private static String qiniuSecretKey;
    private static String qinniuBucket;
    private static String photosBaseUrl;
    private static User husband;
    private static User wife;


    public static String getJwtKey() {
        return jwtKey;
    }

    public static void setJwtKey(String jwtKey) {
        ApplicationInfo.jwtKey = jwtKey;
    }

    public static long getJwtLife() {
        return jwtLife;
    }

    public static void setJwtLife(long jwtLife) {
        ApplicationInfo.jwtLife = jwtLife;
    }

    public static String getQiniuAccessKey() {
        return qiniuAccessKey;
    }

    public static void setQiniuAccessKey(String qiniuAccessKey) {
        ApplicationInfo.qiniuAccessKey = qiniuAccessKey;
    }

    public static String getQiniuSecretKey() {
        return qiniuSecretKey;
    }

    public static void setQiniuSecretKey(String qiniuSecretKey) {
        ApplicationInfo.qiniuSecretKey = qiniuSecretKey;
    }

    public static String getQinniuBucket() {
        return qinniuBucket;
    }

    public static void setQinniuBucket(String qinniuBucket) {
        ApplicationInfo.qinniuBucket = qinniuBucket;
    }

    public static String getPhotosBaseUrl() {
        return photosBaseUrl;
    }

    public static void setPhotosBaseUrl(String photosBaseUrl) {
        ApplicationInfo.photosBaseUrl = photosBaseUrl;
    }

    public static User getHusband() {
        return husband;
    }

    public static void setHusband(User husband) {
        ApplicationInfo.husband = husband;
    }

    public static User getWife() {
        return wife;
    }

    public static void setWife(User wife) {
        ApplicationInfo.wife = wife;
    }

    public static void setUser(User user) {
        if (user.getId().equals(wife.getId())) {
            wife = user;
        } else {
            husband = user;
        }
    }

    public static String getEmail(Long id) {
        if (wife.getId().equals(id)) {
            return wife.getEmail();
        }
        return husband.getEmail();
    }

    public static String getTheOtherEmail(Long id) {
        if (wife.getId().equals(id)) {
            return husband.getEmail();
        }
        return wife.getEmail();
    }

    static AtomicInteger count;
    static int[] orders;
    static AtomicInteger[] datas;
    static Map<Integer, List<Integer>> types;

    public static int[] getAllData() {
        int[] result = new int[datas.length];
        for (int i = 0; i < datas.length; i++) {
            result[i] = datas[i].get();
        }
        count = new AtomicInteger();
        return result;
    }

    /**
     * 初始化
     *
     * @param papers
     */
    public static void  init(List<Paper> papers) {
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

    /**
     * 分页获取所有的数据
     *
     * @param start
     * @param maxlength
     * @return
     * @throws ParameterInValidException
     */
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

    /**
     * 根据type获取对应次数
     *
     * @param type
     * @return
     * @throws ParameterInValidException
     */
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

    /**
     * 根据ID获取对应次数
     *
     * @param id
     * @return
     * @throws ParameterInValidException
     */
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

    /**
     * 统计类型ID
     *
     * @param key
     * @param value
     */
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
}
