package com.bonjourcs.java.common.bean;

import java.util.List;

/**
 * @author Liang Chenghao
 * Description: pagination class
 * Date: 2018/4/9
 */
public class PageObject<T> {

    /**
     * list list
     */
    private List<T> list;
    /**
     * current page number
     */
    private int page;
    /**
     * element count for each page
     */
    private int size;
    /**
     * total items
     */
    private int totalItems;
    /**
     * total page count
     */
    private int totalPages;

    public PageObject() {
    }

    /**
     * init paging object
     *
     * @param page       parameter page
     * @param size       parameter size
     * @param totalItems parameter total items
     * @return this
     */
    public PageObject<T> init(int page, int size, int totalItems) {
        this.page = page;
        this.size = size;
        this.totalItems = totalItems;
        return this;
    }

    /**
     * set paging list
     *
     * @param list list list
     * @return this
     */
    public PageObject<T> setList(List<T> list) {
        this.list = list;
        return this;
    }

    public List<T> getList() {
        return list;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public int getTotalPages() {
        return totalItems % size == 0 ? totalItems / size : totalItems / size + 1;
    }

    @Override
    public String toString() {
        return "PageObject{" +
                "list=" + list +
                ", page=" + page +
                ", size=" + size +
                ", totalItems=" + totalItems +
                ", totalPages=" + totalPages +
                '}';
    }

}
