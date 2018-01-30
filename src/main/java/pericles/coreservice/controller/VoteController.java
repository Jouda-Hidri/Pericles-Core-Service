package pericles.coreservice.controller;

import java.util.ArrayList;
import java.util.List;

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
	public void vote(@PathVariable("voter") long voterId, @PathVariable("candidate") long candidateId) {

		Voter voter = voterRepository.findById(voterId);
		Candidate candidate = candidateRepository.findById(candidateId);
		voter.setCandidate(candidate);
		voterRepository.save(voter);
		System.out.println(voter.getFirstName()+" voted for "+candidate+" and voters:"+candidate.getVoters().size());
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public List<String> getResult() {
		List<String> listResults = new ArrayList<String>();
		List<Candidate> candidates = candidateRepository.findAllByOrderByIdAsc();
		for(Candidate candidate : candidates) {
			listResults.add(candidate+" : "+candidate.getVoters().size());
		}
		return listResults;
	}
}
