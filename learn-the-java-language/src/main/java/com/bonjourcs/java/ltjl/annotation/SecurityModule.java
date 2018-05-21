package com.bonjourcs.java.ltjl.annotation;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/2
 */
public class SecurityModule {

    @Security(roles = {"admin"}, timeout = 3000L)
    public void showInfo() {
        System.out.println("This is security module.");
    }

}
