package com.tyrantqiao.sqlsession;

import com.tyrantqiao.config.Function;
import com.tyrantqiao.config.MapperBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author tyrantqiao
 * date: 2019/4/27
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class MyMapperProxy implements InvocationHandler {
    private MysqlSession mysqlSession;
    private String mapperXML;
    private MyConfiguration myConfiguration;

    public MyMapperProxy(MyConfiguration myConfiguration, MysqlSession mysqlSession, Class clas) {
        this.myConfiguration = myConfiguration;
        this.mysqlSession = mysqlSession;
        this.mapperXML = clas.getName().substring(clas.getPackageName().length()+1)+ ".xml";
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean readMapper = myConfiguration.readMapper(mapperXML);
        //是否是xml文件对应的接口
        if (!method.getDeclaringClass().getName().equals(readMapper.getInterfaceName())) {
            System.out.println("read the file");
            return null;
        }
        List<Function> list = readMapper.getList();
        if (null != list || 0 != list.size()) {
            for (Function function : list) {
                //id是否和接口方法名一样
                if (method.getName().equals(function.getFuncName())) {
                    return mysqlSession.query(function.getSql(), String.valueOf(args[0]));
                }
            }
        }
        return null;
    }
}
