package com.my.SpringSecutity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecutityApplication {
//<version>3.0.5</version>
	public static void main(String[] args) {
		SpringApplication.run(SpringSecutityApplication.class, args);
	}

}
/*
spring.datasource.url=jdbc:mysql://localhost:3306/db_name?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

 */
