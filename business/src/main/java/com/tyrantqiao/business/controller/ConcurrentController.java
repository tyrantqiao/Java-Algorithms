package com.tyrantqiao.business.controller;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 测试并发类$
 * <p>
 * 创建时间： 2021/3/31 7:09
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
@RestController
@RequestMapping("/thread/concurrent")
public class ConcurrentController {
    private static final Logger logger = LoggerFactory.getLogger(ConcurrentController.class);

    /**
     * 2021-03-31 07:39:21.445  INFO 17292 --- [nio-8080-exec-1] c.t.b.controller.ConcurrentController    : init size:900
     * 2021-03-31 07:39:21.448  INFO 17292 --- [ool-1-worker-19] c.t.b.controller.ConcurrentController    : we need more gold:100
     * 2021-03-31 07:39:21.448  INFO 17292 --- [Pool-1-worker-5] c.t.b.controller.ConcurrentController    : we need more gold:100
     * 2021-03-31 07:39:21.448  INFO 17292 --- [ool-1-worker-27] c.t.b.controller.ConcurrentController    : we need more gold:100
     * 2021-03-31 07:39:21.448  INFO 17292 --- [ool-1-worker-13] c.t.b.controller.ConcurrentController    : we need more gold:100
     * 2021-03-31 07:39:21.448  INFO 17292 --- [ool-1-worker-23] c.t.b.controller.ConcurrentController    : we need more gold:100
     * 2021-03-31 07:39:21.448  INFO 17292 --- [Pool-1-worker-9] c.t.b.controller.ConcurrentController    : we need more gold:100
     * 2021-03-31 07:39:21.448  INFO 17292 --- [ool-1-worker-31] c.t.b.controller.ConcurrentController    : we need more gold:100
     * 2021-03-31 07:39:21.448  INFO 17292 --- [ool-1-worker-17] c.t.b.controller.ConcurrentController    : we need more gold:100
     * 2021-03-31 07:39:21.449  INFO 17292 --- [Pool-1-worker-3] c.t.b.controller.ConcurrentController    : we need more gold:100
     * 2021-03-31 07:39:21.449  INFO 17292 --- [ool-1-worker-21] c.t.b.controller.ConcurrentController    : we need more gold:100
     * 2021-03-31 07:39:21.451  INFO 17292 --- [nio-8080-exec-1] c.t.b.controller.ConcurrentController    : 最终数量为1900
     *
     * @return 由于size未上锁，导致重复插入
     * @throws InterruptedException 抛出异常
     */
    @GetMapping(value = "wrong")
    public String wrong() throws InterruptedException {
        ConcurrentHashMap<String, Long> concurrentHashMap = getHashMapData(900);
        logger.info("init size:{}", concurrentHashMap.size());

        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
            int gap = 1000 - concurrentHashMap.size();
            logger.info("we need more gold:{}", gap);
            concurrentHashMap.putAll(getHashMapData(gap));
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        logger.info("最终数量为{}", concurrentHashMap.size());
        return "OK";
    }

    /**
     * 2021-03-31 07:50:53.522  INFO 15304 --- [nio-8080-exec-1] c.t.b.controller.ConcurrentController    : init size:900
     * 2021-03-31 07:50:53.525  INFO 15304 --- [ool-1-worker-19] c.t.b.controller.ConcurrentController    : we need more gold:100
     * 2021-03-31 07:50:53.526  INFO 15304 --- [ool-1-worker-23] c.t.b.controller.ConcurrentController    : we need more gold:0
     * 2021-03-31 07:50:53.526  INFO 15304 --- [ool-1-worker-17] c.t.b.controller.ConcurrentController    : we need more gold:0
     * 2021-03-31 07:50:53.526  INFO 15304 --- [Pool-1-worker-5] c.t.b.controller.ConcurrentController    : we need more gold:0
     * 2021-03-31 07:50:53.526  INFO 15304 --- [Pool-1-worker-3] c.t.b.controller.ConcurrentController    : we need more gold:0
     * 2021-03-31 07:50:53.526  INFO 15304 --- [ool-1-worker-31] c.t.b.controller.ConcurrentController    : we need more gold:0
     * 2021-03-31 07:50:53.526  INFO 15304 --- [ool-1-worker-13] c.t.b.controller.ConcurrentController    : we need more gold:0
     * 2021-03-31 07:50:53.526  INFO 15304 --- [ool-1-worker-27] c.t.b.controller.ConcurrentController    : we need more gold:0
     * 2021-03-31 07:50:53.526  INFO 15304 --- [ool-1-worker-19] c.t.b.controller.ConcurrentController    : we need more gold:0
     * 2021-03-31 07:50:53.526  INFO 15304 --- [Pool-1-worker-9] c.t.b.controller.ConcurrentController    : we need more gold:0
     * 2021-03-31 07:50:53.526  INFO 15304 --- [nio-8080-exec-1] c.t.b.controller.ConcurrentController    : 最终数量为1000
     * <p>
     * 上锁后size数量一致，只会putAll一次
     *
     * @return 产生数量
     * @throws InterruptedException 抛出异常
     */
    @GetMapping(value = "right")
    public String right() throws InterruptedException {
        ConcurrentHashMap<String, Long> concurrentHashMap = getHashMapData(900);
        logger.info("init size:{}", concurrentHashMap.size());

        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
            synchronized (concurrentHashMap) {
                int gap = 1000 - concurrentHashMap.size();
                logger.info("we need more gold:{}", gap);
                concurrentHashMap.putAll(getHashMapData(gap));
            }
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        logger.info("最终数量为{}", concurrentHashMap.size());
        return "OK";
    }

    private ConcurrentHashMap<String, Long> getHashMapData(int size) {
        return LongStream.rangeClosed(1, size)
                .boxed()
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(),
                        Function.identity(),
                        (o1, o2) -> o1, ConcurrentHashMap::new));
    }
}
