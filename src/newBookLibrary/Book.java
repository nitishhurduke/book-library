package newBookLibrary;

import java.util.ArrayList;
import java.util.List;

public class Book {
	String bname;
//	String issuer;
	List<String> issuers = new ArrayList<String>();
	List<String> issueHistory = new ArrayList<String>();
	List<String> returnHistory = new ArrayList<String>();
	List<String> bookHistory = new ArrayList<String>();
	
	public void issueHistory(String issueHistory)
	{
		this.issueHistory.add(issueHistory); 
		
	}
	public void returnHistory(String returnHistory)
	{
		this.returnHistory.add(returnHistory); 
		
	}
//	public void bookHistory()
//	{	
//		if(returnHistory.size() == issueHistory.size())
//		{
//			this.bookHistory.add("On "+issueHistory.get(issueHistory.size()-1)+" "+" Issued by "+issuer+" and Returned on "+returnHistory.get(returnHistory.size()-1));
//			
//			issueCount++;
//			returnCount++;
//			bookHistorycount++;
//		}
//		else 
//		{
//			this.bookHistory.add("On "+issueHistory.get(issueHistory.size()-1)+" "+" Issued by "+issuer+" and Not yet Returned");
//		}
//	}
	
}
