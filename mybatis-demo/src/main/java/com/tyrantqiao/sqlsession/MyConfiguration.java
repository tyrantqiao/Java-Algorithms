package com.tyrantqiao.sqlsession;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tyrantqiao.config.Function;
import com.tyrantqiao.config.MapperBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author tyrantqiao
 * date: 2019/4/27
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class MyConfiguration {
    private static final ClassLoader LOADER = ClassLoader.getSystemClassLoader();
    final String EXPECT_ROOT_NAME = "datasource";
    final String DATASOURCE_PROPERTY = "property";

    public Connection build(String resource) {
        try {
            InputStream stream = LOADER.getResourceAsStream(resource);
            SAXReader reader = new SAXReader();
            Document document = reader.read(stream);
            Element root = document.getRootElement();
            return evalDatasource(root);
        } catch (Exception e) {
            throw new RuntimeException("error：" + e.toString() + " occurred while evading xml " + resource);
        }
    }

    private Connection evalDatasource(Element root) throws ClassNotFoundException {
        if (!EXPECT_ROOT_NAME.equals(root.getName())) {
            throw new RuntimeException("root should be <datasource>");
        }
        String driverClassName = null;
        String username = null;
        String password = null;
        String url = null;

        for (Object item : root.elements(DATASOURCE_PROPERTY)) {
            Element i = (Element) item;
            String value = getValue(i);
            String name = i.attributeValue("name");
            if (name == null || value == null) {
                throw new RuntimeException("[database]: <property> should contain name and value");
            }
            switch (name) {
                case "url" -> url = value;
                case "username" -> username = value;
                case "password" -> password = value;
                case "driverClassName" -> driverClassName = value;
                default -> throw new RuntimeException("[database]: <property> unknown name");
            }
        }

//        在JDBC规范中明确要求这个Driver类必须向DriverManager注册自己
        Class.forName(driverClassName);
        Connection connection = null;
        try {
            assert url != null;
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     *     获取property属性的值,如果有value值,则读取 没有设置value,则读取内容
     */
    private String getValue(Element node) {
        return node.hasContent() ? node.getText() : node.attributeValue("value");
    }


    /**
     * 读取mapper.xml文件配置
     * <p>
     * suppress压制错误
     *
     * @param path 路径
     * @return mapperBean
     */
    @SuppressWarnings("rawtypes")
    public MapperBean readMapper(String path) {
        MapperBean mapper = new MapperBean();
        try {
            InputStream stream = LOADER.getResourceAsStream(path);
            SAXReader reader = new SAXReader();
            Document document = reader.read(stream);
            Element root = document.getRootElement();
            mapper.setInterfaceName(root.attributeValue("namespace").trim());
            System.out.println(mapper.getInterfaceName());
            //把mapper节点的nameSpace值存为接口名
            List<Function> list = new ArrayList<>();
            //用来存储方法的List
            for (Iterator rootIter = root.elementIterator(); rootIter.hasNext(); ) {
                //遍历根节点下所有子节点
                Function fun = new Function();
                //用来存储一条方法的信息
                Element e = (Element) rootIter.next();
                String sqlType = e.getName().trim();
                String funcName = e.attributeValue("id").trim();
                String sql = e.getText().trim();
                String resultType = e.attributeValue("resultType").trim();
                fun.setSqlType(sqlType);
                fun.setFuncName(funcName);
                Object newInstance = null;
                try {
                    newInstance = Class.forName(resultType).getDeclaredConstructor().newInstance();
                } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e1) {
                    e1.printStackTrace();
                }
                fun.setResultType(newInstance);
                fun.setSql(sql);
                list.add(fun);
            }
            mapper.setList(list);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return mapper;
    }
}
