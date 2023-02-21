package project4;
class Program {
	  static class BST{
	    int value;
	    public BST right; 
	    public BST left; 
	    public BST(int value){
	      this.value = value;
	      this.left= null;
	      this.right = null;
	    }
	  };
	    public static void printleaf(BST tree){
	      if(tree.left == null && tree.right == null) {
	        System.out.println(tree.value);
	        return;
	      }
	      if(tree.right != null)printleaf(tree.right);
	      if(tree.left != null)printleaf(tree.left);  //interswitching 
	      
	    }
	  public static void main(String[] args) {
	    BST obj1 = new BST(9);
	    obj1.left = new BST(3);
	    obj1.left.left = new BST(2);
	    obj1.left.right = new BST(5);
	    obj1.right= new BST(22);
	    printleaf(obj1);
	  }
	}
