package com.cryptoeagle.entity;

import java.util.Random;

public interface EntityWithPic {

    default
    public int getRandomPic(int maxnumber){
        return new Random().nextInt(maxnumber);
    }
}
