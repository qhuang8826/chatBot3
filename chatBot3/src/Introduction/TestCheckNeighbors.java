package Introduction;

public class TestCheckNeighbors {

	/**
	 * @param args
	 */

	static int position;

	public static void main(String[] args) {
		boolean[][] mines = new boolean [3][3];
		for(int rows = 0; rows<mines.length; rows++){
			for(int columns = 0; columns<mines[rows].length;columns++){
				mines[rows][columns]=true;
			}
		}
		//mines[1][1]=true;
		//int row = getRandomInt(2);
		//int column = getRandomInt(2);
		int row = 1;
		int column = 1;

		int typeOfSpace = checkNeighbors(mines, row, column);
		if(typeOfSpace == 0){
			HelloWorld.print("At row "+row+", column "+column+", the mine was found!");
		}if(typeOfSpace == 1){
			HelloWorld.print("At row "+row+", column "+column+", there is a mine nearby!");
		}if(typeOfSpace == -1){
			HelloWorld.print("At row "+row+", column "+column+", there are no mines nearby!");
		}
	}

	public static int checkNeighbors(boolean[][] neighborhood, int r, int c){
		//If neighborhood[r][c] is adjacent (above, below, right, left) of a true value, return 1. 
		//If neighborhood is not adjacent to a true value, return -1.
		//return zero if IS a true value

		int numRows = neighborhood.length;
		int numColumns = neighborhood[r].length; 
		boolean nearHouse = false;

		if(r < numRows && r >-1 && c < numColumns && c >-1){
		
			if(c+1 < numColumns){
				if(neighborhood[r][c+1] == true){
					position = 1;
					nearHouse = true;
				}
			}
			if(c-1 >= 0){
				if(neighborhood[r][c-1] == true){
					position = 1;
					nearHouse = true;
				}
			}
			if(r-1 >= 0){
				if(neighborhood[r-1][c] == true){
					position = 1;
					nearHouse = true;
				}
			}
			if(r+1 < numRows){
				if(neighborhood[r+1][c] == true){
					position = 1;
					nearHouse = true;
				}
			}
			if(neighborhood[r][c] == true){
				position = 0;
				nearHouse = true;
			}
			if(!nearHouse){
				position = -1;
			}
		}			
		return position;
	}
}
