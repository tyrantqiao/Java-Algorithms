package com.tyrantqiao.algorithms.easycode.controller;

import com.tyrantqiao.algorithms.easycode.entity.Test;
import com.tyrantqiao.algorithms.easycode.service.TestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Test)表控制层
 *
 * @author makejava
 * @since 2020-03-01 15:58:16
 */
@RestController
@RequestMapping("test")
public class TestController {
    /**
     * 服务对象
     */
    @Resource
    private TestService testService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Test selectOne(Integer id) {
        return this.testService.queryById(id);
    }

}