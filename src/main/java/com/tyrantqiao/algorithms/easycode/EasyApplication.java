package com.tyrantqiao.algorithms.easycode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author tyrantqiao
 * @date 2020/3/1
 * email: tyrantqiao@gmail.com
 */
@EnableSwagger2
@MapperScan("easycode.dao")
@SpringBootApplication()
public class EasyApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyApplication.class, args);
    }
}
