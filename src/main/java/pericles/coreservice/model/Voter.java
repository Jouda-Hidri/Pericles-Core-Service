package pericles.coreservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Voter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "voter_id")
	private long id;

	private String firstName;
	private String lastName;
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	public Voter(){
		
	}

	public Voter(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
		if (!candidate.getVoters().contains(this)) { 
			candidate.getVoters().add(this);
		}
	}
	
	
	

}
