package newBookLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
	
	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<Members> members = new ArrayList<Members>();
	
	public void initializeLibrary()
	{ 
		System.out.println("How many books do you want to add initialy");
		Scanner sc =new Scanner(System.in);
		int total = sc.nextInt();
		//ArrayList<Book> book = new ArrayList<Book>();
		
		System.out.println("Add Books");
		Scanner bin =new Scanner(System.in);
		for(int i = 0 ; i< total; i++ )
		{
			Book b = new Book();
			
			System.out.print((i+1)+". ");
			b.bname = bin.nextLine();
			
			 books.add(b);			
		} 	
	}	
	public void bookShelf() {
		int i = 1;
		for(Book b : books) 
		{	
		System.out.println(i+". "+b.bname);
		i++;
		}
	}
	public void addMembers()
	{	
		Members member = new Members();
		Scanner sc =new Scanner(System.in);
		Scanner ad =new Scanner(System.in);
		System.out.println("  *New Member Registration Form* ");
		member.mId += 1;
		System.out.print("Enter Name :");
		member.mname = sc.nextLine();
		System.out.print("Enter Mobile number: ");
		member.mob = sc.nextLong();
		System.out.print("Enter Aadhaar Number : ");
		member.adhar = sc.nextLong();
		System.out.print("Enter Address : ");
		member.address = ad.nextLine();	
		
		members.add(member);
		
		System.out.println("Member Successfully Added...");
		
	}
	public void showMembers() 
	{
		System.out.println("Id  |  Name  |  mobile no  |  Addhaar no  |  Address ");
		for (Members m : members) {
			System.out.println(m.id+" | "+m.mname+" | "+m.mob+" | "+m.adhar+" | "+m.address);
		}	
	}
	
	
	public static void main(String args[])
	{
		Library lib = new Library();
//		lib.initializeLibrary();
//		lib.bookShelf();
		
		lib.addMembers();
		lib.addMembers();
		lib.showMembers();
	}
}
