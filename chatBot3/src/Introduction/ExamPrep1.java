package Introduction;

public class ExamPrep1 {

	public static void main(String[] args){
		int[][] test = {{2, 4, 9, 5, 3, 6, 7, 1, 8},{6, 7, 1, 9, 8, 4, 3, 5, 2}, {3, 5, 8, 1, 2, 7, 6, 9, 4},
				{4, 2, 6, 7, 1, 9, 8, 3, 5},{8, 9, 7, 3, 5, 2, 4, 6, 1},{5, 1, 3, 6, 4, 8, 2, 7, 9},
				{9, 6, 4, 2, 7, 1, 5, 8, 3},{1, 8, 5, 4, 6, 3, 9, 2, 7},{7, 3, 2, 8, 9, 5, 1, 4, 6}};
		
		System.out.println(checkSudoku(test));
	}
	
	public static int getScoreToDrop(int[] pValue, double[] pScore){
		/** this method helps a teacher figure out which assignment
         * has the greatest negative impact on a student's grade
         * so that the assignment can be dropped. It does this by taking two
         * arrays as parameters. The point value of every assignment is 
         * stored in one array, pValue, and the corresponding percent 
         * score is stored in another array, pScore, at the same index.
         * You may assume pValue and pScore have the same length
         * Note that pScore is a double[] and the percentages are stored in 
         * decimal form (e.g. .63 instead of 63%)
         * The method returns the index of the assignment to be dropped. 
         * This is determined to be the assignment at the index for which the PRODUCT
         * of (1.0 - pScore) and (pValue) is most (basically, greatest number of raw points MISSED)
         * and the pValue is not more than 50 points. (since assignments 
         * worth 51 points or more are exams or quizzes, which cannot be dropped.)
         * You may assume that such an assignment (ones worth less than 51 points) 
         * always exists.
         * */
		
		double[] rawScore = new double[pValue.length];
		for(int i=0; i<pValue.length; i++){
			if(pValue[i]<51){
				double tmp = (double)(1.0-pScore[i]);
				rawScore[i]=tmp*(pValue[i]);
			}
		}
		double check = 0;
		int index = -1;
		for(int j=0; j<rawScore.length; j++){
			if(rawScore[j]>check){
				check = rawScore[j];
				index = j;
			}
		}
		return index;
	}
	
	public static String assignLetterGrade(double grade){
        /** This method assigns a letter grade based on a percentage, in decimal form
         * Grades, g,  are assigned accordingly:
         * .97 <= g <= 1.0 = A+
         * .94 <= g < .97 = A
         * .90 <= g < .94 = A-
         * .87 <= g < .90 = B+
         * .84 <= g < .87 = B
         * .80 <= g < .84 = B-
         * .77 <= g < .80 = C+
         * .74 <= g < .77 = C
         * .70 <= g < .74 = C-
         * .60 <= g < .70 = D
         * g <= .64  = F
         * */
		double g = grade;
		String letter = "z";
		if(g<=1 && g>=.97){
			letter = "A+";
		}
		if(g<.97 && g>=.94){
			letter = "A";
		}
		if(g<.94 && g>=.90){
			letter = "A-";
		}
		if(g<.90 && g>=.87){
			letter = "B+";
		}
		if(g<.87 && g>=.84){
			letter = "B";
		}
		if(g<.84 && g>=.80){
			letter = "B-";
		}
		if(g<.80 && g>=.77){
			letter = "C+";
		}
		if(g<.77 && g>=.74){
			letter = "C";
		}
		if(g<.74 && g>=.70){
			letter = "C-";
		}
		if(g<.70 && g>=.60){
			letter = "D";
		}
		if(g<.60){
			letter = "F";
		}
         return letter;
    }
	
	public static boolean checkSudoku(int[][] solution){
        /**this method takes a 9x9 int[][] as a parameter and checks if it is a sudoku solution
         * (It is safe to assume that "solution" is truly 9x9 and that all of the elements are also valid (1-9 only))
         * To be a solution, every row and column must contain a distinct number (1-9)
         * Furthermore, every 3x3 must contain a distinct number (1-9)
         * The 3x3 subgrids are 
         * soultion[0][0]-solution[2][2]
         * soultion[0][3]-solution[2][5]
         * soultion[0][6]-solution[2][8]
         * soultion[3][0]-solution[5][2]
         * soultion[3][3]-solution[5][5]
         * soultion[3][6]-solution[5][8]
         * soultion[6][0]-solution[8][2]
         * soultion[6][3]-solution[8][5]
         * soultion[6][6]-solution[8][8]
         * 
         * 
         * An example of a valid grid (if I typed it correctly) is:
         * [2 4 9 5 3 6 7 1 8]
         * [6 7 1 9 8 4 3 5 2]
         * [3 5 8 1 2 7 6 9 4]
         * [4 2 6 7 1 9 8 3 5]
         * [8 9 7 3 5 2 4 6 1]
         * [5 1 3 6 4 8 2 7 9]
         * [9 6 4 2 7 1 5 8 3]
         * [1 8 5 4 6 3 9 2 7]
         * [7 3 2 8 9 5 1 4 6]
         * 
         * a test has not yet been made for this method
         * */
		
		boolean correct = true;
		for(int i=0;i<solution.length;i++){
			for(int j=0;j<solution[i].length;j++){
				if(j+1<solution[i].length){
					int tmp =j;
					while(tmp>-1){
						if(solution[i][j+1] == solution[i][tmp]){
							correct = false;
						}
						tmp--;
					}
				}
			}
		}
		for(int i=0;i<solution.length;i++){
			for(int j=0;j<solution.length;j++){
				if(j+1<solution[i].length){
					int tmp =j;
					while(tmp>-1){
						if(solution[j+1][i] == solution[tmp][i]){
							correct = false;
						}
						tmp--;
					}
				}
			}
		}
//		soultion[0][0]-solution[2][2]
//		         * soultion[0][3]-solution[2][5]
//		         * soultion[0][6]-solution[2][8]
//		         * soultion[3][0]-solution[5][2]
//		         * soultion[3][3]-solution[5][5]
//		         * soultion[3][6]-solution[5][8]
//		         * soultion[6][0]-solution[8][2]
//		         * soultion[6][3]-solution[8][5]
//		         * soultion[6][6]-solution[8][8]
//		int count =0;
//		int start =0;
//		int end =3;
//		while(count<9){
//			for(int i=start;i<end;i++){
//				for(int j=start;j<end;j++){
//					if(j+1<end){
//						int holder = start;
//						int tmpRow =i;
//						int tmpCol =j;
//						while(tmpRow>=holder && tmpCol>=holder){
//							if(solution[i][j+1] == solution[tmpRow][tmpCol]){
//								correct = false;
//							}
//							if(tmpCol>0){
//								tmpCol--;
//							}else if(tmpRow>0){
//								tmpRow--;
//								tmpCol=end-1;
//							}
//							
//						}
//					}
//				}
//			}
//		}
		
		int sum =0;
		int count =1;
		
		int startCol =0;
		int endCol =3;
		
		int startRow =0;
		int endRow =3;
		
		while(count<9){
			for(int i=startRow;i<endRow;i++){
				for(int j=startCol;j<endCol;j++){
					sum += solution[i][j];
				}
			}
			if(sum!= 45){
				count=9;
				correct = false;
			}
			else{
				count++;
				if(endCol<9){
					startCol+=3;
					endCol+=3;
				}else if(endRow<9){
					startRow+=3;
					endRow+=3;
					startCol=0;
					endCol=3;
				}
			}
		}
         return correct;
    }
}
