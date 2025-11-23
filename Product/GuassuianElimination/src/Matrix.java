public class Matrix 
{
	protected double[][] data; 
	protected int rows;
	protected int cols; 
	
	
	public Matrix(double[][] augmentedMatrix) 
	{
		this.rows= augmentedMatrix.length;
		this.cols = augmentedMatrix[0].length;
		this.data = augmentedMatrix;
		
		
	}
	
	//Accessors
	public int getRowCount()
	{
		return rows;
	}
	
	public int getColumnCount()
	{
		return cols;
	}

	public void swapRow(int row1, int row2)
	{
		double[] temp = data[row1];
		data[row1] = data[row2];
		data[row2] = temp;
		
	}
	
	public void scaleRow(int rowNum ,double k)
	{
		
		for(int i=0; i<cols; i++)
		{
			data[rowNum][i] = k * data[rowNum][i];
		}
	}
	
	public void addRow(int targetRow, int sourceRow, double k)
	{
		
		for (int i=0; i<cols; i ++)
		{
		data[targetRow][i] += k*data[sourceRow][i];
		}
	}
	
}




