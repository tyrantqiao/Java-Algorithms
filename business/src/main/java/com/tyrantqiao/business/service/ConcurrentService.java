package com.tyrantqiao.business.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 并发类服务$
 * <p>
 * 创建时间： 2021/3/31 8:01
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
@Service
public class ConcurrentService {

    /**
     * TBD-O 待完成
     *
     * @return
     * @throws InterruptedException
     */
    public Map<String, Long> slowGenerate() throws InterruptedException {
        ConcurrentHashMap<String, Long> results = new ConcurrentHashMap<>(10);
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.execute(() -> {
            IntStream.rangeClosed(1, 10000000).parallel().forEach(i -> {
                String key = "item " + ThreadLocalRandom.current().nextInt(10);
                synchronized (results) {
                    if (results.containsKey(key)) {
                        results.put(key, results.get(key) + 1);
                    } else {
                        results.put(key, 1L);
                    }
                }
            });
        });
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return results;
    }

}
