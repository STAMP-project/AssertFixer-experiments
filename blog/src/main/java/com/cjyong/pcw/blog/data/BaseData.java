package com.cjyong.pcw.blog.data;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Class created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/9/17
 * Time: 20:19
 * Description: Basedata class Store all static information
 */
public class BaseData {

    /**
     * 获取对应的类型id
     *
     * @param key 传递的类型名
     * @return
     */
    public static int getType(String key) {
        return TYPES.get(key.toUpperCase());
    }

    /**
     * 获取对应level的Event的HTML内容
     *
     * @param level 几级目录
     * @return html内容
     */
    public static String getEvent(int level) {
        Assert.assertTrue(level <= 3 && level >= 1);
        String repalce = level == 1 ? "./" : level == 2 ? "../" : "../../";
        return BASE_EVENT.replaceAll("CJYNB", repalce);
    }

    /**
     * 获取对应level的Head的HTML内容
     *
     * @param level 几级目录
     * @return html内容
     */
    public static String getHead(int level) {
        Assert.assertTrue(level <= 3 && level >= 1);
        String repalce = level == 1 ? "./" : level == 2 ? "../" : "../../";
        return BASE_INDEX.replaceAll("CJYNB", repalce);
    }

    /**
     *
     *  返回对应页数的html页脚
     *
     * @param pages  页数
     * @param currentPage 当前页
     * @param type 类型
     * @param source 页面名称
     * @return html页脚内容
     */
    public static String getENDOfHtml(int pages, int currentPage, int type, String source) {
        StringBuilder sb = new StringBuilder(
                "\t\t</ul>" +
                        "\t\t<div class=\"page\">\n" +
                        "\t\t<ul class=\"pagination\">\n");
        for (int i = 1; i <= pages; i++) {
            String str = i == 1 ? source + ".html" : source + i + ".html";
            if (i == currentPage) {
                sb.append("\t\t  <li><a class=\"active\" href=\"" + str + "\">" + i + "</a></li>");
            } else {
                sb.append("\t\t  <li><a href=\"" + str + "\">" + i + "</a></li>");
            }
        }
        sb.append("\t\t</ul>\n\t\t</div>");
        String indexs = type == 0 ? "incAndGetIndex" : "incAndGetType";
        String parameter = type == 0 ? "page=" + currentPage : "page=" + currentPage + "&type=" + type;
        return sb.toString() + String.format(BASE_END, indexs, parameter);
    }


    //Suppress default constructor
    private BaseData() {
        throw new AssertionError();
    }

    public static String BASETITLE = "CAI123NB - %s";
    public static String BASECLASSIFY= "%s - %s - %s";
    public static  String BASERPATH = "/cjyong/project/PersonalNote/%s/%s/%s.md";
    public static  String BASEWPATH = "/var/www/%s/%s/%s.html";
    public static String WTPATH = "/var/www/index";
    public static String RWPATH = "/var/www/record/record";
    public static String TWPATH = "/var/www/%s/%s/%s";
/*    public static  String BASERPATH = "D:\\learn\\PersonalNote\\%s\\%s\\%s.md";
    public static  String BASEWPATH = "D:\\learn\\fontslearn\\blog\\%s\\%s\\%s.html";
    public static String WTPATH = "D:\\learn\\fontslearn\\blog\\index";
    public static String RWPATH = "D:\\learn\\fontslearn\\blog\\record\\record";
    public static String TWPATH = "D:\\learn\\fontslearn\\blog\\%s\\%s\\%s";*/
    public static Map<String, Integer> TYPES = new HashMap(){{
        put("JAVA", 1);
        put("LINUX", 1);
        put("NOTES", 1);
        put("SQL", 1);
        put("JAVA8", 2);
        put("HEADFIRSTDP", 3);
        put("TCPIP", 4);
        put("JVM", 5);
        put("EFFECTIVEJAVA_3", 6);
        put("JDK", 7);
    }};

