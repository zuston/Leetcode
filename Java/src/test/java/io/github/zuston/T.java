package io.github.zuston;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhang_jf on 2017/7/7.
 */
public class T {

    public static void main(String[] args) {
        int max = 1000000;
        List<String> values = new ArrayList<String>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();

        Long count = values.parallelStream().sorted().count();

        System.out.println(count);

        System.out.println(
                String.format("time : %d ms", TimeUnit.NANOSECONDS.toMillis(
                        System.nanoTime()-t0
                ))
        );

    }
}
