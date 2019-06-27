package com.ln;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ln.dao") // 用于扫描daoMapper接口，否则要在各接口上加@Mapper注解
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
