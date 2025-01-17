package boa.fund_transfer_service_cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FundTransferServiceCicdApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundTransferServiceCicdApplication.class, args);
	}

}



@Configuration
class RestTemplateConfig {
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}