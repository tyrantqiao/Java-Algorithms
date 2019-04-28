package com.tyrantqiao.config;

import lombok.Data;

import java.util.List;

/**
 * @author tyrantqiao
 * date: 2019/4/27
 * blog: tyrantqiao.com
 * contact: tyrantqiao@icloud.com
 */
@Data
public class MapperBean {
    private String interfaceName;
    //接口名

    /**
     * 接口sql函数列表
     */
    private List<Function> list;
}
