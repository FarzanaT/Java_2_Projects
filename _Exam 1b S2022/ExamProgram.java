import java.util.*;
public class ExamProgram {

   public static void main(String[] args) {
      Numbers test = new Numbers();
      
      test.fillRandomly(7, 10, 1000);  // Fill nums with 10 pseudo-random nmubers using seed value 7
      System.out.println(Arrays.toString(test.getNums()));  // Prints content of array: [236, 164, 485, 44, 380, 254, 968, 649, 850, 534]
      System.out.println(test.findMax()); // findMax() should return 968
   }
}
