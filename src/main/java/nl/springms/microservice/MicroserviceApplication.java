package nl.springms.microservice;

import nl.springms.microservice.model.UserEntity;
import nl.springms.microservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository repo){
		return args -> {
			repo.save(new UserEntity("Matthijs841", "Matthijs", "Bos"));
			repo.save(new UserEntity("Student123", "Student", "lastName"));
		};
	}
}
