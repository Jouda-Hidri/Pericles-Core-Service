package pericles.coreservice;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import pericles.coreservice.model.Candidate;
import pericles.coreservice.model.CandidateRepository;
import pericles.coreservice.model.Voter;
import pericles.coreservice.model.VoterRepository;

@EnableEurekaClient
@SpringBootApplication
public class CoreServiceApplication {
	
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private VoterRepository voterRepository;

	public static void main(String[] args) {
		SpringApplication.run(CoreServiceApplication.class, args);
	}
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
			candidateRepository.save(new Candidate("Han", "Solo"));
	    		candidateRepository.save(new Candidate("Darth", "Vader"));
	    		voterRepository.save(new Voter("user", "user"));
	      };
	   }

}