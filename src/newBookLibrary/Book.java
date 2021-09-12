package newBookLibrary;

import java.util.ArrayList;
import java.util.List;

public class Book {
	String bname;
	String[]issueHistory;
	String[]returnHistory;
	String[]bookHistory;
	String issuer;
	static int issueCount;
	static int returnCount;
	
	public void issueHistory(String issueHistory)
	{
		this.issueHistory[issueCount] = issueHistory; 
		issueCount++;
	}
	public void returnHistory(String returnHistory)
	{
		this.returnHistory[returnCount] = returnHistory; 
		returnCount++;
	}
}
