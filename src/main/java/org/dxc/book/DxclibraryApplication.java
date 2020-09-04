package org.dxc.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages="org.dxc.book.repository")
@SpringBootApplication
public class DxclibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DxclibraryApplication.class, args);
	}

}
