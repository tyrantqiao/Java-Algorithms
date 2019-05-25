package com.tyrantqiao.bean;

import lombok.Data;

/**
 * @author tyrantqiao
 * date: 2019/4/27
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 *
 * bean是什么，是一个被实例化，组装，并通过Spring IoC 容器所管理的对象，代表实体类用来与数据库表或者其他进行映射
 * 变量私有化，通过get、set获取，方便向后兼容
 */
@Data
public class User {
    private String username;
    private String password;
    private String id;
}
