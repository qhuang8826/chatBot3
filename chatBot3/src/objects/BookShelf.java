package objects;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;

public class BookShelf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person author1 = new Person("Noah","Webster");
		Person author2 = new Person("Anthony","Burgess");
		Person author3 = new Person("Philip","K.","Dick");
		Book book1 = new Book("Dictionary",1001,author1);
		Book book2 = new Book("A Clockwork Orange",749,author2);
		Book book3 = new Book("Do Androids Dream of Electric Sheep?",500,author3);
		book2.setJacketColor(new Color(54,236,182));
		book1.setJacketColor(Color.cyan);
		book3.setJacketColor(Color.green);

		ArrayList<Book> shelf = new ArrayList<Book>();
		shelf.add(book1);
		shelf.add(book2);
		shelf.add(book3);
		Book book4 = new Book("The Man in the High Castle",600,author3);
		Book book5 = new Book("Minority Report",589,author3);
		book4.setJacketColor(Color.red);
		book5.setJacketColor(Color.yellow);
		shelf.add(0,book4);
		shelf.add(0,book5);
		
		ArrayList<Person> libraryCardHolders = new ArrayList<Person>();
		libraryCardHolders.add(author1);
		libraryCardHolders.add(author2);
		libraryCardHolders.add(author3);
		
		printAll(shelf);
		
		Library lib = new Library(shelf, libraryCardHolders);//use "books" or "shelf" whatever your ArrayList is 

		lib.setSize(new Dimension(1000,500));

		lib.setVisible(true);

		lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void sortByAuthor(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		        if(ascending){
		        	return a.getAuthor().getLastName().compareTo(b.getAuthor().getLastName());
		        }
		        return b.getAuthor().getLastName().compareTo(a.getAuthor().getLastName());
		    }
		});
	}
	
	public static void sortByPageNumber(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		    	if(ascending)return a.getNumberOfPages() - b.getNumberOfPages();
		    	return b.getNumberOfPages() - a.getNumberOfPages();
		    }
		});
	}
	
	public static void sortByHeight(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		        if(ascending)return a.getHeight() - b.getHeight();
		        return b.getHeight() - a.getHeight();
		    }
		});
	}
	
	public static void sortByTitle(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		    	if(ascending)return a.getTitle().compareTo(b.getTitle());
		    	return b.getTitle().compareTo(a.getTitle());
		    }
		});
	}

	private static void arrayListStuff(ArrayList<Book> shelf){
		/**
		 * "<Book>" is a generic type. It tells the constructor WHAT is in the ArrayList. 
		 * 		We use generics to save ourselves the trouble of type-casting
		 * "new ArrayList<?>()" constructor doesn't need to specify length. 
		 * 		default is 10, but it adjusts as you add objects to it
		 * note that ArrayList IS indexed (item 0 is always at index 0), 
		 * 		therefore you can iterate through it
		 * you cannot make an ArrayList of primitives (no int, boolean, etc)
		 * 		If you wish to make an ArrayList of ints, you use the wrapper class 
		 * 		int is Integer, double is Double, etc
		 */
//		//add things to the ArrayList (remember, for arrays, we did:
//		//array[0] = book1;  specify index
//		shelf.add(book1); //doesn't specify index, book1 is automatically index 0
//		shelf.add(book2);
//		shelf.add(book3);
//		//you can construct at the same time:
//		shelf.add(new Book("The Man in the High Castle",600,author3));
//		
//		//to get something from an ArrayList (recall to get something from array:
//		//System.out.println(array[0]);
//		System.out.println("The first book on the shelf is " +shelf.get(0)); 
//		System.out.println("\n");
//		//LOSE points if you do this wrong!!
//		
//		//iterate through an ArrayList, using for-each
//		for(Book b:shelf)System.out.println(b);
//		
//		//adding Objects at specified indices
//		Book book5 = new Book("Minority Report",589,author3);
//		shelf.add(0,book5);
//		//shelf.remove(book1);
//		//task:remove all books with the word "The" in the title
//		for(int i=0; i<shelf.size(); i++){
//			String tmp = shelf.get(i).toString();
//			String[] tmpA = tmp.split(" ");
//			for(int j=0; j<tmpA.length; j++){
//				if(tmpA[j].toLowerCase().indexOf("the")>-1){	
//					shelf.remove(i);
//				}
//			}
//		}
//		
//		for(int i=0; i<shelf.size(); i++){
//			while(i<shelf.size() && shelf.get(i).toString().indexOf("The")>-1){
//				shelf.remove(i);
//			}
//		}
//		
//		for(int i=shelf.size(); i>-1; i--){
//			if(shelf.get(i).toString().toLowerCase().indexOf("the")>-1){
//				shelf.remove(i);
//			}
//		}
//		// to get the length of ArrayList
//		//recall using arrays:
//		//array.length
//		System.out.println("\nThe length (size) of the shelf is " + shelf.size() + " books\n");//LOSE points
//		
//		//iterate using standard for loop:
//		for(int i=0; i<shelf.size();i++){
//			System.out.println(shelf.get(i));
//		}
//		
//		//identifying whether or not an Object is in the list
//		//getting the index of an Object in an ArrayList
//		if(shelf.contains(book2)){
//			System.out.println(book2.getTitle()+" is book #"+shelf.indexOf(book2)+" on the shelf.\n");
//		}
//		
//		ArrayList<Book> creepyBooks = new ArrayList<Book>();
//		for(int i=0;i<shelf.size();i++){
//			if(shelf.get(i).getAuthor().toString().equals("Philip K. Dick")){
//				creepyBooks.add(shelf.get(i));
//				shelf.get(i).setOnFire();
//			}
//		}
//		printAll(creepyBooks);
//		printAll(shelf);
	}
	
	private static void printAll(ArrayList list){
		for(int i=0; i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
