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
public class Driver {
	static {
		try {
			Class.forName("CmdInMenu.AddOneCmd");
		}
		catch (Exception e) {
			
		}
	}

	public static void main(String[] args) {
		
		Application.getInstance().showCmds();
		Application.getInstance().execute("AddOne");
		Application.getInstance().undo();
		Application.getInstance().execute("AddOne");
		Application.getInstance().execute("AddOne");
		Application.getInstance().execute("AddOne");
		Application.getInstance().undo();
		Application.getInstance().undo();
		Application.getInstance().undo();
		Application.getInstance().undo();
		Application.getInstance().undo();
		
	}
}
