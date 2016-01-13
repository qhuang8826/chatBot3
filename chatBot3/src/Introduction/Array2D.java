package Introduction;

public class Array2D {

	/**
	 * @param args
	 */
	static boolean inside = false; 
	static int position;
	
	public static void main(String[] args) {
		int[][] grid3x3 = new int[3][3];
//		ArrayPractice.printArrayContent(grid3x3[0]);//prints the first (index 0)
//		ArrayPractice.printArrayContent(grid3x3[1]);
//		ArrayPractice.printArrayContent(grid3x3[2]);
//		System.out.println("");
		print2DArrayContent(grid3x3);
		checkAdjacentValues();
	}

	public static void checkAdjacentValues(){
		boolean[][] mines = new boolean [3][3];
		mines[2][1]=true;
		//int row = getRandomInt(2);
		//int column = getRandomInt(2);
		int row = 2;
		int column = 2;
		
		int typeOfSpace = checkspace(mines, row, column);
		if(typeOfSpace == 0){
			HelloWorld.print("At row "+row+", column "+column+", the mine was found!");
		}if(typeOfSpace == 1){
			HelloWorld.print("At row "+row+", column "+column+", there is a mine nearby!");
		}if(typeOfSpace == -1){
			HelloWorld.print("At row "+row+", column "+column+", there are no mines nearby!");
		}
	}
	
	public static int checkspace(boolean[][] mines, int r, int c) {
		int numRows = mines.length;
		int numColumns = mines[r].length; 
		boolean nearHouse = false;

		if(r < numRows && r >-1 && c < numColumns && c >-1){
		
			if(c+1 < numColumns){
				if(mines[r][c+1] == true){
					position = 1;
					nearHouse = true;
				}
			}
			if(c-1 >= 0){
				if(mines[r][c-1] == true){
					position = 1;
					nearHouse = true;
				}
			}
			if(r-1 >= 0){
				if(mines[r-1][c] == true){
					position = 1;
					nearHouse = true;
				}
			}
			if(r+1 < numRows){
				if(mines[r+1][c] == true){
					position = 1;
					nearHouse = true;
				}
			}
			if(mines[r][c] == true){
				position = 0;
				nearHouse = true;
			}
			if(!nearHouse){
				position = -1;
			}
		}			
		return position;
	}

	public static int getRandomInt(int max){
		int random = (int)(Math.random()*max)+1;
		return random;
	}
	
	public static void print2DArrayContent(int[][] array) {
		for(int[] x: array){
			ArrayPractice.printArrayContent(x);
		}
		
	}

	public static void print2DArrayContent(boolean[][] array) {
		for(boolean[] x: array){
			ArrayPractice.printArrayContent(x);
		}
		
	}

}
