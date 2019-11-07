package com.cmr.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cmr.datasource.dao")
public class DatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasourceApplication.class, args);
	}

}
