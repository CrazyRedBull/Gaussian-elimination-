import java.util.Scanner;

public class GuassJordan {

	public static void main(String[] args) 
	{
		  InputHandler inputHandler = new InputHandler();
	        double[][] augmentedMatrix = inputHandler.MatrixConstructor();

	        Guassian gaussian = new Guassian(augmentedMatrix);

	        gaussian.RREF(augmentedMatrix);
	        
	        gaussian.readSolution(gaussian.RREF(augmentedMatrix));

	        
	        Scanner ask = new Scanner(System.in);
	        System.out.println();
		System.out.println("+---------------------------------------+");
		System.out.println("|  Click and enter [1] to display RREF  |");
		System.out.println("+---------------------------------------+");;
	        int askCondition = ask.nextInt();
	        if(askCondition == 1)
	        {
	        	System.out.println("The matrix in RREF form:");
	 	        gaussian.displayMatrix(augmentedMatrix);
	        }
	        

	       

	}
	
	 
	
	
	
		
	}


