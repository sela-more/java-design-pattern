package cloningStarter;
class Main
{
	public static void main(String args[]) throws CloneNotSupportedException
	{
		PhoneBook source = new PhoneBook();
		source.addPerson(new Person("Name #1", "1234567"));
		source.addPerson(new Person("Name #2", "1234568"));
		source.getPerson("Name #1").addPhoneNumber("9876543");
		
		PhoneBook copy = (PhoneBook)source.clone();
		
		System.out.println("phonebook was cloned\n");
		System.out.println("Source:");
		System.out.println(source);
		System.out.println("Copy:");
		System.out.println(copy);
		
		
		copy.getPerson("Name #1").removePhoneNumber("9876543");
		System.out.println("Source:");
		System.out.println(source);
		System.out.println("Copy:");
		System.out.println(copy);
	}
};