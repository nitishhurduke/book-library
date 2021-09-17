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
	Scanner sc = new Scanner(System.in);

	public void initializeLibrary() {
		System.out.println("How many books do you want to add initially");
		
		int total = sc.nextInt();
		addBook(total);
	}

	public void addBook(int total) {
		System.out.println("Add Books");
		Scanner bin = new Scanner(System.in);

		for (int i = 0; i < total; i++) {
			Book b = new Book();
			System.out.print((i + 1) + ". ");
			b.bname = bin.nextLine();
			books.add(b);
			bookList.add(b.bname);

		}
		System.out.println("Books added Successfully...");
		System.out.println("Enter '1' to Add more books or '0'to Main Menu");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			addBook();
			break;
		case 0:

			mainMenu();
			break;
		}
	}

	public void addBook() {

		
		Scanner bin = new Scanner(System.in);

		System.out.println("Add Books");
		System.out.println("How Many Books do you want to add : ");
		int total = sc.nextInt();

		for (int i = 0; i < total; i++) {
			Book b = new Book();
			System.out.print((i + 1) + ". ");
			b.bname = bin.nextLine();
			books.add(b);
			bookList.add(b.bname);

		}
		System.out.println("Books added Successfully...");
		System.out.println("Enter '1' to Add more books or '0'to Main Menu");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			addBook();
			break;
		case 0:

			mainMenu();
			break;
		}

	}

	public void addMembers() {
		Members member = new Members(); // Object member of Members class

		Scanner s = new Scanner(System.in);
		Scanner ad = new Scanner(System.in);

		System.out.println("  *New Member Registration Form* ");
		member.mId += 1;
		System.out.print("Enter Name :");
		member.mname = s.nextLine();
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
		switch (input) {
		case 1:
			addMembers();
			break;
		case 0:

			mainMenu();
			break;
		}

	}

	public void showMembers() {
		System.out.println("Id  |  Name  |  mobile no  |  Addhaar no  |  Address ");
		for (Members m : members) {
			System.out.println(m.id + " | " + m.mname + " | " + m.mob + " | " + m.adhar + " | " + m.address);

		}

		subMenu();

	}

	public void bookShelf() {

		int i = 1;
		for (Book b : books) {
			System.out.println(i + ". " + b.bname);
			i++;
		}
		subMenu();
	}

	public void issueBook() {

		System.out.print("Please enter book name :");
		Scanner s = new Scanner(System.in);
		String bname = s.nextLine();//Taking Book Name
		int index = bookList.indexOf(bname);//getting Index of book in bookList
		if (index == -1) {//-1 indicates book is not available
			System.out.println("Invalid Book");
			issueBook();
		} else {
			Book b = books.get(index);

			System.out.print("Enter Issuers Name :");
			Scanner s1 = new Scanner(System.in);
			String issuer = s1.nextLine();//Getting Issuers name

			int index1 = membersList.indexOf(issuer);//Checking if issuer a listed member
			if (index1 == -1) {//-1 indicates issuer not a member
				System.out.println("\nNo registered member found with name '"+issuer+"'");
				System.out.println("\nEnter '1' to Register New Member or'2' to Continue Issue '0' to Main Menu");
				int in = sc.nextInt();
				switch(in) {
				case 1: 
					addMembers();
					break;
				case 2: 
					issueBook();
					break;
				case 0:
					System.exit(0);
					break;
				}
				
			}

			else if (b.issueHistory.size() == b.returnHistory.size()) {
				Members m = members.get(index1);

				b.issuer = m.mname;

				
				Date currentDate = new Date();
				String date = DateFormat.getInstance().format(currentDate);
				b.issueHistory(date);

				System.out.println("book " + b.bname + " Successfully issued to " + b.issuer);

			} else {
				System.out.println("Book not Available");
				issueBook();
			}

		}

		subMenu();
	}

	public void returnBook() {

	}

	public void mainMenu() {
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

		int input = sc.nextInt();

		switch (input) {

		case 1:
			bookShelf();
			break;
		case 2:
			showMembers();
			break;
		case 3:
			issueBook();
			break;
		case 4:
			returnBook();
			break;
		case 5:
			addBook();
			break;
		case 6:
			addMembers();
			break;
		case 7:
			deleteBook();
			break;
		case 8:
			deleteMember();
			break;
		case 9:
			System.exit(0);
			break;
		}

	}

	public void deleteBook() {

	}

	public void deleteMember() {

	}

	public void subMenu() {
	
		System.out.println("Enter '1' for 'Main Menu'Or '0' for 'Exit' ");
		int input = sc.nextInt();

		switch (input) {
		case 1:
			mainMenu();
			break;
		case 0:
			System.exit(0);
			break;
		}
	}

	public static void main(String args[]) {
		Library l = new Library();
		l.initializeLibrary();
		l.mainMenu();
	}
}
