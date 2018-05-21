package com.bonjourcs.java.ltjl.generics;

/**
 * @author Liang Chenghao
 * Description: generic class Pair
 * Date: 2018/4/2
 */
public class Pair<K, V> {

    /**
     * key for Pair
     */
    private K key;
    /**
     * value for Pair
     */
    private V value;

    /**
     * constructor for Pair
     *
     * @param k key
     * @param v value
     */
    public Pair(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
