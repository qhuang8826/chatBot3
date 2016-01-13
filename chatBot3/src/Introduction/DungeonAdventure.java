package Introduction;

public class DungeonAdventure {
	
	static boolean didNotChoose;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorld.promptName();
		HelloWorld.print("Welcome " + HelloWorld.username + " to Choose Your own Adventure.\n" +
			"Press 1 to go left \nPress 2 to go right.");
		didNotChoose = true;
		while(didNotChoose){
			String firstPath = HelloWorld.waitForInput();
			if(firstPath.equals("1")){
				didNotChoose = false;
				goLeft();
			}else if(firstPath.equals("2")){
				didNotChoose = false;
				goRight();
			}else {
				HelloWorld.print("Invalid submission.\n Press 1 to go left \n Press 2 to go right.");
			}
		}
	}

	public static void goLeft(){
		HelloWorld.print("You are in a brightly lit lunchroom with tables of " +
				"restaurant quality food laid out in front of you. What do you do?\n" +
				"Press 1 to eat the food\n" +
				"Press 2 to look for a way out\n" +
				"Press 3 to ask \"Hello\"");
		didNotChoose = true;
		while(didNotChoose){
			String eatLookAsk = HelloWorld.waitForInput();
			if(eatLookAsk.equals("1")){
				didNotChoose = false;
				eatFood();
			}else if(eatLookAsk.equals("2")){
				didNotChoose = false;
				lookForWayOut();
			}else if (eatLookAsk.equals("3")){
				didNotChoose = false;
				askHello();
			}else {
				HelloWorld.print("Invalid submission.\n Press 1 to eat the food\n" +
				"Press 2 to look for a way out\n Press 3 to ask \"Hello\"");
			}
		}
		
	}
	
	public static void eatFood(){
		HelloWorld.print("The food was poisoned and you die shortly after.\nPress enter to play again.");
		didNotChoose = true;
		while(didNotChoose){
			String tmp = HelloWorld.waitForInput();
			if(tmp.equals("")){
				main(null);
			}else{
				HelloWorld.print("Invalid entry.\nPress enter to play again.");
			}
		}
	}
	
	public static void lookForWayOut(){
		HelloWorld.print("After walking for a while, you see two doors again. So do you go through " +
				"the left door or right door?\nPress 1 to go left.\nPress 2 to go right.");
		
		didNotChoose = true;
		while(didNotChoose){
			String path = HelloWorld.waitForInput();
			if(path.equals("1")){
				didNotChoose = false;
				goLeft();
			}else if(path.equals("2")){
				didNotChoose = false;
				goRight();
			}else {
				HelloWorld.print("Invalid submission.\n Press 1 to go left \n Press 2 to go right.");
			}
		}
	}
	
	public static void askHello(){
		HelloWorld.print("\"Hello\" the room echos back at you. Suddenly, the room starts to shake " +
				"while the ceiling and floor starts to crumble. You start running for your life. " +
				"You trip and fall, landing on your back. As you look up, you see a giant rock about " +
				"collapse on you. What do you do? \nPress 1 to roll out of the way.\nPress 2 to accept " +
				"death.");
		didNotChoose = true;
		while(didNotChoose){
			String path = HelloWorld.waitForInput();
			if(path.equals("1")){
				didNotChoose = false;
				rollAway();
			}else if(path.equals("2")){
				didNotChoose = true;
				while(didNotChoose){
					String tmp = HelloWorld.waitForInput();
					if(tmp.equals("")){
						main(null);
					}else{
						HelloWorld.print("Invalid entry.\nPress enter to play again.");
					}
				}
				
			}else {
				HelloWorld.print("Invalid submission.\n Press 1 to roll away\n Press 2 to accept death.");
			}
		}
	}
	
	public static void rollAway(){
		HelloWorld.print("You successfully rolled away and save your life! Congratulations, but then " +
				"a second rock falls the crushes you to death. Sorry.\nPress enter to play again.");
		didNotChoose = true;
		while(didNotChoose){
			String tmp = HelloWorld.waitForInput();
			if(tmp.equals("")){
				main(null);
			}else{
				HelloWorld.print("Invalid entry.\nPress enter to play again.");
			}
		}
	}
	
	public static void goRight(){
		
	}

}
