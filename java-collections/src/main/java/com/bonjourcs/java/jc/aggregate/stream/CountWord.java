package com.bonjourcs.java.jc.aggregate.stream;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description: us
 * Date: 2018/5/10
 */
public class CountWord {

    /**
     * count word in file which length is large than specific length
     *
     * @param fileName   file to read
     * @param wordLength specific length
     * @return word count
     * @throws IOException exception
     */
    public long countWord(String fileName, int wordLength) throws IOException, URISyntaxException {

        URI uri = ClassLoader.getSystemResource("").toURI();

        String content = new String(Files.readAllBytes(
                Paths.get(Paths.get(uri).toString(), fileName)
        ), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(content.split(" "));

        return words.parallelStream().filter(w -> w.length() > wordLength).count();
    }
}
