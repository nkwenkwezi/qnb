package qa.co.qnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class eurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(eurekaServiceApplication.class, args);
	}

}
