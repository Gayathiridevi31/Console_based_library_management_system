package Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import bean.Book;
import bean.BorrowRecord;
import bean.Member;

public class LibraryService {
	private Map<Integer,Book>books=new HashMap<>();
	private Map<Integer,Member>members=new HashMap<>();
	public void addBook(int id,String title,String author,int copies)
	{
		if(books.containsKey(id))
		{
			System.out.println("book id already exist");
			return;
		}
	    books.put(id,new Book(id,title,author,copies));
	    System.out.println("book added successfully");
	}
	public void registerMember(int memberId,String name)
	{
		if(members.containsKey(memberId))
		{
			System.out.println("member id already exist");
			return;
		}
		members.put(memberId,new Member(memberId,name));
		System.out.println("member registered successfully");
	}
	public void borrowBook(int memberId, int bookId)
	{
	    if(!members.containsKey(memberId) || !books.containsKey(bookId))
	    {
	        System.out.println("Book ID or Member ID not found");
	        return;
	    }
	    Member member = members.get(memberId);
	    Book book = books.get(bookId);

	    if(member.getBorrowBooks().size() >= 3)
	    {
	        System.out.println("A member can't borrow more than 3 books");
	        return;
	    }
	    if(book.getAvailableCopies() <= 0)
	    {
	        System.out.println("No copies available");
	        return;
	    }
	    for(BorrowRecord br : member.getBorrowBooks())
	    {
	        if(br.getBookID() == bookId)
	        {
	            System.out.println("You already borrowed this book");
	            return;
	        }
	    }

	    BorrowRecord record = new BorrowRecord(bookId);
	    member.getBorrowBooks().add(record);
	    member.incrementTotalBorrowed();  
	    book.decreaseCopy();
	    book.getBorrowedByMembers().add(memberId);
	    System.out.println("Book borrowed successfully");
	}
	public void returnBook(int memberId,int bookId)
	{
		if(!members.containsKey(memberId) || !books.containsKey(bookId))
		{
			System.out.println("bookid and member id not found");
			return;
		}
		Member member=members.get(memberId);
		Book book=books.get(bookId);
		BorrowRecord found=null;
		for(BorrowRecord br:member.getBorrowBooks())
		{
			if(br.getBookID()==bookId)
			{
				found=br;
			}
		}
		if(found==null)
		{
			System.out.println("books is not borrowed");
			return;
		}
		 long overdueDays = ChronoUnit.DAYS.between(found.getDueDate(), LocalDate.now());
	        if (overdueDays > 0) {
	            System.out.println("Fine: Rs." + (overdueDays * 2));
	        }

	        member.getBorrowBooks().remove(found);
	        book.increaseCopy();
	        book.getBorrowedByMembers().remove(Integer.valueOf(memberId));

	        System.out.println("Book returned successfully!");
		
		
	}
	public void searchBook(String keyword)
	{
		for(Book book:books.values())
		{
			if(book.getTitle().toLowerCase().contains(keyword.toLowerCase()) || book.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
			{
				System.out.println(book.getBookID()+" "+book.getTitle());
				
			}
			
		}
	}
	public void memberReport(int memberId)
	{
	    Member member = members.get(memberId);

	    if(member == null)
	    {
	        System.out.println("Member not found");
	        return;
	    }

	    for(BorrowRecord br : member.getBorrowBooks())
	    {
	        System.out.println("Book ID: " + br.getBookID() +
	                " | Borrow Date: " + br.getBorrowDate() +
	                " | Due Date: " + br.getDueDate());
	    }
	}
	public void bookReport(int bookId)
	{
		Book book=books.get(bookId);
		  if (book == null) {
	            System.out.println("Book not found!");
	            return;
	        }

	        System.out.println("Available Copies: " + book.getAvailableCopies());
	        System.out.println("Borrowed by Members: " + book.getBorrowedByMembers());
		
	}
	public void topBorrowers() {
		List<Member>list=new ArrayList<>(members.values());
		list.sort((a,b)->b.getTotalBooksBorrowed()-a.getTotalBooksBorrowed());
		for(Member m:list)
		{
			System.out.println(m.getName() +" - "+m.getTotalBooksBorrowed());
		}
	}
	
	

}
