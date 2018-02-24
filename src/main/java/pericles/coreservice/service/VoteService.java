package pericles.coreservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pericles.coreservice.domain.Candidate;
import pericles.coreservice.domain.CandidateRepository;
import pericles.coreservice.domain.Voter;
import pericles.coreservice.domain.VoterRepository;

@Service
public class VoteService {

	@Autowired
	VoterRepository voterRepository;

	@Autowired
	CandidateRepository candidateRepository;

	public void vote(long voterId, long candidateId) {
		Voter voter = voterRepository.findById(voterId);
		Candidate candidate = candidateRepository.findById(candidateId);
		voter.setCandidate(candidate);
		voterRepository.save(voter);
	}

	public List<Candidate> getListCandidates() {
		return candidateRepository.findAllByOrderByIdAsc();
	}

}