    public static final String HEAD_PAPER =
            "<!DOCTYPE html>\n" +
                    "<link rel=\"icon\" type=\"image/x-icon\" href=\"../../resource/img/favicon.icon\">\n" +
                    "<html>\n" +
                    "\t<head>\n" +
                    "\t\t<meta charset=\"utf-8\">\n" +
                    "\t\t<link href=\"../../resource/css/index.css\" rel=\"stylesheet\">\n" +
                    "\t\t<link href=\"../../resource/css/markdown.css\" rel=\"stylesheet\">" +
                    "\t\t<script src=\"../../resource/js/index.js\"></script>\n" +
                    "\t\t<title>%s</title>\n" +
                    "\t</head>\n" +
                    "\t<body>\n" +
                    "\t\t<div class=\"title\" >\n" +
                    "\t\t\t<div class=\"logo\">\n" +
                    "\t\t\t\t<img src =\"../../resource/img/favicon.icon\" align=\"top\">\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"info\">\n" +
                    "\t\t\t\t<br />\n" +
                    "\t\t\t\t<span class =\"names\">CJYONG</span> <br /> <br />\n" +
                    "\t\t\t\t<span class =\"sentence\">Just do what you want, what is fun!</span>\n" +
                    "\t\t\t</div>\n" +
                    "\t\t</div>\n" +
                    "\t\t<div class=\"nav\">\n" +
                    "\t\t\t<ul>\n" +
                    "\t\t\t\t<li><i class=\"icon iconfont\">&#xe6df;</i><a href=\"../../index.html\">Home</a></li>\n" +
                    "\t\t\t\t<li><i class=\"icon iconfont\">&#xe6b0;</i><a href=\"../../record/record.html\">Record</a></li>\n" +
                    "\t\t\t\t<li>\n" +
                    "\t\t\t\t\t<i class=\"icon iconfont\">&#xe601;</i>\n" +
                    "\t\t\t\t\t<a href=\"#\">Source</a>\n" +
                    "\t\t\t\t\t<ul>\n" +
                    "\t\t\t\t\t\t<li><a href=\"../../source/jdk/jdk.html\">JDK</a></li>\n" +
                    "\t\t\t\t\t</ul>\n" +
                    "\t\t\t\t</li>\n" +
                    "\t\t\t\t<li>\n" +
                    "\t\t\t\t\t<i class=\"icon iconfont\">&#xe675;</i>\n" +
                    "\t\t\t\t\t<a href=\"#\">Book</a>\n" +
                    "\t\t\t\t\t<ul>\n" +
                    "\t\t\t\t\t\t<li><a href=\"../../books/java8/java8.html\">Java8实战</a></li>\n" +
                    "\t\t\t\t\t\t<li><a href=\"../../books/headfirstdp/headfirstdp.html\">HeadFirst设计模式</a></li>\n" +
                    "\t\t\t\t\t\t<li><a href=\"../../books/jvm/jvm.html\">深入了解Java虚拟机</a></li>\n" +
                    "\t\t\t\t\t\t<li><a href=\"../../books/tcpip/tcpip.html\">图解TCP/IP</a></li>\n" +
                    "\t\t\t\t\t\t<li><a href=\"../../books/effectivejava_3/effectivejava_3.html\">EffectiveJava(v3)</a></li>\n" +
                    "\t\t\t\t\t</ul>\n" +
                    "\t\t\t\t</li>\n" +
                    "\t\t\t\t<li><i class=\"icon iconfont\">&#xe635;</i><a href=\"../../about.html\">About</a></li>\n" +
                    "\t\t\t</ul>\n" +
                    "\t\t</div>" +
                    "\t\t<div class=\"banner\">\n" +
                    "\t\t\t<p>Classify: <b>%s</b>. </p>\n" +
                    "\t\t\t<p>Publishtime: <b>%s</b>. &nbsp &nbsp Updatetime: <b>%s</b>.</p>\n" +
                    "\t\t\t<p>ViewCount: <b id=\"pviews\"></b>.</p>" +
                    "\t\t</div>\n" +
                    "<div class=\"content\">\n" +
                    "<div class=\"markdown-body\" > \n";

