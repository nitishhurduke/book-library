package newBookLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;

public class Library {
	
	ArrayList<Book> books = new ArrayList<Book>();
	List<String> bookList = new ArrayList<String>();
	ArrayList<Members> members = new ArrayList<Members>();
	List<String>membersList = new ArrayList<String>();
	
	public void initializeLibrary()
	{ 
		System.out.println("How many books do you want to add initialy");
		Scanner sc =new Scanner(System.in);
		int total = sc.nextInt();
		addBook(total);
	}


	public void addBook(int total) {
		System.out.println("Add Books");
		Scanner bin =new Scanner(System.in);
		for(int i = 0 ; i< total; i++ )
		{
			Book b = new Book();
			
			System.out.print((i+1)+". ");
			b.bname = bin.nextLine(); 
			 bookList.add(b.bname);
			 books.add(b);	
		}
	}


	public void addMembers()
	{	
		Members member = new Members(); // Object member of Members class
		
		Scanner sc =new Scanner(System.in);
		Scanner ad =new Scanner(System.in);
		
		System.out.println("  *New Member Registration Form* ");
		member.mId += 1;
		System.out.print("Enter Name :");
		member.mname = sc.nextLine();
		System.out.print("Enter Mobile number: ");
		member.mob = sc.nextLong();
		System.out.print("Enter Email Address : ");
		member.address = ad.nextLine();	
		System.out.print("Enter Aadhaar Number : ");
		member.adhar = sc.nextLong();

		
		membersList.add(member.mname);
		members.add(member); //Adding member object to members ArrayList
		
		System.out.println("Member Successfully Added...");
		
	}


	public void showMembers() 
	{
		System.out.println("Id  |  Name  |  mobile no  |  Addhaar no  |  Address ");
		for (Members m : members) {
			System.out.println(m.id+" | "+m.mname+" | "+m.mob+" | "+m.adhar+" | "+m.address);
		
		}	
	
	}
	public void bookShelf() {
		int i = 1;
		for(Book b : books) 
		{	
			if(b.issuer != null) {
			System.out.println(i+". "+b.bname+" "+b.issuer);
			
			}else{
				System.out.println(i+". "+b.bname);
			}
			 i++;
		}
	}

//	public void issueBook() 
//	{
//		System.out.println("Select Issuer from Library Members");
//	}
	public void issueBook() 
	{	
			
			System.out.print("Please enter book name :");
			Scanner sc = new Scanner(System.in);
			String bname = sc.nextLine();
			int index = bookList.indexOf(bname);
			if(index == -1)
			{
				System.out.println("Invalid Book");
				issueBook();
			}
			else 
			{
				Book b = books.get(index);
				
				System.out.print("Enter Issuers Name :");
				Scanner sc1 = new Scanner(System.in);
				String issuer = sc1.nextLine();
				
				int index1  = membersList.indexOf(issuer);
				if(index1 == -1)
				{
					System.out.println("Invalid Issuer");
					issueBook();
				}
				else 
				{
					Members m = members.get(index1);
					
					b.issuer = m.mname;
					
					Date currentDate = new Date();
	
					String date = DateFormat.getInstance().format(currentDate);				
					
					b.issueHistory(date);
					
					System.out.println("book "+b.bname+" Successfully issued to "+b.issuer);
					
				}
				
			}							
	}
		
	public static void main(String args[])
	{
		Library lib = new Library();
		lib.initializeLibrary();
		lib.addMembers();
		lib.addMembers();
//		lib.bookShelf();
		lib.issueBook();
		lib.bookShelf();		
//		lib.showMembers();
		
//		lib.showMembers();
	}
}
