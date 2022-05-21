import java.util.Scanner;

public class MileageTrackerLinkedList {
   public static void main (String[] args) {
      Scanner scnr = new Scanner(System.in);

      // References for MileageTrackerNode objects
      MileageTrackerNode headNode;                                           
      MileageTrackerNode currNode;
      MileageTrackerNode lastNode;

      double miles;
      String date;
      int i;

      // Front of nodes list                                                                         
      	headNode = new MileageTrackerNode();
//      lastNode = headNode;

      // TODO: Scan the number of nodes
         
         
      // TODO: For the scanned number of nodes, scan
      //       in data and insert into the linked list
      System.out.println("insert i");
      i = scnr.nextInt();
          for (int num = 1; num<i; num++){
        	  System.out.println("miles");
         miles = scnr.nextDouble();
         scnr.nextLine();
         System.out.println("data");
         date = scnr.nextLine();
         
         lastNode = new MileageTrackerNode();
         currNode = new MileageTrackerNode(miles, date, lastNode);
         if (headNode.getNext() == null) {
        	 headNode = currNode;  //creating the first headNode
        	 headNode.printNodeData();
        	// return headNode;
         }
         else {
        	// currNode = new MileageTrackerNode(miles, date); //creating the other nodes in the middle
        	// headNode.insertAfter(currNode);
        	 currNode.printNodeData();
         }
//         MileageTrackerNode toInsert = new MileageTrackerNode(miles, date);
//         toInsert.insertAfter(lastNode);
      }
          System.out.println("miles");
          miles = scnr.nextDouble();
          scnr.nextLine();
          System.out.println("date");
          date = scnr.nextLine();
          lastNode = new MileageTrackerNode(miles, date);
          lastNode.printNodeData();
          
          
//we have to insert node // write insert method 
      // TODO: Call the printNodeData() method 
      //       to print the entire linked list
    //  headNode.printNodeData();
      
      
            
   }
}