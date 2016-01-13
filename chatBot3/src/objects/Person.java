package objects;

import java.util.ArrayList;

public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	public static int MAX_ALLOWED_BOOKS = 3;
	private ArrayList<Book> checkedOutBooks;
	private boolean male;
	private Balance balance;
	
	public Balance getBalance() {
		return balance;
	}

	//constructor
	//no return type: it "returns"(constructs) a Person
	public Person(String firstName, String lastName){
		this.firstName = firstName;//assigns firstName to the fN parameter
		middleName = "";//default middle name
		this.lastName = lastName;//this is used to specify the FIELD, 
		//whereas lastName (by itself) is the local parameter
		checkedOutBooks = new ArrayList<Book>();
		male = true;
		balance = new Balance();
	}

	//constructor for middle-named people
	public Person(String firstName, String middleName, String lastName){
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		checkedOutBooks = new ArrayList<Book>();
		male = true;
		balance = new Balance();
	}
	
	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public String toString(){
		return firstName+" "+middleName+" "+lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public ArrayList<Book> getCheckedOutBooks() {
		return checkedOutBooks;
	}
	
	public void checkOutBook(Book book){
		book.setCheckedOut(true);
		book.setCheckOutDate(System.currentTimeMillis());
		book.setDueDate(System.currentTimeMillis()+30000);
		checkedOutBooks.add(book);
	}
	
	public void returnBook(Book book){
		long timeNow = System.currentTimeMillis();
		book.updateCondition(timeNow);
		balance.subtractLateFees(timeNow-book.getDueDate());
		book.setCheckedOut(false);
		book.setCheckOutDate(0);
		book.setDueDate(0);
		checkedOutBooks.remove(book);
	}
	
	public void renewBook(Book book){
		book.setDueDate(System.currentTimeMillis()+30000);
	}
	
	public String getGenderPosessivePronoun(){
		if(male)return "his";
		return "her";
	}
	
	public String getLibraryDescription(){
		return firstName + " is viewing the library collection and has $" + balance.getAmount() +"."; 
	}
}
