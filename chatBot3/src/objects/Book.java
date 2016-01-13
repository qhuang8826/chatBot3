package objects;

import java.awt.Color;

public class Book {
	private String title;
	private int numberOfPages;
	private Person author;//custom class in this package
	private Color jacketColor;//class from java.awt
	private boolean wasLitOnFire;
	private int height;
	private int thickness;
	private boolean checkedOut;
	private long checkOutDate;
	private long dueDate;
	public static String[] conditions = {
	"This appears to be a brand new book! How lucky!",
	"This book is very gently used.",
	"This book is in ruins."};
	private String description = conditions[0];
	private int accumulatedUse = 0;
	
	
	public Book(String title, int numberOfPages, Person author){
		this.title = title;
		this.numberOfPages = numberOfPages;
		this.author = author;
		jacketColor = Color.gray;
		wasLitOnFire = false;
		height = (int)(Math.random()*100)+150;
		thickness = (int)(this.numberOfPages/10);
		checkedOut = false;
		checkOutDate = 0;
		dueDate = 0;
	}
	
	public void updateCondition(long timeOfReturn){
		accumulatedUse += (int)((timeOfReturn-checkOutDate)/1000);
		if(accumulatedUse>30 &&accumulatedUse<=60)description=conditions[1];
		if(accumulatedUse>60)description = conditions[2];
	}
	
	public String getDescription() {
		return description;
	}

	public int getAccumulatedUse() {
		return accumulatedUse;
	}

	public int getHeight() {
		return height;
	}

	public int getThickness() {
		return thickness;
	}

	public Color getJacketColor() {
		return jacketColor;
	}

	public void setJacketColor(Color jacketColor) {
		this.jacketColor = jacketColor;
	}

	public String toString(){
		if(wasLitOnFire){
			return "\""+title+"\", by an author whose name you cannot make out. "+numberOfPages+" pages";
		}else return "\""+title+"\", by "+author+". "+numberOfPages+" pages. "+height +" tall. "+thickness;
	}
	
	public String getTitle(){
		return title;
	}
	
	public int getNumberOfPages(){
		return numberOfPages;
	}

	public Person getAuthor() {
		return author;
	}
	
	public void setOnFire(){
		jacketColor=Color.black;
		title = "The title of this book is too charred to make out.";
		wasLitOnFire = true;
	}
	
	public boolean isCheckedOut() {
		return checkedOut;
	}

	public long getCheckOutDate() {
		return checkOutDate;
	}

	public long getDueDate() {
		return dueDate;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public void setCheckOutDate(long checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}
	
	public long getSecondsRemaining(){
		return (long)(dueDate-System.currentTimeMillis())/1000;
	}
}
