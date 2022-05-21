import java.io.Serializable;

public class Person implements Employable{
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	

	
	public Person(String firstName, String lastName, String socialSecurityNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		// TODO if socialSecurityNumber is null or "", set it to "" //done
		if(socialSecurityNumber == null || socialSecurityNumber == "") {
			this.socialSecurityNumber = "";
		}
	}
	
	
	
	public String getFirstName() {
		//TODO //ok
		return this.firstName;
	}



	public String getLastName() {
		// TODO //ok
		return this.lastName;
	}



	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}



	public boolean canWork() {
		if(this.socialSecurityNumber == "") {
			return false;
		}
		// TODO person can work (return true), unless their SSN is "" //ok
		return true;
	}
	
	// If a person can work, this person can work at a university as well
	public boolean canWorkAtUniversity() { //ok
		if(canWork()) {
			return true;
		}
		
		return false;
	}

// TODO keep in mind that it needs to reflect Student ability to work at the university
// >Person [firstName=Bo, lastName=Xa, socialSecurityNumber=123-00-1234, canWork=true, canWorkAtUniversity=true]<
// >Person [firstName=Alex, lastName=Smith, socialSecurityNumber=, canWork=false, canWorkAtUniversity=false]<
// >Person [firstName=Alex, lastName=Smith, socialSecurityNumber=, canWork=false, canWorkAtUniversity=true]< 
// in the line above, when we use toString for a Student, we want to indicate that Student can work at the university
	@Override 
	public String toString() {
		String str = "";
		String canW = "";
		if(canWork() == true) {
			canW = "true";
		}
		else {
			canW = "false";
		}

			 str = "[firstName=" + this.firstName + ", lastName=" + this.lastName + ",socialSecurityNumber=" + this.socialSecurityNumber + ", canWork= " + canW + "canWorkAtUniversity=" + canW + "]<" ; 
		
		return str;
	}
	
}
