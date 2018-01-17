package commandPhoneBook;
import java.util.*;

//import commandPhoneBookStarter.AbsCommand;
interface AbsCommand 
{
	public void execute(PhoneBook pb);
	
};

interface Undoable {
	public void undo(PhoneBook pb);
}
// other options:
// 1. Marker interface NotUndoable, while the AbsCommand requires implementation
// of both execute and undo, print implements undo in the null way and marks itself
// as NotUndoable
// 2. AbsCommand with 3 methods: execute, undo and bool mayUndo. Print implements
// mayUndo as false, and undo as null implementation

//interface NotUndoable {
//}
//interface AbsCommand 
//{
//	public void execute(PhoneBook pb);
//  public bool mayUndo();
//	public void undo(PhoneBook pb);
//}


class AddPersonCommand implements AbsCommand, Undoable
{
	private String m_sName;
	private String m_sPhoneNumber;
	AddPersonCommand(String sName, String sPhoneNumber)
	{
		m_sName = sName;
		m_sPhoneNumber = sPhoneNumber;
	}
	public void execute(PhoneBook pb)	
	{
		System.out.println("adding " + m_sName);
		pb.addPerson(m_sName, m_sPhoneNumber);
	}

	public void undo(PhoneBook pb)
	{
		pb.removePerson(m_sName);
	}
};

class RemovePersonCommand implements AbsCommand, Undoable
{
	private String m_sName;
	private String m_sPhoneNumber;
	RemovePersonCommand(String sName)
	{
		m_sName = sName;
	}
	public void execute(PhoneBook pb)
	{
		m_sPhoneNumber = pb.getPhoneNumber(m_sName);
		System.out.println("removing " + m_sName);
		pb.removePerson(m_sName);
	}

	public void undo(PhoneBook pb)
	{
		pb.addPerson(m_sName, m_sPhoneNumber);
	}
};


class PrintPhoneBookCommand implements AbsCommand // NotUndoable
{

	public void execute(PhoneBook pb)
	{
		pb.print();
	}

//	public void undo(PhoneBook pb)
//	{
//	}
};

class CommandManager
{
	LinkedList<AbsCommand> m_CommandQueue = new LinkedList<AbsCommand>();
	private PhoneBook m_Book = new PhoneBook();

	public void executeCommand(AbsCommand command)
	{
		command.execute(m_Book);
		if ((command instanceof Undoable))
		//if (command.mayUndo())
        //if (!(command instanceof NotUndoable))
			m_CommandQueue.addLast(command);
	}

	public void undo()
	{
		Undoable cmd = (Undoable)m_CommandQueue.removeLast();
		if (cmd != null)
		{
			cmd.undo(m_Book);
		}
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















