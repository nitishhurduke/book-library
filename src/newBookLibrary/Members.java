package newBookLibrary;

import java.util.ArrayList;
import java.util.List;

public class Members {
	
	static int mId = 1;
	int id;
	String mname;
	long mob;
	long adhar;
	String address;
	
		List<String>issuedBooks = new ArrayList<String>();
		List<String>memberIssueBook = new ArrayList<String>();
		List<String>memberReturnBook = new ArrayList<String>();
		List<String>memberBookHistory = new ArrayList<String>();

		
		public Members(String mname,long mob,long adhar,String address)
		{
			
			this.mname = mname;
			this.mob = mob;
			this.adhar = adhar;
			this.address = address;
			
		}
		public Members()
		{
			id = mId;
		}
}
