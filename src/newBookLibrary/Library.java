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
	List<String> membersList = new ArrayList<String>();
	

	public void initializeLibrary(Library l) {
		System.out.println("How many books do you want to add initialy");
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		addBook(total,l);		
	}

	public void addBook(int total,Library l) {
		System.out.println("Add Books");
		Scanner bin =new Scanner(System.in);
		
		for(int i = 0 ; i< total; i++ )
		{	
			Book b = new Book();
			System.out.print((i+1)+". ");
			b.bname = bin.nextLine(); 
			books.add(b);
			bookList.add(b.bname);
			 		 	
		}
		 System.out.println("Books added Successfully...");
		 System.out.println("Enter '1' to Add another book or '0'to Main Menu");
		 int input = bin.nextInt();
		 switch(input)
		 {
		 case 1: 
			 	addBook(l);
			 	break;
		 case 0:
			 
			 	l.mainMenu(l);
			 	break;
		 }
	}

	public void addBook(Library l) {

		Scanner sc = new Scanner(System.in);
		Scanner bin = new Scanner(System.in);
		
		System.out.println("Add Books");
		System.out.println("How Many Books do you want to add : ");
		int total = sc.nextInt();
	
		for (int i = 0; i < total; i++) 
		{
			Book b = new Book();
			System.out.print((i + 1) + ". ");
			b.bname = bin.nextLine();
			books.add(b);
			bookList.add(b.bname);
					
		}
		 System.out.println("Books added Successfully...");
		 System.out.println("Enter '1' to Add another book or '0'to Main Menu");
		 int input = bin.nextInt();
		 switch(input)
		 {
		 case 1: 
			 	addBook(l);
			 	break;
		 case 0:
			 	
			 	l.mainMenu(l);
			 	break;
		 }
		
		
	}

	public void addMembers(Library l) {
		Members member = new Members(); // Object member of Members class

		Scanner sc = new Scanner(System.in);
		Scanner ad = new Scanner(System.in);

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

		members.add(member); // Adding member object to members ArrayList
		membersList.add(member.mname);
		

		System.out.println("Member Successfully Added...");
		System.out.println(); 
		System.out.println("Enter '1' to Add another member or '0'to Main Menu");
		 int input = sc.nextInt();
		 switch(input)
		 {
		 case 1: 
			 	addMembers(l);
			 	break;
		 case 0:
			 
			 	l.mainMenu(l);
			 	break;
		 }

	}

	public void showMembers(Library l) {
		System.out.println("Id  |  Name  |  mobile no  |  Addhaar no  |  Address ");
		for (Members m : members) {
			System.out.println(m.id + " | " + m.mname + " | " + m.mob + " | " + m.adhar + " | " + m.address);
			
		}
		
		l.subMenu(l);

	}

	public void bookShelf(Library l) {
		
		int i = 1;
		for (Book b : books) {
			System.out.println(i + ". " +b.bname);
			i++;
		}
		l.subMenu(l);
	}
	
	public void issueBook(Library l) {

		System.out.print("Please enter book name :");
		Scanner sc = new Scanner(System.in);
		String bname = sc.nextLine();
		int index = bookList.indexOf(bname);
		if (index == -1) {
			System.out.println("Invalid Book");
			issueBook(l);
		} else {
			Book b = books.get(index);

			System.out.print("Enter Issuers Name :");
			Scanner sc1 = new Scanner(System.in);
			String issuer = sc1.nextLine();

			int index1 = membersList.indexOf(issuer);
			if (index1 == -1) {
				System.out.println("Invalid Issuer");
				issueBook(l);
			}

			else if (b.issueHistory.size() == b.returnHistory.size()) {
				Members m = members.get(index1);

				b.issuer = m.mname;

				System.out.println("Enter date :");
				Date currentDate = new Date();
				String date = DateFormat.getInstance().format(currentDate);
				b.issueHistory(date);

				System.out.println("book " + b.bname + " Successfully issued to " + b.issuer);

			} else {
				System.out.println("Book not Available");
				issueBook(l);
			}

		}
		
		l.subMenu(l);
	}

	public void returnBook() {

	}

	public void mainMenu(Library l) {
		System.out.println("Choose following operation : ");
		System.out.println("1.Show BookShelf of Library");
		System.out.println("2.Show All Registerd Members");
		System.out.println("3.Issue Book");
		System.out.println("4.Return Book");
		System.out.println("5.Add New Books");
		System.out.println("6.Add New Members");
		System.out.println("7.Delete Books");
		System.out.println("8.Delete Members");
		System.out.println("9.Exit");

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

	

		switch (input) {

		case 1:
			l.bookShelf(l);
			break;
		case 2:
			l.showMembers(l);
			break;
		case 3:
			l.issueBook(l);
			break;
		case 4:
			l.returnBook();
			break;
		case 5:
			l.addBook(l);
			break;
		case 6:
			l.addMembers(l);
			break;
		case 7:
			l.deleteBook();
			break;
		case 8: 
			l.deleteMember();
			break;
		case 9:
			System.exit(0);
			break;					
		}
		
	}
	public void deleteBook()
	{
		
		
	}
	public void deleteMember()
	{
		
	}
	public void subMenu(Library l)
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter '1' for 'Main Menu'Or '0' for 'Exit' ");
		int input = sc.nextInt();
		
		switch(input)
		{
			case 1:l.mainMenu(l);
					break;
			case 0:System.exit(0);
					break;		
		}
}

	public static void main(String args[]) {
		Library l = new Library();
		l.initializeLibrary(l);
		l.mainMenu(l);
	}
}
