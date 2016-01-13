package Introduction;

import java.util.Scanner;

public class HelloWorld {
	
	static int numberOfMessages=0;
	static Scanner input = new Scanner(System.in);
	static String username;
	static boolean running;
	/**
	 * NOTES:
	 * 
	 */
	public static void main(String[] args) {
//		print("Hello World!");//OVERLOADED: same method with different arguments
		print(25/2);
//		print(5+6);
//		print(8*5);
//		String message = "This is a message assigned to a variable named message.";
//		print(message);
//		int number1 = 5;
//		int number2 = 6;
//		int sum = number1+number2;
//		print(number1/number2);
//		print("The numbers are " + number1 + " and " + number2 + 
//				". Their sum is " + sum + ".");
//		for (int i=1; i<61; i++){
//			print("The numbers are " + number1 + " and " + number2 + 
//				". Their sum is " + sum + ".");
//			print("This message has been printed " + i + " times.");
//		}
//		
//		print("What is your name?");
//		
//		String userName = input.next();
//		
//		print("Your name is " + userName + ".");
//		print("What is your favorite animal?");
//		String favoriteAnimal = waitForInput();
//		print("Wow, that sure is great. I love " + favoriteAnimal + " also!");
		
//		promptName();
//		endlessConversation();
	}
	
	public static void endlessConversation(){
		running = true;
		while(running){
			print("What school do you go to?");
			String school = waitForInputProvideChoices();
			if(school.equals("S")){
				talkAboutBread();
			}else if(school.equals("Q")){
				running=false;
			}else{
				print("Oh, so you go to "+school+"?");
			}
//			print("Oh, so you go to " +waitForInput()+"?");
			
		}
	}
	
	public static void talkAboutBread(){
		print("I like bread. Yum!");
	}
	
	public static void print(int i) {
		System.out.println(i);
	}

	public static void print(String string){
//		numberOfMessages++;
//		System.out.println(numberOfMessages + "th message: " + string);
		System.out.println(string);
	}
	
	public static String waitForInput(){
		String entry = input.nextLine();
		return entry;
	}
	
	public static String waitForInputProvideChoices(){
		print("You may type the following commands:\n" +
				" \"Q\" - to quit\n" +
				" \"S\" - start over");
		String entry = input.nextLine();
		return entry;
	}
	
	public static void promptName(){
		print("Please enter your name.");
		username = waitForInput();
		print("Okay, I will call you " + username + ".");
	}

	
}
