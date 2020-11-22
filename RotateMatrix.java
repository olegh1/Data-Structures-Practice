import java.util.Scanner;

public class RotateMatrix {

	public static void rotateMatrix(int[][] matrix){
		

		int temp;
		
		
		for(int i = 0; i < matrix.length/2; i++){
		for(int j = matrix.length - 1 -i; j > i; j--){
	
		// top
		temp = matrix[i][(matrix.length - 1) - j];
		matrix[i][(matrix.length - 1) - j] = matrix[(matrix.length - 1) - j][(matrix.length - 1) - i];
		matrix[(matrix.length - 1) - j][(matrix.length - 1) - i] = temp;

		//bot 

		temp = matrix[j][i];
		matrix[j][i] = matrix[(matrix.length - 1) - i][j];
		matrix[(matrix.length - 1) - i][j] = temp;

		//swap

		temp = matrix[j][i];
		matrix[j][i] = matrix[(matrix.length - 1) - j][(matrix.length - 1) - i];
		matrix[(matrix.length - 1) - j][(matrix.length - 1) - i] = temp;


			}
		}
	}


	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		System.out.println(" n x n matrix: ");
		int n = in.nextInt();
		System.out.println("\n");
		System.out.println("Rotate Counter Clockwise \n \n");

		int[][] matrix = new int[n][n];
		int sum = 1;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = sum;
				sum++;
			}
		}

		String rep = "";

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				rep += matrix[i][j];
				rep += "   ";
			}
			rep += "\n";
		}
		System.out.println(rep);

		rotateMatrix(matrix);

		rep = "";

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				rep += matrix[i][j];
				rep += "   ";
			}
			rep += "\n";
		}
		System.out.println(rep);
	}
}