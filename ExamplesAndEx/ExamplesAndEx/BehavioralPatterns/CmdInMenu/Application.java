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
import java.util.*;
public class Application {
	private HashMap<String,ICmd> cmdMap = new HashMap<String,ICmd>();
	private LinkedList<ICmd> undoList = new LinkedList<ICmd>();
	
	private static Application  instance = new Application();
	public static Application getInstance() {return instance;}
	
	public void registerCmd(String key, ICmd handler) {
		cmdMap.put(key,handler);
	}
	public void showCmds() {
		Set<Map.Entry<String, ICmd>> mySet= this.cmdMap.entrySet();
		Iterator<Map.Entry<String, ICmd>> it = mySet.iterator();
		while (it.hasNext() ){
			System.out.println("Command: " + ((it.next())).getKey());
		}
	}
	public void execute(String evt) {
		ICmd cmd =  cmdMap.get(evt);
		if (cmd != null) {

			// Please note: there is an error here. What should be done
			// in order to save the right command? (hint: we use prototype
			// of commands here).
			
			undoList.add(cmd);
			
			cmd.execute();
		}
	
	}
	public void undo() {
		if (this.undoList.size()<1) return;
		
		ICmd cmd = (ICmd) undoList.removeLast();
		if (cmd != null)
			cmd.undo();
	}
	

}
