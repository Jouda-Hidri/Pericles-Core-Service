package pericles.coreservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pericles.coreservice.model.Candidate;
import pericles.coreservice.model.CandidateRepository;
import pericles.coreservice.model.Voter;
import pericles.coreservice.model.VoterRepository;

@Service
public class VoteService {
	
	@Autowired
	VoterRepository voterRepository;

	@Autowired
	CandidateRepository candidateRepository;
	
	public void vote( long voterId, long candidateId) {
		Voter voter = voterRepository.findById(voterId);
		Candidate candidate = candidateRepository.findById(candidateId);
		voter.setCandidate(candidate);
		voterRepository.save(voter);
	}
	
	public List<String> getListResults(){
		List<String> listResults = new ArrayList<String>();
		List<Candidate> candidates = candidateRepository.findAllByOrderByIdAsc();
		for(Candidate candidate : candidates) {
			listResults.add(candidate+" : "+candidate.getVoters().size());
		}
		return listResults;
	}

}
