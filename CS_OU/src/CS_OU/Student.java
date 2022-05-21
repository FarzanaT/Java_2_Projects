package CS_OU;

public class Student {
	String firstName;
	String lastName;

	double GPA;
	String major;

	public Student(String name, String lastName, double gpa2, String major2) {
		// TODO Auto-generated constructor stub
		setFirstName(name);
		this.lastName = lastName;
		setGPA(gpa2);
		setMajor(major2);
		// lastName = lastName2;

	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null) {
			this.firstName = "";
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		if(gPA < 0) {
			GPA = 0.0;
		}
		GPA = gPA;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", GPA=" + GPA + ", major=" + major + "]";
	}

//	public String firstName() {
//		
//		return firstName;
//	}
//	
//	public void firstName(String fnu) {
//		firstName = fnu;
//	}

}
