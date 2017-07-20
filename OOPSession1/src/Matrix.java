/*
 * class to apply various operations to a matrix
 */
import java.util.*;

public class Matrix {

	protected int matrix[][];
	protected int noRows, noCols;

	/**
	 * constructor to initialize a matrix
	 * 
	 * @param row
	 * @param col
	 */
	public Matrix(int row, int col) {
		this.noRows = row;
		this.noCols = col;
		matrix = new int[noRows][noCols];
	}

	/**
	 * add values to matrix
	 * 
	 * @param row
	 * @param col
	 * @param val
	 */
	public void addElements(int row, int col, int val) {
		matrix[row][col] = val;
	}

	public void show() {
		for (int index = 0; index < noRows; index++) {
			for (int jindex = 0; jindex < noCols; jindex++) {
				System.out.print(matrix[index][jindex] + "  ");
			}
			System.out.println();
		}
	}

	/**
	 * multiply 2 matrices
	 * 
	 * @param mat
	 * @return a matrix with result as multiplication of 2 matrices
	 */
	public Matrix multiply(Matrix mat) {
		Matrix result = new Matrix(noCols, noRows);
		if (noCols == mat.noRows) {
			for (int index = 0; index < noRows; index++) {
				for (int jindex = 0; jindex < mat.noCols; jindex++) {
					for (int kindex = 0; kindex < noCols; kindex++) {
						result.matrix[index][jindex] += matrix[index][kindex]
								* mat.matrix[kindex][jindex];
					}
				}
			}
		} else {
			System.out.println("Matrices can not be multiplied");
		}
		return result;
	}

	/**
	 * perform transpose operation on matrix
	 * 
	 * @return object matrix
	 */
	public Matrix transpose() {
		Matrix mat = new Matrix(noCols, noRows);
		for (int index = 0; index < mat.noRows; index++) {
			for (int jindex = 0; jindex < mat.noCols; jindex++) {
				mat.matrix[index][jindex] = matrix[jindex][index];
			}
		}
		return mat;
	}

	public static void main(String args[]) {

		Scanner scan = null;
		try {
			System.out.print("enter number of rows and columns of matrix ");
			scan = new Scanner(System.in);
			int rows = scan.nextInt();
			int columns = scan.nextInt();

			Matrix object = new Matrix(rows, columns);

			System.out.print("enter elements of matrix ");
			for (int index = 0; index < rows; index++) {
				for (int jindex = 0; jindex < columns; jindex++) {
					object.addElements(index, jindex, scan.nextInt());
				}
			}
			object.show();

			System.out.println();
			System.out
					.print("enter number of rows and columns of matrix to multiply");
			rows = scan.nextInt();
			columns = scan.nextInt();
			Matrix obj = new Matrix(rows, columns);

			System.out.print("enter elements of matrix to multiply");
			for (int index = 0; index < rows; index++) {
				for (int jindex = 0; jindex < columns; jindex++) {
					obj.addElements(index, jindex, scan.nextInt());
				}
			}
			obj.show();

			System.out.println();
			System.out.print("Matrix multiplication :- ");
			System.out.println();
			Matrix result = object.multiply(obj);
			result.show();
			System.out.println();
			System.out.print("Matrix Transpose :- ");
			System.out.println();
			Matrix mat = object.transpose();
			mat.show();
		} finally {
			scan.close();
		}
	}
}
