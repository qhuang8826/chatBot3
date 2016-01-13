package trial;

import java.util.Arrays;
import java.util.Scanner;

public class ChatBot3 {
		static Scanner scan = new Scanner(System.in);
		static String[][] jokes = new String[6][2];

		public static void main(String[] args){
			String test = "The quick brown fox jumped over the lazy dog.";
			getResponse(test);
			jokes[0][0] = "Orange";
			jokes[0][1] = "Orange you going to let me in?";
			jokes[1][0] = "Iva";
			jokes[1][1] = "I've a sore hand from knocking!";
			jokes[2][0] = "Harry";
			jokes[2][1] = "Harry up, it's cold out here!";
			jokes[3][0] = "A herd";
			jokes[3][1] = "A herd you were home, so I came over!";
			jokes[4][0] = "Adore";
			jokes[4][1] = "Adore is between us. Open up!";
			jokes[5][0] = "King Tut";
			jokes[5][1] = "King Tut-key fried chicken!";
			tellKnock();
			
		}
		
		public static String getResponse(String input){
			
			String[] sentence = input.split(" ");
			
			System.out.println(Arrays.toString(sentence));
			for(int i =0; i<sentence.length; i++){
				
			}
			
			return null;
		}
		
		public static int findKeyword(String statement, String goal, int startPos)
		{
			String phrase = statement.trim();
			//  The only change to incorporate the startPos is in the line below
			int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
			
			//  Refinement--make sure the goal isn't part of a word 
			while (psn >= 0) 
			{
				//  Find the string of length 1 before and after the word
				String before = " ", after = " "; 
				if (psn > 0)
				{
					before = phrase.substring (psn - 1, psn).toLowerCase();
				}
				if (psn + goal.length() < phrase.length())
				{
					after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
				}
				
				//  If before and after aren't letters, we've found the word
				if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
						&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
				{
					return psn;
				}
				
				//  The last position didn't work, so let's find the next, if there is one.
				psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
				
			}
			
			return -1;
		}
		
		public static void tellKnock(){
			System.out.println("Knock, knock.");
			boolean replied = false;
			boolean continued = true;
			
			while(!replied){
				String reply = scan.nextLine();
				if(findKeyword(reply, "who's there", 0)>-1){
					int jokeNum = (int)(Math.random()*(jokes.length));
					System.out.println(jokes[jokeNum][0] + ".");
					replied = true;
					String comparison = jokes[jokeNum][0] + " who";
					while(continued){
						String reply2 = scan.nextLine();
						if(findKeyword(reply2, comparison , 0)>-1){
							System.out.println(jokes[jokeNum][1]);
							continued = false;
						}
						else{
							System.out.println("You said the wrong thing. Please say \"" + comparison + "\"");  
						}
					}
				}
				else{
					System.out.println("You said the wrong thing. Please say \"who's there?\".");
				}
			}
			
		}
	



}
