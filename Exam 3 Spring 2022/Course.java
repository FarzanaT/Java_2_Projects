import java.io.Serializable;

public class Course implements Comparable<Course>, Serializable {
	private static final long serialVersionUID = 4782746254484038291L;
   private Departments department;
   private Integer number;
   Semester semester;

   // Constructor
   Course(Departments dept, Integer num,  Semesters semester, Integer year) {
      department = dept;
      number = num;
      //TODO set the rest of the class members

      
   }

   // Compare courses by 
   // department first, 
   // then number
   // then year
   // then semester
   public int compareTo(Course otherCourse) {
	   // TODO
	   return -11;
   }

   // ask about semester.getSemester and getYear
   // example with ">" and "<" used to indicate the boundaries of the string
   // 		they are not printed
   //>Course [department=COMPUTER_SCIENCE, number=2334, semester=SPRING, year=2022]<
   
@Override
public String toString() {
	//TODO
	return "";
}



}
