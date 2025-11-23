

class Guassian extends Matrix
{
	private double[][] augmentedMatrix;

	public Guassian(double[][] augmentedMatrix)
	{
		super(augmentedMatrix);
		this.augmentedMatrix = augmentedMatrix;
	}

	public double[][] RREF(double[][] augmentedMatrix)
	{
		if (this.augmentedMatrix == null)
		{
			System.out.println("In RREF: augmentedMatrix is null");
			return null;
		}

		int rowCount = getRowCount();
		int colsCount = getColumnCount();
		int iCols = 0;

		for (int iRow = 0; iRow < rowCount; iRow++)
		{
			if (iCols >= colsCount)
			{
				break;
			}
			int pivotRow = iRow;

			while (data[pivotRow][iCols] == 0)
			{
				pivotRow++;
				if (pivotRow == rowCount)
				{
					pivotRow = iRow;
					iCols++;
					if (iCols == colsCount)
					{
						return data;

					}
				}
			}
			swapRow(pivotRow, iRow);
			double pivot = data[iRow][iCols];

			if (pivot != 0)
			{
				scaleRow(iRow, 1.0 / pivot);
			}
			for (int eliminationRow = 0; eliminationRow < rowCount; eliminationRow++)
			{
				if (eliminationRow != iRow)
				{
					double factor = data[eliminationRow][iCols];
					addRow(eliminationRow, iRow, -factor);
				}
			}
			iCols++;
		}
		return data;
	}

	public void displayMatrix(double[][] RREF)
	{
		for (int m = 0; m < RREF.length; m++)
		{
			for (int n = 0; n < RREF[0].length; n++)
			{
				System.out.print(RREF[m][n]);
				if (n == RREF[0].length - 2)
				{
					System.out.print(" | ");
				} else if (n < RREF[0].length - 1)
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public void readSolution(double[][] RREF)
	{

		int numRows = RREF.length;
		int numCols = RREF[0].length;
		int numVariables = numCols - 1;


		if (numRows == numVariables)
		{
			boolean uniqueSolution = true;
			boolean infintesolution = true;
			// we want to traverse the matrix diagonally to see if a 0 appears in that
			// diagonal position
			for (int n = 0; n < numRows; n++)
			{
				if (RREF[n][n] == 0) {
					uniqueSolution = false;
					break;
				}

			}

			if (uniqueSolution == true)
			{
				for (int n = 0; n < numRows; n++)
				{
					int displaySol = n + 1;

					System.out.println("x" + displaySol + " = " + RREF[n][numCols - 1]);
					infintesolution = false;
				}
			}
			if (uniqueSolution == false)
			{
				// check if solution is infinite or non exisistant

				for (int n = 0; n < numRows; n++)
				{
					if (RREF[n][n] == 0 && RREF[n][numCols - 1] != 0)
					{
						boolean noSolution = true;
						for (int i = 0; i < numCols - 1; i++)
						{
							if (RREF[n][i] != 0)
							{
								noSolution = false;
								break;
							}
						}
						if (noSolution == true) {
							System.out.println("The system has no solution");
							return;
						}

					}

				}
			}
			if (infintesolution == true)
			{
				boolean RowSolution = true;
				for (int n = 0; n < numRows; n++)
				{
					if (RREF[n][n] != 0) {
						for (int i = n + 1; i < numCols - 1; i++)
						{
							if (RREF[n][i] != 0)
							{
								int displaySol = n + 1;
								int variDisplay = i + 1;
								System.out.println("x" + displaySol + " = " + RREF[n][numCols - 1] + " +( " + (-RREF[n][i]) + "x" + variDisplay + ")");
							}
						}
					}
				}

			}

		}


		if (numVariables > numRows)
		{
			if (RREF[numRows - 1][numVariables - 1] == 0 && RREF[numRows - 1][numVariables] != 0)
			{
				System.out.println("System has no solution");
				return;
			}
			for (int n = 0; n < numRows; n++)
			{
				if (RREF[n][n] == 1)
				{
					boolean firstOutput = false;
					System.out.print("x" + (n + 1) + " ");

					for (int i = n + 1; i <= numVariables; i++)
					{
						if (i == numVariables)
						{
							double constantTerm = RREF[n][i];

							if (!firstOutput)
							{
								System.out.print("= " + constantTerm);
								firstOutput = true;
							} else
							{
								System.out.print(" + " + constantTerm);
							}
						} else if (RREF[n][i] != 0)
						{
							double outputVari = -1.0 * RREF[n][i];

							if (!firstOutput)
							{
								System.out.print("= " + outputVari + "x" + (i + 1));
								firstOutput = true;
							} else
							{
								System.out.print(" + " + outputVari + "x" + (i + 1));
							}
						}
					}
					System.out.println();
				}
			}
		}


		if (numVariables < numRows)
		{
			for (int n = 0; n < numRows; n++)
			{
				boolean allZeros = true;
				for (int i = 0; i < numCols - 1; i++)
				{
					if (RREF[n][i] != 0) {
						allZeros = false;
						break;
					}
				}
				if (allZeros && RREF[n][numCols - 1] != 0)
				{
					System.out.println("System has no solution");
					return;
				}
			}

			boolean uniqueSolution = true;
			for (int n = 0; n < numRows; n++)
			{
				if (n < numVariables && RREF[n][n] == 0)
				{
					uniqueSolution = false;
					break;
				}
			}

			if (uniqueSolution)
			{
				for (int n = 0; n < numRows && n < numVariables; n++)
				{
					int displaySol = n + 1;
					System.out.println("x" + displaySol + " = " + RREF[n][numCols - 1]);
				}
			}
			else
			{

				for (int n = 0; n < numVariables; n++)
				{
					if (RREF[n][n] != 0)
					{
						String equation = "x" + (n + 1) + " = " + RREF[n][numCols - 1];
						for (int i = n + 1; i < numVariables; i++)
						{
							if (RREF[n][i] != 0)
							{
								equation += " + (" + (-RREF[n][i]) + "x" + (i + 1) + ")";
							}
						}
						System.out.println(equation);
					}
				}
			}

			for (int n = 0; n < numRows; n++)
			{
				for (int i = 0; i < numCols - 1; i++)
				{
					if (RREF[n][i] == 0 && RREF[n][i + 1] != 0)
					{
						System.out.println("System has no solution");
						return;
					}
				}
			}
		}


	}
}

        	
        	
        	


        
        	
    
    
        
        
        
        
        
 
	
	


	
	