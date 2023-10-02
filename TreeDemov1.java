package assignmentoneCS380;

class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /**
	   pre-order binary tree traversal
	   @param root of a tree
	   */
	   public void preOrderTraversal(Node root){
			if(root == null) {
				return;
			}else {
				System.out.print(root.value + " " );
				preOrderTraversal(root.left);
				preOrderTraversal(root.right);
				
			}
	   }

	   
	   
	   /**
	   	* in-order tree traversal
	    * @param takes in the root node of a binary search tree
	    */
	   public void inOrderTraversal(Node root){

					   
			if(root == null) {
				return;
			}else {
				inOrderTraversal(root.left);
				System.out.print(root.value+ " ");
				inOrderTraversal(root.right);
			
			}

	   }
	   
	   
	   
	   /**
	    * post-order tree traversal
	    * @root Root node of a given binary search tree.
	    */
	  
	   public void postOrderTraversal(Node root){
      //implement in here
			if(root == null) {
				return;
			}else {
				
				postOrderTraversal(root.left);
				postOrderTraversal(root.right);
				System.out.print(root.value + " ");
			}
		   
	   }
	   
	   
	   
	   /**
	    * A method to find the node in the tree
	    * with a specific value
	    * @param Root The root node of a tree that can be transversed
	    * @param key a specified integer that we wish to find within the tree
	    * @return a boolean that states if the specified key exists in the tree 
	    */
	   public boolean find(Node root, int key){
		 //implement in here
		   
			if(root == null) {
				return false;
			}
			if(root.value == key) {
				return true;
			}
				
			return (find(root.left, key) || find(root.right,key));
				
		
	   }
	   
	   
	   
	   /**
	    * a method to find the node in the tree
	    * with a smallest key
	    * @param root takes in the root a given tree
	    * @return The smallest integer value of the entire tree 
	    */
	   public int getMin(Node root){
      //implement in here
			if(root == null) {
				return 0;
			}

			if( root.left == null ){
				return root.value;
			}else {
				getMin(root.left);
			}
			
			return getMin(root.left);
	   }
	  
	  
	  
	   /**
	   	* a method to find the node in the tree
	    * with a largest key
	    * @param a root node of a given tree 
	    * @return the max integer value within the tree
	    */
	   public int getMax(Node root){
     //implement in here
			if(root == null) {
				return 0;
			}
			if(root.right == null) {
				return root.value;
			}else {
				getMax(root.right);
			}   
			return getMax(root.right);
		}
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemov1{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	      
	      System.out.print("pre-order :   ");
	      t1.preOrderTraversal(t1.root);
	      System.out.println();
	      
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	      
	      System.out.print("post-order :   ");
	      t1.postOrderTraversal(t1.root);
	      System.out.println();
	  
	      System.out.println(t1.find(t1.root, 24));
	      
	      System.out.println(t1.getMin(t1.root));
	      
	      System.out.println(t1.getMax(t1.root));
	      
	   }  
	}
