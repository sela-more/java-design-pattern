package decoratorBugRepStarter;
import java.util.LinkedList;
import java.util.Iterator;
interface IBug
{
	public void history();
	public IBug rollBack();
}
class Bug implements IBug
{
	private static int m_nCounter;
	private int m_nID;
	private String m_sDesc;
	private String m_sCreator;
	public int getLevel() { return 0; }
	Bug(String sDesc, String sCreator)
	{
		m_nID = ++m_nCounter;
		m_sDesc = sDesc;
		m_sCreator = sCreator;
	}
	public void history()
	{
		System.out.println("Created by " + m_sCreator + " Description: " + m_sDesc);
	}
	public IBug rollBack() {
		return this;
	}
};
abstract class BugRole implements IBug
{
	//?? Student? What should be in this class?
};
class OpenedBug extends BugRole
{
	private String m_sOpenedBy;
	private LinkedList<String> m_Remarks = new LinkedList<String>();
	public static OpenedBug open(IBug bug, String sName)
	{
		if (bug instanceof OpenedBug)
			return (OpenedBug)bug;
		return new OpenedBug(bug, sName);
	}
	
	private OpenedBug(IBug bug, String sOpenedBy)
	{
		super(bug);
		m_sOpenedBy = sOpenedBy;
	}
	public void addRemark(String sProgrammersName, String sRemark)
	{
		m_Remarks.add("Remark by " + sProgrammersName + ": " + sRemark);
	}
	public void history()
	{
		//?? Student? What else?  Before/After?
		Iterator<String> iter = m_Remarks.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
	
};

class ClosedBug extends BugRole
{
	private String m_sClosedBy;
	public static ClosedBug close(IBug bug, String sManager)
	{
		if (bug instanceof ClosedBug)
			return (ClosedBug)bug;
		return new ClosedBug(bug, sManager);
	}
	private ClosedBug(IBug bug, String sClosedBy) 
	{
		super(bug);
		m_sClosedBy = sClosedBy;
	}
	public String getManagerName()
	{
		return m_sClosedBy;
	}
	public void history()
	{
		// ?? Student? What else? Before? After?
	}
	
};
class Main
{
	public static void main(String args[]) throws Exception
	{
		  IBug bug = new Bug("Not working", "Didi");
		  OpenedBug ob = OpenedBug.open(bug, "Shaul");
		  ob.addRemark("Programmer #1", "fixed");
		  bug = ClosedBug.close(ob, "Manager #1");
		  ob = OpenedBug.open(bug, "Manager #2");
		  bug = ClosedBug.close(ob, "Manager #2");
		  ob = OpenedBug.open(bug, "Manager #3");
		  ob.addRemark("Programmer #2", "fixed");
		  bug = ClosedBug.close(ob,"Manager #3");
		  bug.history();
		  IBug rolledBackBug = bug.rollBack();
		  System.out.println("Type of rolled back bug is: " + rolledBackBug.getClass().getName());
		  rolledBackBug = rolledBackBug.rollBack();
		  System.out.println("Type of rolled back bug is: " + rolledBackBug.getClass().getName());
		  System.out.println("printing the history of a bug rolled back twice");
		  rolledBackBug.history();
	}
};







