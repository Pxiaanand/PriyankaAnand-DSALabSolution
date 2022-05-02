package BalanceBrackets;
import java.util.*; //importing all Java.util files, rather than picking the one specific

public class Balanceclose {
	  
		
	    // function to close if brackets are balanced using Stack DS
	    static boolean Balanced(String brackets)
	    {
	        Stack<Character> stack = new Stack<Character>();
	  
	        for (int i = 0; i < brackets.length(); i++) 
	        {
	            char c = brackets.charAt(i);
	  
	            if (c == '(' || c == '[' || c == '{') 
	            {
	                stack.push(c); //pushing the identified bracket into the stack
	                continue;
	            }
	  
	            if (stack.isEmpty()) //closing if the Stack is Empty in a case where the input did not contain any open bracket
	                return false;
	            
	            char close;
	            //Switch case for the closing brackets identification, can be done using If/else also.
	            switch (c) {
	            case ')':
	                close = stack.pop();
	                if (close == '{' || close == '[')
	                    return false;
	                break;
	  
	            case '}':
	                close = stack.pop();
	                if (close == '(' || close == '[')
	                    return false;
	                break;
	  
	            case ']':
	                close = stack.pop();
	                if (close == '(' || close == '{')
	                    return false;
	                break;
	            }
	        }
	        return (stack.isEmpty());
	    }
	  
	    // Driver code
	    public static void main(String[] args)
	    {
	    	boolean flag = true;
	    	String inputBrakets = null;
	    	
	    	do
	    	{
	    		try (Scanner inp = new Scanner(System.in)) {
					System.out.println("Enter the set of brackets you want to check the Balanced Condition for:");
					inputBrakets = inp.nextLine();
				}
		    	if(inputBrakets!="")
		    		flag=false;
		    }while(flag);
	    	
	  
	        
	    	if (Balanced(inputBrakets))
	            System.out.println("\nBalanced "); //Condition to Check the give input
	        else
	            System.out.println("\nNot Balanced ");
	    }
	}
