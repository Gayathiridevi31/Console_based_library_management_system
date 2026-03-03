package bean;
import java.time.LocalDate;
import java.util.*;

public class BorrowRecord {
	private int BookID;
	private LocalDate borrowDate;
	private LocalDate dueDate;
	public BorrowRecord(int bookID) {
		super();
		BookID = bookID;
		this.borrowDate = LocalDate.now();
		this.dueDate = LocalDate.now().plusDays(7);  
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public LocalDate getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	

}
