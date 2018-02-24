package pericles.coreservice.domain;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "candidate_id")
	private long id;

	private String firstName;
	private String lastName;
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<Voter> voters = new LinkedHashSet<Voter>();
	
	public Candidate() {
		
	}
	
	public Candidate(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public long getId() {
		return id;
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

	public Collection<Voter> getVoters() {
		return voters;
	}

	public void setVoters(Set<Voter> voters) {
		this.voters = voters;
	}
	
	public void addVoter(Voter voter) {
		if(voters == null) {
			voters = new LinkedHashSet<Voter>();
		}
        this.voters.add(voter);
        if (voter.getCandidate() != this) {
        	voter.setCandidate(this);
        }
	}
	
	@Override
	public
	String toString() {
		return firstName +" "+lastName;
	}

}
