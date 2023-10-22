package myfirstapi.projetosamuel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjetoSamuelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSamuelApplication.class, args);
	}

}
