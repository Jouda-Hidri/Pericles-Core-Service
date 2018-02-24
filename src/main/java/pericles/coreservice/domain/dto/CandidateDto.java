package pericles.coreservice.domain.dto;

public class CandidateDto {

	private String name;
	private int total;

	public String getName() {
		return name;
	}

	public void setName(String firstName, String lastName) {
		this.name = firstName + " " + lastName;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return getName() + " : " + getTotal();
	}

}
