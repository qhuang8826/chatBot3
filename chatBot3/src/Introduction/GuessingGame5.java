package Introduction;

import java.util.Scanner;
//public int [return type] doIt(double[datatype of the 1st received parameter] trouble, int num)
	//int[long, short, byte, char]
	//double and float continuous
	/*double x = 2.7;
	 *int y = 15;
	 *int result = doIt(x,y);
	 *result = 16
	 *trouble = DNE; (parameter variables are only local to that method)
	 *num = DNE;
	 *x= 2.7;
	 *y= 15;
	*/
	//If you have two methods with the same name and parameters(datatypes), it will not compile.
	/* Notes on Arrays
	 *boolean arrays given false values after instantiating
	 int[] results; declare int array with null value 
	 int[] results = new int[5] <-- how big the array is
	 results[0]..[1]..[2]..[3]..[4]
	 */
public class GuessingGame5
{
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		int level = 0;
		int guess = 0;
		int tries = 0;
		int reset = 0;
		while(level < 1 || level >4)
		{
			//menu 
			System.out.println("1. Beginner Level: 1-10");
			System.out.println("2. Intermediate Level:1-100");
			System.out.println("3. Advanced Level:1-1000");
			System.out.println("4. Expert Level:1-10000");
			System.out.println();
			System.out.print("Enter a number:");
		
		level = myScanner.nextInt();
		}
		int target = (int)(Math.random() * Math.pow(10, level)) + 1; 
		System.out.println("You have chosen level " + level + ".Please enter a guess");
		while(guess != target)
		{
			guess = myScanner.nextInt();
			tries++;
			if(guess > target)
				{
				System.out.println("Your guess is too high, try again!");
				}
				if(guess < target)
				{
				System.out.println("Your guess is too low, try again!");
				}
			System.out.println("Guess again");
		}
		if(guess == target)
			{
			System.out.println("You guessed right!");
			System.out.println("It took you " + tries + " to guess correctly. \nDo you want to play again? Press 1 for Yes or 2 for No");
			reset = myScanner.nextInt();
				if(reset == 1)
				{
					resetGame();	
				}
				else
				{
					System.out.println("Thanks for playing!");
				}
			}
	}
	public static void resetGame()
	{
		Scanner myScanner = new Scanner(System.in);
		int level = 0;
		int guess = 0;
		int tries = 0;
		
		while(level < 1 || level >4)
		{
			//menu 
			System.out.println("1. Beginner Level: 1-10");
			System.out.println("2. Intermediate Level:1-100");
			System.out.println("3. Advanced Level:1-1000");
			System.out.println("4. Expert Level:1-10000");
			System.out.println();
			System.out.print("Enter a number:");
		
		level = myScanner.nextInt();
		}
		int target = (int)(Math.random() * Math.pow(10, level)) + 1; 
		System.out.println("You have chosen level " + level + ".Please enter a guess");
		System.out.println(target);
		while(guess != target)
		{
			guess = myScanner.nextInt();
			tries++;
			if(guess > target)
				{
				System.out.println("Your guess is too high, try again!");
				}
				if(guess < target)
				{
				System.out.println("Your guess is too low, try again!");
				}
			System.out.println("Guess again");
		}
		if(guess == target)
			{
			System.out.println("You guessed right!");
			System.out.println("It took you " + tries + " to guess correctly. \nDo you want to play again? Press 1 for Yes or 2 for No");
			}
	}
	/*public static int doIt(int x)
	{
		//no guarantee it will return an int so compile error
		if(x>0)
			return 1;
		if(x<0)
			return -1;	
			
		return 0;
	}
	*/
}
