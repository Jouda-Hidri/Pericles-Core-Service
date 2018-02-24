package pericles.coreservice.domain.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pericles.coreservice.domain.Candidate;

@Component
public class CandidateToCandidateDtoConverter{

	@Autowired
	private ModelMapper modelMapper;

	public CandidateDto convert(Candidate candidate) {
		CandidateDto candidateDto = modelMapper.map(candidate, CandidateDto.class);
		candidateDto.setName(candidate.getFirstName(), candidate.getLastName());
		candidateDto.setTotal(candidate.getVoters().size());
		return candidateDto;
	}
}
