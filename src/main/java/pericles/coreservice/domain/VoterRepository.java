package pericles.coreservice.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VoterRepository extends CrudRepository<Voter, Long> {
	Voter findById(long id);
}
