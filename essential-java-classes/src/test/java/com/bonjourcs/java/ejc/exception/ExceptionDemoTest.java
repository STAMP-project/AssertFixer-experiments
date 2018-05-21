package com.bonjourcs.java.ejc.exception;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/4
 */
public class ExceptionDemoTest {

    @Test
    public void testWriteList() {
        ExceptionDemo exceptionDemo = new ExceptionDemo();
        try {
            exceptionDemo.writeList();
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在且创建失败!");
        }
    }

}