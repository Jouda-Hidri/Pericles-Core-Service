package pericles.coreservice.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CandidateRepository extends CrudRepository<Candidate, Long>{

}
