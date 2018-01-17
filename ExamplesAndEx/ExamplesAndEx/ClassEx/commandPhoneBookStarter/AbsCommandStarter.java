package commandPhoneBookStarter;
import java.util.*;
interface AbsCommand 
{
	public void execute(PhoneBook pb);
	public void undo(PhoneBook pb);
};





class CommandManager
{
	LinkedList<AbsCommand> m_CommandQueue = new LinkedList<AbsCommand>();
	private PhoneBook m_Book = new PhoneBook();

	public void executeCommand(AbsCommand command)
	{
		//studnet
	}

	public void undo()
	{
		//student
	}
};

class PhoneBook
{
	private HashMap<String,String> m_Persons = new HashMap<String,String>();
	public void addPerson(String sName, String sPhone)
	{
		m_Persons.put(sName, sPhone);
	}

	public void removePerson(String sName)
	{
		m_Persons.remove(sName);
	}

	public String getPhoneNumber(String sName)
	{
		return m_Persons.get(sName);
	}

	public void print()
	{
		Iterator<Map.Entry<String,String>>iter = m_Persons.entrySet().iterator();
		while(iter.hasNext())
		{
			Map.Entry<String,String> entry = iter.next();
			System.out.println(entry.getKey() + "\t\t" + entry.getValue());
		}
	}
};

class Main
{
	public static void main(String args[])
	{
		CommandManager manager = new CommandManager();
		manager.executeCommand(new AddPersonCommand("Person A", "11111"));
		manager.executeCommand(new AddPersonCommand("Person B", "2222"));
		manager.executeCommand(new AddPersonCommand("Person C", "3333"));
		manager.executeCommand(new AddPersonCommand("Person D", "444444"));
		
		System.out.println("\nThe full list:");
		manager.executeCommand(new PrintPhoneBookCommand());
		manager.executeCommand(new RemovePersonCommand("Person A"));

		System.out.println("\nAfter removing a person:");
		manager.executeCommand(new PrintPhoneBookCommand());
		
		manager.undo();
		System.out.println("\nAfter undo of last command:");
		manager.executeCommand(new PrintPhoneBookCommand());

	}
};















