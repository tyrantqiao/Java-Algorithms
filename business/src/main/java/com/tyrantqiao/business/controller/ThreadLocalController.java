package com.tyrantqiao.business.controller;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 测试线程类$
 * <p>
 * 创建时间： 2021/3/30 7:44
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 * <p>
 * 为测试tomcat复用线程池：server.tomcat.max-threads=1，需加此项配置application.yml中添加，便于快速线程复用
 *
 * @author tyrantqiao
 * @version 1.0
 **/
@RestController()
@RequestMapping("/thread/local")
public class ThreadLocalController {
    private static final ThreadLocal<Integer> CURRENT_USER = ThreadLocal.withInitial(() -> null);

    /**
     * 由于tomcat线程复用，应注意清理ThreadLocal的内容
     *
     * @param userId 用户id
     * @return 线程信息
     */
    @GetMapping("wrong")
    public Map<String, String> wrong(@RequestParam("userId") Integer userId) {
        try {
            String before = Thread.currentThread().getName() + ":" + CURRENT_USER.get();

            CURRENT_USER.set(userId);

            String after = Thread.currentThread().getName() + ":" + CURRENT_USER.get();

            Map<String, String> result = Maps.newHashMap();
            result.put("before", before);
            result.put("after", after);
            return result;
        } finally {
            CURRENT_USER.remove();
        }
    }
}
