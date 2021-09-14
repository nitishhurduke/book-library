package newBookLibrary;

public class Book {
	String bname;
	String[]issueHistory;
	String[]returnHistory;
	String[]bookHistory;
	String issuer;
	static int issueCount;
	static int returnCount;
	static int bookHistorycount;
	
	public void issueHistory(String issueHistory)
	{
		this.issueHistory[issueCount] = issueHistory; 
		
	}
	public void returnHistory(String returnHistory)
	{
		this.returnHistory[returnCount] = returnHistory; 
		
	}
	public void bookHistory()
	{	
		if(returnCount == issueCount)
		{
			this.bookHistory[bookHistorycount] ="On "+issueHistory[issueCount]+" "+" Issued by "+issuer+" and Returned on "+returnHistory;
			
			issueCount++;
			returnCount++;
			bookHistorycount++;
		}
		else 
		{
			this.bookHistory[bookHistorycount] ="On "+issueHistory[issueCount]+" "+" Issued by "+issuer+" and Not yet Returned";
		}
	}
}
