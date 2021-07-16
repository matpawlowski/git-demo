package pl.mpawlowski.gitdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication()
@EnableAutoConfiguration
@ComponentScan()
public class GitdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitdemoApplication.class, args);
	}

}
