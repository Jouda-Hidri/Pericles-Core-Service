package pericles.coreservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pericles.coreservice.service.VoteService;

@RestController
public class VoteController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	VoteService voteService;

	@RequestMapping(value = "/vote/{voter}/for/{candidate}", method = RequestMethod.GET)
	public void vote(@PathVariable("voter") long voterId, @PathVariable("candidate") long candidateId) {
		voteService.vote(voterId, candidateId);
		log.info("Vote successful");
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public List<String> getResult() {
		return voteService.getListResults();
	}
}
