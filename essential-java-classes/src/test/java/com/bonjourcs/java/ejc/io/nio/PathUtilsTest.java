package com.bonjourcs.java.ejc.io.nio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/21
 */
public class PathUtilsTest {

    private PathUtils pathUtils;

    @Before
    public void init() {
        this.pathUtils = new PathUtils();
    }

    @Test
    public void testGetAPath() {
        pathUtils.getAPath();
    }
    
    @Test
    public void testRetrieveInfoFromPath(){
        pathUtils.retrieveInfoFromPath();
    }

    @Test
    public void testRedundancyPath(){
        pathUtils.redundancyPath();
    }

    @Test
    public void testIteratePath(){
        pathUtils.iteratePath();
    }

}