package com.cjyong.pcw.blog;

import com.cjyong.pcw.blog.data.BaseData;
import com.cjyong.pcw.blog.directory.SPaper;
import com.cjyong.pcw.blog.paper.ClassifyInfo;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.options.MutableDataHolder;
import com.vladsch.flexmark.util.options.MutableDataSet;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/9/17
 * Time: 19:58
 * Description:
 */
public class MarkToHtmlUtil {
    private  static MutableDataSet options = new MutableDataSet();
    private  static MutableDataHolder mutableDataHolder = options.setFrom(ParserEmulationProfile.MARKDOWN);
    static {
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
    }
    private  static Parser parser = Parser.builder(options).build();
    private  static HtmlRenderer renderer = HtmlRenderer.builder(options).build();

    //Suppress default constructor
    private MarkToHtmlUtil() {
        throw new AssertionError();
    }

    public static void writePapers(List<ClassifyInfo> infos) throws Exception {
        for (int i = 0; i < infos.size(); i++)
            writeOnePaper(infos.get(i));
    }

    public static void printDirectoryFile(List<SPaper> papers, int type) throws Exception{
        SPaper[] myPapers = null;
        String path = null;
        int level = 3;
        String source = null;
        if (type == 1) { //如果是record为二级目录
            level = 2;
            myPapers = papers.toArray(new SPaper[papers.size()]);
            source = "record";
        } else if (type == 0) {
            myPapers = papers.toArray(new SPaper[papers.size()]);
            level = 1;
            source = "index";
            reverseArray(myPapers);
        } else {
            source = papers.get(0).getMediumType().toLowerCase();
            myPapers = papers.toArray(new SPaper[papers.size()]);
        }

        int count = 1;
        int pages = myPapers.length % 6 == 0 ? myPapers.length / 6 : myPapers.length / 6 + 1;

        //构造内部的对象
        for (int i = 0; i < myPapers.length; i += 6) {
            StringBuilder sb = new StringBuilder(BaseData.getHead(level));
            sb.append("\t\t<ul class='timeline'>");
            int year = 0;
            int month = 0;
            for (int j = i; j < myPapers.length && j < (i + 6); j++) {
                SPaper paper = myPapers[j];
                if (paper.getCreateTime().getYear() != year || paper.getCreateTime().getMonth().getValue() != month) {
                    year = paper.getCreateTime().getYear();
                    month = paper.getCreateTime().getMonth().getValue();
                    String str = month < 10 ? (year + " - 0" + month) : (year + " - " + month);
                    sb.append("<li class=\"year\">" + str + "</li>");
                }
                sb.append(String.format(BaseData.getEvent(level),
                        paper.getBigType().toLowerCase(),
                        paper.getMediumType().toLowerCase(),
                        paper.getSmallType().toLowerCase(),
                        paper.getTitle(),
                        paper.getMediumType() + "-" +paper.getSmallType(),
                        paper.getStartTime(),
                        (j - i + 1) + ""
                ));
            }
            sb.append(BaseData.getENDOfHtml(pages, count, type, source.toLowerCase()));
            if (type == 0) {
                path = BaseData.WTPATH;
            } else if (type == 1){
                path = BaseData.RWPATH;
            } else {
                path = String.format(BaseData.TWPATH, myPapers[i].getBigType().toLowerCase(), source.toLowerCase(), source.toLowerCase());
            }

            if (count == 1)
                path += ".html";
            else
                path = path + count + ".html";

            try(FileOutputStream out = new FileOutputStream(path)) {
                out.write(sb.toString().getBytes());
                out.flush();
            }
            count++;
        }
    }


    public static void writeOnePaper(ClassifyInfo cfi) throws Exception{
        try(FileOutputStream out = new FileOutputStream(cfi.getWritePath())) {
            String input = readFile(cfi.getReadPath());
            String html = parseToHtml(input);
            String result = String.format(BaseData.HEAD_PAPER, cfi.getTitle(), cfi.getClassify(), cfi.getStartTime(), cfi.getUpdateTime())
                    + html +
                    String.format(BaseData.EAD_PAPER, cfi.getId());
            out.write(result.getBytes());
            out.flush();
        }
    }

    /**
     * 将MarkDown内容转换为HTML内容
     *
     * @param content MarkDown内容
     * @return HTML内容
     */
    private static String parseToHtml(String content) {
        Node document = parser.parse(content);
        return renderer.render(document);
    }

    /**
     * 读取文件工具方法
     *
     * @param path 文件的路径
     * @return 字符串表示
     * @throws Exception
     */
    private static String readFile(String path) throws Exception{
        try (InputStream stream = new FileInputStream(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "utf-8"))) {
            return reader.lines().reduce(MarkToHtmlUtil::map).get();
        }
    }

    private static String map(String str1, String str2) {
        return str1 + "\n" + str2;
    }
    /**
     * 转置数组
     *
     * @param datas
     */
    private static void  reverseArray(SPaper[] datas) {
        for (int i = 0 ; i < (datas.length / 2); i++) {
            SPaper tmp = datas[i];
            datas[i] = datas[datas.length - 1 - i];
            datas[datas.length - 1 - i] = tmp;
        }
    }
}
