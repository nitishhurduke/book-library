package newBookLibrary;

public class Members {
	
	static int mId = 1;
	int id;
	String mname;
	long mob;
	long adhar;
	String address;
	String issuedBooks;
	

	
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
