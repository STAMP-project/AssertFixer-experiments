package com.bonjourcs.java.jc.aggregate.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Liang Chenghao
 * Description: create streams
 * Date: 2018/5/10
 */
public class CreateStream {

    /**
     * generate infinite double stream
     *
     * @return a double stream
     */
    public Stream<Double> generateStream() {
        return Stream.generate(Math::random);
    }

    /**
     * show element mapping in stream
     * @param title stream title
     * @param stream stream
     * @param length element size
     * @param <T> stream type
     */
    public <T> void showStream(String title, Stream<T> stream, int length) {
        System.out.println(title);
        stream.limit(length)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}
