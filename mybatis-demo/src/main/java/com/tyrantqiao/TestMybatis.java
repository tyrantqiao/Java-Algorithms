package com.tyrantqiao;

import com.tyrantqiao.bean.User;
import com.tyrantqiao.mapper.UserMapper;
import com.tyrantqiao.sqlsession.MysqlSession;

/**
 * @author tyrantqiao
 * date: 2019/4/27
 * blog: tyrantqiao.com
 * contact: tyrantqiao@icloud.com
 */
public class TestMybatis {
    public static void main(String[] args) {
        MysqlSession sqlSession=new MysqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById("2");
        System.out.println(user);
    }
}
