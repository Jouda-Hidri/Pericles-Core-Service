package pericles.coreservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {
	
	   @RequestMapping(value = "/vote/{candidate}", method = RequestMethod.GET)
	    public String vote(@PathVariable String candidate) {
	        System.out.println("Vote for " + candidate);
	        return "You voted for "+candidate;
	   }
}
