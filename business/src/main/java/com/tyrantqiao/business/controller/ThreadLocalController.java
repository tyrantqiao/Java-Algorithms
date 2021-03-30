package com.tyrantqiao.business.controller;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 测试线程类$
 * <p>
 * 创建时间： 2021/3/30 7:44
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 * <p>
 * 为测试tomcat复用线程池：server.tomcat.max-threads=1，需加此项配置，便于快速线程复用
 *
 * @author tyrantqiao
 * @version 1.0
 **/
@RestController("/thread/local")
public class ThreadLocalController {
    private static final ThreadLocal<Integer> CURRENT_USER = ThreadLocal.withInitial(() -> null);

    @GetMapping("wrong")
    public Map<String, String> wrong(@RequestParam("userId") Integer userId) {
        String before = Thread.currentThread().getName() + ":" + CURRENT_USER.get();

        CURRENT_USER.set(userId);

        String after = Thread.currentThread().getName() + ":" + CURRENT_USER.get();

        Map<String, String> result = Maps.newHashMap();
        result.put("before", before);
        result.put("after", after);
        return result;
    }
}
