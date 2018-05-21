package com.bonjourcs.java.jc.aggregate;

import java.util.function.IntConsumer;

/**
 * @author Liang Chenghao
 * Description: help class for collect operation
 * Date: 2018/5/8
 */
public class Averager implements IntConsumer {

    /**
     * total value
     */
    private int total = 0;
    /**
     * total items
     */
    private int count = 0;

    public double average() {
        return count > 0 ? (double) total / count : 0;
    }

    @Override
    public void accept(int value) {
        total += value;
        count++;
    }

    public void combine(Averager other) {
        total += other.total;
        count += other.count;
    }
}
