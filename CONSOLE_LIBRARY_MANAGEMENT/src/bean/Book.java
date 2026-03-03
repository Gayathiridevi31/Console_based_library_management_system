package bean;
import java.util.*;

public class Book {
	private int bookID;
	private String title;
	private String author;
	private int availableCopies;
	private int totalCopies;
	private List<Integer>BorrowedByMembers=new 	ArrayList<>();
	public Book(int bookID, String title, String author, int totalCopies) {
	    this.bookID = bookID;
	    this.title = title;
	    this.author = author;
	    this.totalCopies = totalCopies;
	    this.availableCopies = totalCopies;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAvailableCopies() {
		return availableCopies;
	}
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	public int getTotalCopies() {
		return totalCopies;
	}
	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}
	public void setBorrowedByMembers(List<Integer> borrowedByMembers) {
		BorrowedByMembers = borrowedByMembers;
	}
	public List<Integer> getBorrowedByMembers() {
		return BorrowedByMembers;
	}
	public void increaseCopy() {
		availableCopies++;
	}
	public void decreaseCopy() {
		availableCopies--;
	}
	
	

}
