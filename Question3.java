package com.main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class books{
	int BookId;
	String Title;
	String Author;
	int NumberOfCopies;
	public books(int bookId, String title, String author, int numberOfCopies) {
		super();
		BookId = bookId;
		Title = title;
		Author = author;
		NumberOfCopies = numberOfCopies;
	}
	@Override
	public String toString() {
		return "books [BookId=" + BookId + ", Title=" + Title + ", Author=" + Author + ", NumberOfCopies="
				+ NumberOfCopies + "]";
	}
	
	
}
public class Question3 {
	public static void main(String[] args) {
		LinkedList<books> bList=new LinkedList<books>();
		int ch;
		do {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter 1 to Add a new book to the list.");
			System.out.println("Enter 2 to Remove a book from the list.");
			System.out.println("Enter 3 to Find all books by a given author.");
			System.out.println("Enter 4 Find all books with fewer than a given number of copies available.");
			System.out.println("Enter your choice : ");
			ch=sc.nextInt();
			
			switch (ch) {
			case 1: 
				
				System.out.println("Enter Id of Book :");
				int id=sc.nextInt();
				System.out.println("Enter title of book : ");
				String name=sc.next();
				System.out.println("Enter Author of Book :");
				String author=sc.next();
				System.out.println("Enter Nuber of copies of book");
				int copies=sc.nextInt();
				bList.add(new books(id, name, author, copies));
				
				
				break;
			
			case 2:
				for (books books : bList) {
					System.out.println(books);
				}
				System.out.println("Enter nama of book you want to remove :");
				String book=sc.next();
				
				boolean flag=false;
				
				Iterator<books> iterator=bList.iterator();
				while (iterator.hasNext()) {
					books books = (books) iterator.next();
					
					if (book.equalsIgnoreCase(books.Title)) {
						iterator.remove();
						flag=true;
						
					}
					
				}
				if (flag) {
					System.out.println("The book "+book+" deleted successfully");
					
				}else {
					System.out.println("Book not found !!");
				}
				break ;
				
			case 3:
				System.out.println("Enter name of author you want to find books");
				String author1=sc.next();
				
				Iterator<books> it2=bList.iterator();
				while (it2.hasNext()) {
					books books = (books) it2.next();
					
					if (author1.equalsIgnoreCase(books.Author)) {
						System.out.println("The "+author1+" this books "+books.Title);
						
					}
				}
				
				break;
				
			case 4:
				System.out.println("Enter number of copies you want to see books less than that copies :");
				int cp=sc.nextInt();
				Iterator<books> it3=bList.iterator();
				
				while (it3.hasNext()) {
					books books = (books) it3.next();
					
					if (books.NumberOfCopies<cp) {
						System.out.println("Name of book is :"+books.Title);
						
					}
					
				}
				break;
				
			case 5:
				System.out.println("Exit !!!!!");
				break;
			default:
				break;
			}
			
		} while (ch!=5);
		
	}
}
