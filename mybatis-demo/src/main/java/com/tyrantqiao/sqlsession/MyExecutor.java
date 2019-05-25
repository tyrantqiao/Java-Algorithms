package com.tyrantqiao.sqlsession;

import com.tyrantqiao.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author tyrantqiao
 * date: 2019/4/27
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class MyExecutor implements Executor {
    private MyConfiguration myConfiguration = new MyConfiguration();

    @Override
    public <T> T query(String sql, Object parameter) {
        Connection connection = getConnection();
        ResultSet resultSet = null;
        PreparedStatement pre = null;
        try {
            pre = connection.prepareStatement(sql);
            //设置参数
            pre.setString(1, parameter.toString());
            resultSet = pre.executeQuery();
            User u = new User();
            //遍历结果集
            while (resultSet.next()) {
                u.setId(resultSet.getString(1));
                u.setUsername(resultSet.getString(2));
                u.setPassword(resultSet.getString(3));
            }
            return (T) u;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pre != null) {
                    pre.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private Connection getConnection() {
        try {
            return myConfiguration.build("config.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
