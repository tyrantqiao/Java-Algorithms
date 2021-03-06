package com.tyrantqiao.sqlsession;

/**
 * @author tyrantqiao
 * date: 2019/4/27
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public interface Executor {
    <T> T query(String statement, Object parameter);
}
