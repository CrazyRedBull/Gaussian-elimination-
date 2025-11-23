import java.util.InputMismatchException;
import java.util.Scanner;



public class InputHandler 
{
	protected int numOfEquations; 
	protected int numOfVariables; 
	protected double[][] augmentedMatrix; 
	private Scanner scanner; 



	public InputHandler()
	{
		this.scanner = new Scanner(System.in);
	}
	





	
	public double[][] MatrixConstructor() 
	{
	    boolean validNumEq = false;
	    boolean validVariable = false;

	    while (!validNumEq) 
	        { // Just loop until valid input, so if invalid then it repeats
		        try
		        {
		            System.out.println("Type the number of Equations");
		            numOfEquations = scanner.nextInt();
	
		            if (numOfEquations < 2) 
		            {
		                System.out.println("Gauss Jordan elimination requires 2 equations. Please re-enter");
		            } 
		            else 
		            {
		                validNumEq = true;
		            }
		        }
		        catch (InputMismatchException e) 
		        {
		            System.out.println("Invalid input. Please re-enter");
		            scanner.next();
		        }
	        }

	    while (!validVariable) 
	    { 
	        try 
	        {
	            System.out.println("Type the number of variables");
	            numOfVariables = scanner.nextInt();

	            if (numOfVariables < 2) {
	                System.out.println("Gauss Jordan elimination cannot be performed");
	            } 
	            else
	            {
	                validNumEq = true;
	                validVariable = true;
	            }
	            
	        }
	        catch (InputMismatchException e) 
	        {
	            System.out.println("Invalid input. Please re-enter");
	            scanner.next();
	        }
	    }

	    this.augmentedMatrix = new double[numOfEquations][numOfVariables+1];

	    // Loop to fill the matrix
	    for (int n = 0; n < numOfEquations; n++)
	    {
	        for (int i = 0; i < numOfVariables+1; i++)
	        {
	            boolean validInput = false;
	            while (!validInput) 
	            {
	                int row = n + 1;
	                try 
	                {
	                	if(i<numOfVariables)
	                	{
		                    System.out.println("Type the value for the equation " + row + "  for variable " + (i + 1));
		                    augmentedMatrix[n][i] = scanner.nextDouble();
		                    validInput = true;
		                    row++;
	                	}
	                	else if(i==numOfVariables)
	                	{
	                		System.out.println("Type the value for the constant in equation " + row);
	                		augmentedMatrix[n][i] = scanner.nextDouble();
		                    validInput = true;
		                    row++;
	                	}
	                } 
	                catch (InputMismatchException e) { // Used to check for input error and check if input is an integer
	                    String input = scanner.next();
	                    if (isInteger(input)) { // Accepts any input integer
	                        augmentedMatrix[n][i] = Integer.parseInt(input);
	                        validInput = true;
	                        row++;
	                    }
	                    else 
	                    {
	                        System.out.print("Wrong input, please re-type ");
	                    }
	                }
	            }
	        }
	    }

	    return augmentedMatrix;
	}
	

	
	public static boolean isInteger(String input)
	{
		try 
		{
			Integer.parseInt(input);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		
	}
	
	

	
	 
}
