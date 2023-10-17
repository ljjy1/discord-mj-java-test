package com.github.dmj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author ljjy1
 * @classname App
 * @description TODO
 * @date 2023/10/17 14:33
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class App {
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
