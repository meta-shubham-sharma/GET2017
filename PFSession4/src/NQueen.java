/*
 * class to implement NQueen Problem
 */
public class NQueen {
	protected int num;
	void printSolution(int board[][]) {
		for (int index = 0; index < num ; index++) {
			for (int jIndex = 0; jIndex < num; jIndex++)
				System.out.print(" " + board[index][jIndex] + " ");
			System.out.println();
		}
	}
	boolean isSafe(int board[][], int row, int col) {
		int index, jIndex;

		/* Check this row on left side */
		for (index = 0; index < col; index++)
			if (board[row][index] == 1)
				return false;

		/* Check upper diagonal on left side */
		for (index = row, jIndex = col; index >= 0 && jIndex >= 0; index--, jIndex--)
			if (board[index][jIndex] == 1)
				return false;

		/* Check lower diagonal on left side */
		for (index = row, jIndex = col; jIndex >= 0 && index < num; index++, jIndex--)
			if (board[index][jIndex] == 1)
				return false;

		return true;
	}

	/*
	 * A recursive utility function to solve n Queen problem
	 */
	boolean solveNQUtil(int board[][], int col) {
		/*
		 * base case: If all queens are placed then return true
		 */
		if (col >= num)
		{
			return true;
		}

		/*
		 * Consider this column and try placing this queen in all rows one by
		 * one
		 */
		for (int index = 0; index < num; index++) 
		{
			/*
			 * Check if queen can be placed on board[i][col]
			 */
			if (isSafe(board,index,col)) 
			{
				/* Place this queen in board[i][col] */
				board[index][col] = 1;

				/* recur to place rest of the queens */
				if (solveNQUtil(board, col + 1) == true){
					return true; }

				/*
				 * If placing queen in board[i][col] doesn't lead to a solution
				 * then remove queen from board[i][col]
				 */
				board[index][col] = 0; // BACKTRACK
			}
		}

		/*
		 * If queen can not be place in any row in this colum col, then return
		 * false
		 */
		return false;
	}
	boolean solveNQ() {
		int board[][] = new int[num][num];

		if (solveNQUtil(board, 0) == false) {
			System.out.print("Solution does not exist");
			return false;
		}

		printSolution(board);
		return true;
	}

	public static void main(String args[]) {
		NQueen Queen = new NQueen();
		Queen.num = 4;
		Queen.solveNQ();
	}

}