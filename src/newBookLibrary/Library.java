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

		System.out.println("  *ADD BOOKS* ");
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
		System.out.println("  *ALL REGISTERED MEMBERS* ");
		if (members.size() > 0) {
			System.out.println("Id  |  Name  |  mobile no  |  Addhaar no  |  Address ");
			for (Members m : members) {
				System.out.println(m.id + " | " + m.mname + " | " + m.mob + " | " + m.adhar + " | " + m.address);

			}

			subMenu();
		} else {
			System.out.println("No Registered Members Available to Show");
			System.out.println("Enter '1' to Add Members or '0' to Main Menu");
			int in = sc.nextInt();
			switch (in) {
			case 1:
				addMembers();
				break;
			case 0:
				mainMenu();
				break;
			}
		}
	}

	public void bookShelf() {
		System.out.println("  *ALL BOOKS RECORD* ");
		if (books.size() > 0) 
		{
			int i = 1;
			for (Book b : books) 
			{
				System.out.println(i + ". " + b.bname);
				i++;
			}
			System.out.println("Choose a Book from list to get Issue History or Enter '0' to Main Menu");
			int input = sc.nextInt();
			if (input == 0) 
			{
				mainMenu();
			} else {
				Book b1 = books.get(input - 1);
				System.out.println("Book Name : " + b1.bname);

				if (b1.bookHistory.size() > 0) {
					for (String s : b1.bookHistory) {
						System.out.println(s);
					}
				}
				subMenu();
			}
		} else {
			System.out.println("No Books Available to show");
			System.out.println("Enter '1' to Add Books or '0' to Main Menu");
			int in = sc.nextInt();
			switch (in) {
			case 1:
				addBook();
				break;
			case 0:
				mainMenu();
				break;
			}
		}

	}

	public void issueBook() {
		System.out.println("  *ISSUE BOOK*  ");
		System.out.print("Please enter book name :");
		Scanner s = new Scanner(System.in);
		String bname = s.nextLine();// Taking Book Name
		int index = bookList.indexOf(bname);// getting Index of book in bookList
		if (index == -1) {// -1 indicates book is not available
			System.out.println("Invalid Book");
			issueBook();
		} else {
			Book b = books.get(index);// If book available select book object

			if (b.issueHistory.size() == b.returnHistory.size()) // Checking if book available or already issued
			{
				System.out.println("Book " + bname + " available in BookShelf and can be issued..");
				System.out.print("Enter Issuers Name :");
				Scanner s1 = new Scanner(System.in);
				String issuer = s1.nextLine();// Getting Issuers name

				int index1 = membersList.indexOf(issuer);// Checking if issuer a listed member
				if (index1 == -1) {// -1 indicates issuer not a member
					System.out.println("\nNo registered member found with name '" + issuer + "'");
					System.out.println("\nEnter '1' to Register New Member or'2' to Continue Issue '0' to Main Menu");
					int in = sc.nextInt();
					switch (in) {
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

				} else {
					Members m = members.get(index1);

					b.issuers.add(m.mname);
					int idx = b.issuers.indexOf(m.mname);// Getting index of Issuer which will be same for issueHistory
															// and returnHistory
					Date currentDate = new Date();
					String date = DateFormat.getInstance().format(currentDate);
					b.issueHistory(date);
					b.bookHistory.add("Issued on " + date + " by " + b.issuers.get(idx) + " and NOT yet Returned");
					System.out.println("book " + b.bname + " Successfully issued to " + b.issuers.get(idx));

				}
			} else {
				System.out.println("Book is Already issued and hence not Available");
				issueBook();
			}

		}

		subMenu();
	}

	public void returnBook() {
		System.out.println("  *RETURN BOOK* ");
		System.out.print("Please enter book name :");
		Scanner s = new Scanner(System.in);
		String bname = s.nextLine();// Taking Book Name
		int index = bookList.indexOf(bname);// getting Index of book in bookList
		if (index == -1) {// -1 indicates book is not available
			System.out.println("Invalid Book");
			subMenu();
		} else {
			Book b = books.get(index);// If book available select book object
			if (b.issueHistory.size() <= b.returnHistory.size()) {
				System.out.println("Book " + bname + " is Already in BookShelf");
				subMenu();
			} else {
				System.out.print("Confirm Issuers Name :");
				Scanner s1 = new Scanner(System.in);
				String issuer = s1.nextLine();// Getting Issuers name
				String lastIssuer = b.issuers.get(b.issuers.size() - 1);// Getting Last Issuer of the same Book
				if (issuer.equals(lastIssuer)) { // Checking if Last Issuer is same as Returning person
					Date currentDate = new Date();
					String date = DateFormat.getInstance().format(currentDate);
					b.returnHistory(date);
					System.out.println("book " + b.bname + " Successfully returned from " + issuer);
					b.bookHistory.remove(b.bookHistory.size() - 1);
					b.bookHistory.add("Issued on " + b.issueHistory.get(b.issueHistory.size() - 1) + " by " + issuer
							+ " and returned on " + date);
				} else {
					System.out.println("The Book last Issued by '" + lastIssuer + "' and NOT by '" + issuer
							+ "' Please check again ");
					System.out.println(issuer + " " + issuer.length());
					System.out.println(lastIssuer + " " + lastIssuer.length());

				}
			}
		}
		subMenu();
	}

	public void mainMenu() {
		System.out.println("Choose following operation : ");
		System.out.println("1.Show Book Records");
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
		System.out.println("  *DELETE BOOK* ");
		System.out.print("Please enter book name :");
		Scanner s = new Scanner(System.in);
		String bname = s.nextLine();// Taking Book Name
		int index = bookList.indexOf(bname);// getting Index of book in bookList
		if (index == -1) {// -1 indicates book is not available
			System.out.println("Invalid Book");

		} else {
			Book b = books.get(index);// If book available select book object
//			String issued = b.bookHistory.get(b.bookHistory.size()-1);
			if (bname.equals(b.bname))// checks if we have selected correct Book Object
			{
				if(b.issueHistory.size() == b.returnHistory.size()) {
					books.remove(index);
					bookList.remove(index);
					System.out.println("Book '" + bname + "' Deleted Successfuly...");
					
				}else{
					System.out.print("'"+bname+"' "+b.bookHistory.get(b.bookHistory.size()-1));
					System.out.println(" and hence can NOT be deleted until it returns to Shelf.");
				}
			}
		}
		subMenu();

	}

	public void deleteMember() {
		System.out.println("  *DELETE MEMBER* ");
		System.out.print("Please enter member name :");
		Scanner s = new Scanner(System.in);
		String mname = s.nextLine();// Taking Member's Name
		int index = membersList.indexOf(mname);// getting Index of member in membersList
		if (index == -1) {// -1 indicates member is not available
			System.out.println("No member with name '"+mname+"' Registered in Library.");

		} else {
			Members m = members.get(index);// If Member available select Members object
			if (mname.equals(m.mname))// checks if we have selected correct Member Object
			{	
				members.remove(index); // Remove Member Object from members
				membersList.remove(index);//Remove Members name String from membersList
				System.out.println("Member '" + mname + "' Deleted Successfuly...");
			}
		}
		subMenu();

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
