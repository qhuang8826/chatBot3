package Introduction;

public class ConfirmEntry {

	static boolean notCorrect = true;
	static boolean notConfirmed = true;
	static boolean invalidEntry = true;
	static String name;
	static String color;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while(notCorrect){
			HelloWorld.print("Hello, what is your name?");
			name = HelloWorld.waitForInput();
			notConfirmed = true;
			
			while(notConfirmed){
				HelloWorld.print("So your name is " + name + ". Correct?");
				invalidEntry = true;

				while(invalidEntry){
					HelloWorld.print("Press 1 to confirm.\nPress 2 to re-enter your name");
					String confirmation = HelloWorld.waitForInput();
					if(confirmation.equals("1")){
						notCorrect = false;
						notConfirmed = false;
						invalidEntry = false;
					}else if(confirmation.equals("2")){
						invalidEntry = false;
						notConfirmed = false;
					}else{
						HelloWorld.print("Invalid entry.");
					}
				}
			}
		}

		notCorrect = true;
		while(notCorrect){
			HelloWorld.print("Hi, what's your favorite color?");
			color = HelloWorld.waitForInput();
			notConfirmed = true;
			
			while(notConfirmed){
				HelloWorld.print("So your favorite color is " + color + ". Correct?");
				invalidEntry = true;

				while(invalidEntry){
					HelloWorld.print("Press 1 to confirm.\nPress 2 to re-enter your color");
					String confirmation = HelloWorld.waitForInput();
					if(confirmation.equals("1")){
						notCorrect = false;
						notConfirmed = false;
						invalidEntry = false;
					}else if(confirmation.equals("2")){
						invalidEntry = false;
						notConfirmed = false;
					}else{
						HelloWorld.print("Invalid entry.");
					}
				}
			}
		}
		HelloWorld.print("Nice to meet you " + name + ", whose favorite color is " + color + ".");
	}

}
