/*
 * Created on 23/01/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package CmdInMenu;

/**
 * @author clsc1
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AddOneCmd implements ICmd {

	/* (non-Javadoc)
	 * @see CmdInMenu.ICmd#execute()
	 */
	static {
		Application.getInstance().registerCmd("AddOne",new AddOneCmd());
	}
	private int currentSum=0;
	public void execute() {
		currentSum++;
		System.out.println("CurrentSum is: " + currentSum);

	}

	/* (non-Javadoc)
	 * @see CmdInMenu.ICmd#undo()
	 */
	public void undo() {
		currentSum--;
		System.out.println("CurrentSum is: " + currentSum);

	}

}