    public static final String EAD_PAPER =
            "</div>\n" +
                    "\t</div>\n" +
                    "\t\t<div class=\"footer\">\n" +
                    "\t\t\t<p>Powered by cjyong. &nbsp PageViews: <span id=\"allviews\"></span></p>\n" +
                    "\t\t\t<p>© 2018 赣ICP备17008911号</p>\n" +
                    "\t\t</div>\n" +
                    "\t\t<script>\n" +
                    "\t\t\tgetData(ASKURL + \"incAndGetPaper?id=%s\", function(result) {\n" +
                    "\t\t\t\tif (result.success) {\n" +
                    "\t\t\t\t\tdocument.getElementById(\"pviews\").innerText = result.data[1];\n" +
                    "\t\t\t\t\tdocument.getElementById(\"allviews\").innerText = result.data[0];\n" +
                    "\t\t\t\t}\n" +
                    "\t\t\t});\n" +
                    "\t\t</script>\n" +
                    "\t</body>\n" +
                    "</html>";
    public static final String BASE_INDEX =
            "<!DOCTYPE html>\n" +
                    "<link rel=\"icon\" type=\"image/x-icon\" href=\"CJYNBresource/img/favicon.icon\">\n" +
                    "<html>\n" +
                    "\t<head>\n" +
                    "\t\t<meta charset=\"utf-8\">\n" +
                    "\t\t<link href=\"CJYNBresource/css/index.css\" rel=\"stylesheet\">\n" +
                    "\t\t<link href=\"CJYNBresource/css/markdown.css\" rel=\"stylesheet\">\t\t\n" +
                    "\t\t<script src=\"CJYNBresource/js/index.js\"></script>\n" +
                    "\t\t<title>CAI123NB - Record</title>\n" +
                    "\t</head>\n" +
                    "\t<body>\n" +
                    "\t\t<div class=\"title\" >\n" +
                    "\t\t\t<div class=\"logo\">\n" +
                    "\t\t\t\t<img src =\"CJYNBresource/img/favicon.icon\" align=\"top\">\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"info\">\n" +
                    "\t\t\t\t<br />\n" +
                    "\t\t\t\t<span class =\"names\">CJYONG</span> <br /> <br />\n" +
                    "\t\t\t\t<span class =\"sentence\">Just do what you want, what is fun!</span>\n" +
                    "\t\t\t</div>\n" +
                    "\t\t</div>\n" +
                    "\t\t<div class=\"nav\">\n" +
                    "\t\t\t<ul>\n" +
                    "\t\t\t\t<li><i class=\"icon iconfont\">&#xe6df;</i><a href=\"CJYNBindex.html\">Home</a></li>\n" +
                    "\t\t\t\t<li><i class=\"icon iconfont\">&#xe6b0;</i><a href=\"CJYNBrecord/record.html\">Record</a></li>\n" +
                    "\t\t\t\t<li>\n" +
                    "\t\t\t\t\t<i class=\"icon iconfont\">&#xe601;</i>\n" +
                    "\t\t\t\t\t<a href=\"#\">Source</a>\n" +
                    "\t\t\t\t\t<ul>\n" +
                    "\t\t\t\t\t\t<li><a href=\"CJYNBsource/jdk/jdk.html\">JDK</a></li>\n" +
                    "\t\t\t\t\t</ul>\n" +
                    "\t\t\t\t</li>\n" +
                    "\t\t\t\t<li>\n" +
                    "\t\t\t\t\t<i class=\"icon iconfont\">&#xe675;</i>\n" +
                    "\t\t\t\t\t<a href=\"#\">Book</a>\n" +
                    "\t\t\t\t\t<ul>\n" +
                    "\t\t\t\t\t\t<li><a href=\"CJYNBbooks/java8/java8.html\">Java8实战</a></li>\n" +
                    "\t\t\t\t\t\t<li><a href=\"CJYNBbooks/headfirstdp/headfirstdp.html\">HeadFirst设计模式</a></li>\n" +
                    "\t\t\t\t\t\t<li><a href=\"CJYNBbooks/jvm/jvm.html\">深入了解Java虚拟机</a></li>\n" +
                    "\t\t\t\t\t\t<li><a href=\"CJYNBbooks/tcpip/tcpip.html\">图解TCP/IP</a></li>\n" +
                    "\t\t\t\t\t\t<li><a href=\"CJYNBbooks/effectivejava_3/effectivejava_3.html\">EffectiveJava(v3)</a></li>\n" +
                    "\t\t\t\t\t</ul>\n" +
                    "\t\t\t\t</li>\n" +
                    "\t\t\t\t<li><i class=\"icon iconfont\">&#xe635;</i><a href=\"CJYNBabout.html\">About</a></li>\n" +
                    "\t\t\t</ul>\n" +
                    "\t\t</div>\n" +
                    "\t\t<div class=\"banner\">\n" +
                    "\t\t</div>";

    public static final String BASE_END =
            "\t\t<div class=\"footer\">\n" +
                    "\t\t\t<p>Powered by cjyong. &nbsp PageViews: <span id=\"allviews\"></span></p>\n" +
                    "\t\t\t<p>© 2018 赣ICP备17008911号</p>\n" +
                    "\t\t</div>\n" +
                    "\t\t<script>\n" +
                    "\t\t\tgetData(ASKURL + \"%s?%s\", function(result) {\n" +
                    "\t\t\t\tif (result.success) {\n" +
                    "\t\t\t\t\tdocument.getElementById(\"allviews\").innerText = result.data[0];\n" +
                    "\t\t\t\t\tfor (var i = 1; i < result.data.length; i++) {\n" +
                    "\t\t\t\t\t\tdocument.getElementById(\"views\" + i).innerText = result.data[i];\n" +
                    "\t\t\t\t\t}\n" +
                    "\t\t\t\t}\n" +
                    "\t\t\t});\n" +
                    "\t\t</script>\n" +
                    "\t</body>\n" +
                    "</html>";
    public static String BASE_EVENT =
            "\t\t\t<li class=\"event\">\n" +
                    "\t\t\t  <a href=\"CJYNB%s/%s/%s.html\">" +
                    "\t\t\t  <p class=\"smalltitle\">%s</p>\n" +
                    "\t\t\t  <p class=\"detail\">分类：%s. 发表时间：%s. 阅读数：<sapn id=\"views%s\"></sapn></p>\n" +
                    "\t\t\t  </a>\n" +
                    "\t\t\t</li>";
}
