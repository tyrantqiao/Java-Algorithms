package com.tyrantqiao.mapper;

import com.tyrantqiao.bean.User;

/**
 * @author tyrantqiao
 * date: 2019/4/27
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 *
 * mapper是什么？其主要作用为定义SQL语句与映射关系
 */
public interface UserMapper {
    User getUserById(String id);
}
