package com.bonjourcs.java.ltjl.cao;

import java.util.Date;

/**
 * @author Liang Chenghao
 * Description: class father
 *  Access level for class Father (top-level) is package-private,
 *  which means that other classes in the same package can access it.
 * Date: 2018/3/29
 */
class Father {

    /**
     * field name
     */
    private String name;
    /**
     * field birth
     */
    private Date birth;

    /**
     * constructor for class Father
     *
     * @param name  declare name for a Father object
     * @param birth declare birth for a Father object
     */
    Father(String name, Date birth) {
        this.name = name;
        this.birth = birth;
    }

}
