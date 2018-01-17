package delegation.phoneBook;
class Main
{
	public static void main(String args[])
	{
		PhoneBook pb = new PhoneBook();  
		pb.addEntry("LaLALA", "12345");
		pb.addEntry("Susan", "12345");
		pb.addEntry("David", "34564");
		pb.addEntry("Michel", "45678");
		pb.print();
		pb.setSortedMode(); 
		pb.print();
	}
};