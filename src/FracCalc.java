import java.util.*;
public class FracCalc {

    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
    public static void main(String[] args) 
    {
    	Scanner console = new Scanner(System.in);
    	//allow the user to input equations
    	//System.out.println("enter numbers");
    	String originalInput = console.nextLine();
    	
    	//make a while loop the allows the user to quit when they type "quit"
    	while (! originalInput.equals("quit")) {
    		//call the produceAnswer method
    		produceAnswer(originalInput);
    		System.out.println("enter numbers");
    		originalInput = console.nextLine();
    		
    	}
    	
        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        // Checkpoint 2: Accept user input multiple times.
    }
    
    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
    //create produceAnswer method
    public static String produceAnswer(String input)
    { 
    	// the following are intializations of the whole, numerator and denominator for the first and second operand
    	String firstWhole= "0";
		String firstNumerator= "0";
		String firstDenominator= "0";
		
    	String secondWhole= "0";
		String secondNumerator= "0";
		String secondDenominator= "0";
			
		// use indexOf to find out where the spaces in the input are
    	int spaces = input.indexOf(" ");
    	
    	// intialize firstOperand, with the given index
    	String firstOperand = input.substring(0, spaces);
    	
    	// intialize operation,  with the given index
    	String operation = input.substring(spaces+1,spaces+2 );
    	
    	// intialize secondOperand,  with the given index
    	String secondOperand = input.substring((spaces+3), input.length());
    	//print it for checkk point 1
    	System.out.println(secondOperand);
    		
    	//use if loop to find out if there is a whole number in the first operand
    	if (firstOperand.indexOf("_")!= -1) {
    		firstWhole= firstOperand.substring(0,(firstOperand.indexOf("_")));
    		
    		if (firstOperand.indexOf("/")!= -1) {
    			firstNumerator= firstOperand.substring((firstOperand.indexOf("_")+1),(firstOperand.indexOf("/")));
    			firstDenominator= firstOperand.substring((firstOperand.indexOf("/")+1),((firstOperand.length())));
    		}else {
    			firstNumerator= "0";
    			firstDenominator= "0";
    		}		
    	}
    	else if (firstOperand.indexOf("/")!= -1) {
    		firstWhole= "0";
    		firstNumerator= firstOperand.substring(0,(firstOperand.indexOf("/")));
    		firstDenominator= firstOperand.substring((firstOperand.indexOf("/")+1),((firstOperand.length())));
    		
    	}
    	else if (firstOperand.indexOf("/")== -1 && firstOperand.indexOf("_")== -1 ) {
    		firstWhole= firstOperand.substring((0),firstOperand.length());
    		firstNumerator= "0";
    		firstDenominator= "0";
    		
    	}
    	//System.out.println("whole:" + firstWhole + " numerator:" + firstNumerator + " denominator:" + firstDenominator);
    	
    	int newFirstWhole=Integer.parseInt(firstWhole);
    	int newFirstNumerator=Integer.parseInt(firstNumerator);
    	int newFirstDenominator=Integer.parseInt(firstDenominator);
    	
    	if (secondOperand.indexOf("_")!= -1) {
    		secondWhole= secondOperand.substring(0,(secondOperand.indexOf("_")));
    		
    		if (secondOperand.indexOf("/")!= -1) {
    			secondNumerator= secondOperand.substring((secondOperand.indexOf("_")+1),(secondOperand.indexOf("/")));
    			secondDenominator= secondOperand.substring((secondOperand.indexOf("/")+1),((secondOperand.length())));
    		}else {
    			secondNumerator= "0";
    			secondDenominator= "0";
    		}		
    	}
    	else if (secondOperand.indexOf("/")!= -1) {
    		 secondWhole= "0";
    		 secondNumerator= secondOperand.substring(0,(secondOperand.indexOf("/")));
    		 secondDenominator= secondOperand.substring((secondOperand.indexOf("/")+1),((secondOperand.length())));
    		
    	}
    	else if (secondOperand.indexOf("/")== -1 && secondOperand.indexOf("_")== -1 ) {
    		 secondWhole= secondOperand.substring((0),secondOperand.length());
    		 secondNumerator= "0";
    		 secondDenominator= "0";
    		
    	}
    	System.out.println("whole:" + secondWhole + " numerator:" + secondNumerator + " denominator:" + secondDenominator);
    	
    	int newSecondWhole=Integer.parseInt(secondWhole);
    	int newSecondNumerator=Integer.parseInt(secondNumerator);
    	int newSecondDenominator=Integer.parseInt(secondDenominator);
    	
    	int newDenominator = 0; 
    	int newNumerator = 0;
    	int newWhole=0;
    	
    	if (operation.equals("+") || operation.equals("-")) {
    		
    		if (newFirstDenominator==newSecondDenominator) {
    			newDenominator = newSecondDenominator ;    		
    		
    		}else{
    		newDenominator =newFirstDenominator*newSecondDenominator ;
    		
    		}
    		
    		newFirstNumerator= (newFirstNumerator*newSecondDenominator);    		
    		newSecondNumerator = (newSecondNumerator*newFirstDenominator);    		
    		newFirstNumerator += (newFirstWhole *newDenominator);    		
			newSecondNumerator += (newSecondWhole *newDenominator);
			
    		if (operation.equals("+")) {
    			newNumerator = newFirstNumerator + newSecondNumerator;
    		}else if (operation.equals("-")) {
    			newNumerator = newFirstNumerator - newSecondNumerator;
    		}
			
		}else if (operation.equals("*")||operation.equals("/")) {
			
			newFirstNumerator= (newFirstWhole*newFirstDenominator) + newFirstNumerator;
			newSecondNumerator= (newSecondWhole*newSecondDenominator) + newSecondNumerator;	
			
			if (operation.equals("*")) {
				newNumerator = newFirstNumerator * newSecondNumerator;			
				newDenominator = newFirstDenominator * newSecondDenominator;
			}
			
			else if (operation.equals("/")) {			
				newNumerator = newFirstNumerator * newSecondDenominator;
				newDenominator = newFirstDenominator * newSecondNumerator;			
			}
		}
    	if (newNumerator>=newDenominator) {
			newWhole = newNumerator/newDenominator;
			newNumerator = newNumerator%newDenominator;
		}
    	if (newWhole != 0) {
    		System.out.print(newWhole + "_");
    		greatestCommonDivisor(newNumerator,newDenominator);
    	}
    	else if (newWhole == 0) {
    		greatestCommonDivisor(newNumerator,newDenominator);
    	
    	}
		//System.out.println(newWhole + "_" + newNumerator+ "/" + newDenominator);
        // TODO: Implement this function to produce the solution to the input
        // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
        // Checkpoint 2: Return the second operand as a string representing each part.
        //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".
        //               Note: Answer does not need to be reduced, but it must be correct.
        // Final project: All answers must be reduced.
        //               Example "4/5 * 1_2/4" returns "1_1/5".
    	
        return (" ");
        
        
    }

    // TODO: Fill in the space below with helper methods
    
    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     *      Note: There is a different (recursive) implementation in BJP Chapter 12.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int greatestCommonDivisor(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (min != 0) {
            int tmp = min;
            min = max % min;
            max = tmp;
        }
        int finalNumerator = a/max;
        int finalDenominator = b/max;
        System.out.println(finalNumerator+ "/" + finalDenominator);
        return max;
        
    }
    
    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */
    public static int leastCommonMultiple(int a, int b)
    {
        int gcd = greatestCommonDivisor(a, b);
        return (a*b)/gcd;
    }
}
