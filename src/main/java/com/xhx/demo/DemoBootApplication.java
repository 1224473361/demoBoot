package com.xhx.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
/**
 * @author xhx
 * @date 2020-05-15
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class DemoBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBootApplication.class, args);
    }

}
