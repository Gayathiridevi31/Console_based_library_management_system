package bean;

import java.util.*;

public class Member {
    private int memberId;
    private String name;

    private List<BorrowRecord> borrowBooks = new ArrayList<>();
    private int totalBooksBorrowed = 0;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() { return memberId; }
    public String getName() { return name; }

    public List<BorrowRecord> getBorrowBooks() {
        return borrowBooks;
    }

    public int getTotalBooksBorrowed() {
        return totalBooksBorrowed;
    }

    public void incrementTotalBorrowed() {
        totalBooksBorrowed++;
    }
}