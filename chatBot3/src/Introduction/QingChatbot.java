package Introduction;

import java.util.Arrays;
import java.util.Scanner; 

public class QingChatbot {
	
	static Scanner scan = new Scanner(System.in);
	static String[][] jokes = {
		{"",""},
		{"Orange", "Orange you going to let me in?"},//jokes[1][0,1]
		{"Iva", "I've a sore hand from knocking!"},//jokes[2][0,1]
		{"Harry","Harry up, it's cold out here!"},//jokes[3][0,1]
		{"A herd","A herd you were home, so I came over!"},//jokes[4][0,1]
		{"Adore","Adore is between us. Open up!"},//jokes[5][0,1]
		{"King Tut","King Tut-key fried chicken!"}//jokes[6][0,1]
	};
	static int[] tracker = new int[jokes.length];
	
	public static void main(String[] args){
		String test = "The quick brown fox jumped over the lazy dog.";
		getResponse(test);
		
		tellKnock();
		
	}
	
	public static String getResponse(String input){
		
		String[] sentence = input.split(" ");
		
		System.out.println(Arrays.toString(sentence));
		for(int i =0; i<sentence.length; i++){
			
		}
		
		return null;
	}
	
	public static void tellKnock(){
		System.out.println("Knock, knock.");
		int said = 0;
		boolean replied = false;
		boolean continued = true;
		int jokeNum = (int)(Math.random()*(jokes.length-1))+1;

		for(int i=1; i<tracker.length; i++){
			if(tracker[i]==i){
				said++;
			}
		}
		if(said == jokes.length-1){
			replied = true; 
			System.out.println("Sorry, I don't know anymore jokes.");
		}
		while(tracker[jokeNum] == jokeNum && replied == false){
			jokeNum = (int)(Math.random()*(jokes.length))+1;
		}
		tracker[jokeNum] = jokeNum;

		
		while(!replied){
			String reply = scan.nextLine();
			if(Magpie.findKeyword(reply, "who's there", 0)>-1){	
				System.out.println(jokes[jokeNum][0] + ".");
				replied = true;
				String comparison = jokes[jokeNum][0] + " who";
				while(continued){
					String reply2 = scan.nextLine();
					if(Magpie.findKeyword(reply2, comparison , 0)>-1){
						System.out.println(jokes[jokeNum][1] + " Haha!");
						continued = false;
					}
					else{
						System.out.println(madResponse() +" Say \"" + comparison + "\"");  
					}
				}
			}
			else{
				System.out.println(madResponse() + " Say \"who's there?\".");
			}
		}
		//Andy.magpie();
	}
	
	public static String madResponse(){
		int ran = (int)(Math.random()*5);
		String[] response = {"That's not what you're suppose to say!", 
				"Do you even know how a knock knock joke goes?",
				"How can you NOT know what to say?!",
				"Even a baby knows what to say!",
				"Do you not know what a knock knock joke is?"
		};
		return response[ran];
	}
}
