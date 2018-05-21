package com.bonjourcs.java.ltjl.cao;

import java.util.Date;

/**
 * @author Liang Chenghao
 * Description: class Son extends Father
 * Date: 2018/3/29
 */
class Son extends Father {

    /**
     * constructor for class Son
     *
     * @param name  declare name for class Son
     * @param birth declare birth for class Son
     */
    Son(String name, Date birth) {
        // because class Father doesn't provide a non-argument constructor
        // it must go this way
        super(name, birth);
    }

}
