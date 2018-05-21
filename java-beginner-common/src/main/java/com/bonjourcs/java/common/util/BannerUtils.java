package com.bonjourcs.java.common.util;

import java.io.*;

import static com.bonjourcs.java.common.util.PropertyUtils.getProperty;

/**
 * @author Liang Chenghao
 * Description: banner utils
 * Date: 2018/4/17
 */
public class BannerUtils {

    // write to console
    private static BufferedWriter bufferedWriter
            = new BufferedWriter(new OutputStreamWriter(System.out));
    // read from disk file
    private static BufferedReader bufferedReader;

    // initialize reader
    static {
        InputStream inputStream
                = BannerUtils.class.getClassLoader().getResourceAsStream(PropertyUtils.getProperty("bannerLocation"));
        bufferedReader
                = new BufferedReader(new InputStreamReader(inputStream));
    }

    /**
     * show banner info
     *
     * @throws IOException IOException
     */
    public static void showBanner() throws IOException {

        // print version at console
        System.out.println(getVersion());
        String line;
        // print banner from banner.txt
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedWriter.close();
    }

    /**
     * get version
     *
     * @return version value
     */
    private static String getVersion() {
        return getProperty("version");
    }
}
