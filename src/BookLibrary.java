//Book Library  using Array
import java.util.Arrays;
import java.util.Scanner;

public class BookLibrary {
	static String[][] arr;

	public static void main(String[] args) {
		BookLibrary Library = new BookLibrary();
		Library.initializeLibrary();
		Library.displayMenu();
		

	}

	void initializeLibrary() {
		System.out.print("\nHow many books do you want to add : ");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		arr = new String[number][2];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < number; i++) {
			System.out.print((i + 1) + ".");
			arr[i][0]  = sc.nextLine();
			
		}
		System.out.println("Books added successfully...");
		// input.close();
	}

	void showAvailableBooks() {
		
		if (arr.length == 0) {
			System.out.println("No Books Available! Please Add some..");
		} else {
			System.out.println(" All Books :");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(" " + (i + 1) + ".");
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j] == null) {
						arr[i][j] = " - in Shelf";
					}
					System.out.print(arr[i][j] + " ");
				}
				System.out.println("");
			}
		}

	}

	void displayMenu() {
		BookLibrary Library = new BookLibrary();
		Scanner in = new Scanner(System.in);

		System.out.println("\nChoose an Operation from following Menu : ");
		System.out.println("  1.Show All Books");
		System.out.println("  2.Issue Book ");
		System.out.println("  3.Return Book ");
		System.out.println("  4.Add New Book ");
		System.out.println("  5.Delete Book ");

		int choice = in.nextInt();

		switch (choice) {
		case 1:
			Library.showAvailableBooks();
			Library.subMenu();

			break;
		case 2:
			Library.issueBook();
			break;

		case 3:
			Library.returnBook();
			break;
		case 4:
			Library.addNewBook();
			break;
		case 5:
			Library.deleteBook();
			break;
		}
		in.close();
	}

	void issueBook() {
		BookLibrary Library = new BookLibrary();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the name of Issuer : ");
		String name = sc.next();

		System.out.println("Select from following books to issue");
		Library.showAvailableBooks();
		int choice = sc.nextInt();
		if (arr[choice - 1][1] == " - in Shelf") {
			arr[choice - 1][1] = " - " + name;
			System.out.println("Book '" + arr[choice - 1][0] + "' is Successfully issued to '" + name + "'.");
			System.out.println("");
		} else {

			System.out.println("The book NOT AVAILABLE as it is already issued to " + arr[choice - 1][1]);
			System.out.println("Enter '1' to issue other book or '2' for go to Main Menu or'3' to Exit Library");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				issueBook();
				break;
			case 2:
				Library.displayMenu();
				break;
			case 3:
				System.exit(0);
				break;
			}
		}
		// sc.close();
		Library.subMenu();
	}

	void returnBook() {
		BookLibrary Library = new BookLibrary();
		Scanner sc = new Scanner(System.in);

		System.out.println("Which book is to be Returned : ");
		Library.showAvailableBooks();
		int index = sc.nextInt();
		if (arr[index - 1][1] == " - in Shelf") {
			System.out.println("The Book is Already in Shelf, Please Choose another book to be Returned :");
			returnBook();
		} else {
			arr[index - 1][1] = " - in Shelf";

			System.out.println("Book returned successfully");
			Library.subMenu();
		}
		sc.close();
	}

	void addNewBook() {
		BookLibrary Library = new BookLibrary();
		Scanner sc = new Scanner(System.in);

		String[][] newArr = new String[arr.length + 1][2];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				newArr[i][j] = arr[i][j];
			}
		}
		System.out.println("Please enter the book name to be added : ");
		newArr[arr.length][0] = sc.next();
		arr = newArr;
		System.out.println("Book added Successfully..");
//		sc.close();
		Library.subMenu();
	}

	void deleteBook() {
		BookLibrary Library = new BookLibrary();
		Scanner sc = new Scanner(System.in);
		String[][] newArr = new String[arr.length - 1][2];

		System.out.println("Choose the book from below to remove permenantly from library: ");
		Library.showAvailableBooks();
		
		int input = sc.nextInt();
		int index = input - 1;
		if (arr[index][1] == " - in Shelf") {
			if (index > 0) {
				for (int i = 0; i < index; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						newArr[i][j] = arr[i][j];
					}
				}
			}
			if (arr.length > input)
				for (int i = (index + 1); i < arr.length; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						newArr[i - 1][j] = arr[i][j];
					}
				}
			arr = newArr;
			System.out.println("Book Successfully Deleted...");

			Library.subMenu();
		} else {
			System.out.println("The book '" + arr[index][0]
					+ "' is issued and so you can not delete this unless issuer returns it. \n*Issuer's name "
					+ arr[index][1]);		
			System.out.println("try again..");
			
			deleteBook();
		}
		sc.close();
	}

	void subMenu() {
		BookLibrary library = new BookLibrary();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter '1' to go Main Menu or '2' to Exit : ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			library.displayMenu();
			break;
		case 2:
			System.out.println("Closing Library....");
			System.exit(0);
		}
		sc.close();
	}
}
