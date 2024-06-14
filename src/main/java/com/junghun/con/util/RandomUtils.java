package com.junghun.con.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class RandomUtils {

    private static final Random random = new Random();

    public static int getRandomIndex(int length){
        return random.nextInt(length);
    }
}
