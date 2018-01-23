package pericles.coreservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pericles.coreservice.model.Candidate;
import pericles.coreservice.model.CandidateRepository;
import pericles.coreservice.model.Voter;
import pericles.coreservice.model.VoterRepository;

@RestController
public class VoteController {
	@Autowired
	VoterRepository voterRepository;

	@Autowired
	CandidateRepository candidateRepository;

	@RequestMapping(value = "/vote/{voter}/for/{candidate}", method = RequestMethod.GET)
	public String vote(@PathVariable("voter") long voterId, @PathVariable("candidate") long candidateId) {
		
		Voter voter = voterRepository.findById(voterId);
		Candidate candidate = candidateRepository.findById(candidateId);
		voter.setCandidate(candidate);
		voterRepository.save(voter);
		
		return voter.getFirstName() + " " + voter.getLastName() + " voted for " + candidate.getFirstName() + " "
				+ candidate.getLastName();
	}
}
