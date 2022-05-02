package Sum_BST;
import java.util.*;
public class PairFinder {
	 
	    static class Node {
	        int data;
	        Node left, right;
	    };
	 
	    static Node NewNode(int data)
	    {
	        Node temp = new Node();
	        temp.data = data;
	        temp.left = null;
	        temp.right = null;
	        return temp;
	    }
	 
	    static Node insert(Node root, int key)
	    {
	        if (root == null)
	            return NewNode(key);
	        if (key < root.data)
	            root.left = insert(root.left, key);
	        else
	            root.right = insert(root.right, key);
	        return root;
	    }
	 
	    static boolean findPair(Node root, int sum,
	                                HashSet<Integer> set)
	    {
	        if (root == null)
	            return false;
	 
	        if (findPair(root.left, sum, set))
	            return true;
	 
	        if (set.contains(sum - root.data)) {
	            System.out.println("Pair is found ( "+(sum - root.data)+", "+ root.data + ")");
	            return true;
	        }
	        else
	            set.add(root.data);
	 
	        return findPair(root.right, sum, set);
	    }
	 
	    static void findPair(Node root, int sum)
	    {
	        HashSet<Integer> set = new HashSet<Integer>();
	        if (!findPair(root, sum, set))
	            System.out.print("Pairs do not exit"+"\n");
	    }
	 
	    
	    public static void main(String[] args)
	    {
	        Node root = null;
	        int num,sum;
	        Scanner inp = new Scanner(System.in);
	       
	        
	        //Getting the values of Binary Search Tree from the User.
	        System.out.println("Enter the values of the Binary Search tree. Enter 0 to Stop:");
			
	        do
	    	{
				num = inp.nextInt();
				if(num!=0)
				{
					root = insert(root, num);
				}
				
		  }while(num!=0);
	        
	        try (Scanner in = new Scanner(System.in)) {
				System.out.println("Enter the sum of the Pair you want to find:");
				sum = in.nextInt();
			}
	        findPair(root, sum);
	    }
	}

