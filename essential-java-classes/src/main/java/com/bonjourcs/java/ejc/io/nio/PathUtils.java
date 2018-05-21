package com.bonjourcs.java.ejc.io.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Liang Chenghao
 * Description: demo code of Path
 * Date: 2018/5/21
 */
public class PathUtils {

    /**
     * simple code shows creating path
     */
    public void getAPath() {
        System.out.println(FileSystems.getDefault().getPath("/users/bonjourcs"));
        System.out.println(Paths.get(System.getProperty("user.home")));
        System.out.println(Paths.get("foo"));
    }

    /**
     * retrieve information from path
     */
    public void retrieveInfoFromPath() {
        Path path = Paths.get(System.getProperty("user.home"), "path1", "path2", "path3");
        System.out.println("Original path: " + path);
        System.out.println("Get name: " + path.getFileName());
        System.out.println("Get name[0]: " + path.getName(0));
        System.out.println("Get parent: " + path.getParent());
        System.out.println("Sub-path[0,2]: " + path.subpath(0, 2));
        System.out.println("Get root: " + path.getRoot());
    }

    /**
     * normalize path
     */
    public void redundancyPath() {
        System.out.println(Paths.get("/home/bonjourcs/./.vimrc").normalize());
        System.out.println(Paths.get("/home/bonjourcs/work/../.vimrc").normalize());
    }

    /**
     * iterate path
     */
    public void iteratePath() {
        Path path = Paths.get("/home/bonjourcs/path/to/path");
        path.forEach(System.out::println);
    }

}
