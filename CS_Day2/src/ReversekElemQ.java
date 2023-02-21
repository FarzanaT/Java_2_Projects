import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversekElemQ {
	 static Queue<Integer> queue;
	
	public static void main(String args[])
    {
        queue = new LinkedList<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);
 
        int k = 5;
        reverseQueueFirstKElements(k);
        Print();
    }

	static void Print()
    {
        while (!queue.isEmpty()) {
            System.out.print(queue.peek() + " ");
            queue.remove();
        }
    }
	private static void reverseQueueFirstKElements(int k) {
		// TODO Auto-generated method stub
		//edge cases
		if(queue.isEmpty() == true || queue.size() < k || k < 0) {
			return;
		}
		else {
			Stack <Integer> s1 = new Stack<Integer>(); //stack to contain the elems of queue for reversing purpose
			
//			for(int i = 0; i<queue.size(); i++) {
//				s1.push(queue.peek());
//				queue.remove(); 
//				//added the elems of queue in the stack
//				//LIFO method will store the elems in reverse order in the queue now 
//			}
////			for(int i = 0; i<s1.size(); i++){
////				queue.add(s1.peek());
////				s1.pop();
////				//added the elements in the queue in the reversed order now 
////			}
//			while(!s1.isEmpty()) {
//				queue.add(s1.peek());
//				s1.pop();
//			}
//			for(int i = 0; i< queue.size() - k; i++) { //queue.size()-k will add the rest of elements in their ascending order
//				queue.add(queue.peek());  //CONFUSION 
//				queue.remove();			//asm - 3 2 1 5 4 
//				//1 2 3 4 5 
//			}
			
			for(int i = 1; i<k; i++) {  //3 2 1 
				s1.push(queue.peek());
				queue.remove();   //q -> 4 5 
				//added the elems of queue in the stack
				//LIFO method will store the elems in reverse order in the queue now 
			}
//			for(int i = 0; i<s1.size(); i++){
//				queue.add(s1.peek());
//				s1.pop();
//				//added the elements in the queue in the reversed order now 
//			}
			while(!s1.isEmpty()) {
				queue.add(s1.peek());
				s1.pop(); // 4 5 3 2 1
			}
			for(int i = 0; i< queue.size() - k; i++) { //queue.size()-k will add the rest of elements in their ascending order
				queue.add(queue.peek());  //CONFUSION 
				queue.remove();			//asm - 3 2 1 5 4 
				//1 2 3 4 5 
			}
			
		}
		
	}
}
