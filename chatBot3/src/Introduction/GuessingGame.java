package Introduction;

import java.util.Scanner;

public class GuessingGame{
	
  
	private static final boolean InputMismatchException = false;

	public static void main (String[] args)
    {
        Scanner scanner = new Scanner (System.in);
    
        int level = 0;
            while (level < 1 ||level > 4){  
                System.out.println("1. Beginner Level (numbers between 1 and ten)");
                System.out.println("2. Intermediate Level (numbers between 1 and 100)");
                System.out.println("3. Advanced Level (numbers between 1 and 1,000)");
                System.out.println("4. Expert Level (numbers between 1 and 10,000)");
                System.out.println();
                System.out.println("Type the number corresponding to the level you want to play:");
                
                level = scanner.nextInt();
                
                if(level != 1 && level != 2 && level != 3 && level != 4){
                    level = 0;
                }
            }
     }
}
