package pericles.coreservice;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

import pericles.coreservice.domain.Candidate;
import pericles.coreservice.domain.CandidateRepository;
import pericles.coreservice.domain.Voter;
import pericles.coreservice.domain.VoterRepository;

@EnableBinding(Sink.class)
@EnableEurekaClient
@SpringBootApplication
public class CoreServiceApplication {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

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

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@StreamListener(target = Sink.INPUT)
	public void processUsers(String user) {
		log.info("User received : " + user);
	}
}