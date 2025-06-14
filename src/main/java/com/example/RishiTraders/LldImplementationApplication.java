package com.example.RishiTraders;

import com.example.RishiTraders.Config.YamlPropertySourceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;



//@PropertySource(value = "classpath:persistence.yaml", factory = YamlPropertySourceFactory.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LldImplementationApplication {


	public static void main(String[] args) {
		SpringApplication.run(LldImplementationApplication.class, args);
	}

};

