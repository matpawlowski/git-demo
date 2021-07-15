package pl.mpawlowski.gitdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()

public class GitdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitdemoApplication.class, args);
	}

}
