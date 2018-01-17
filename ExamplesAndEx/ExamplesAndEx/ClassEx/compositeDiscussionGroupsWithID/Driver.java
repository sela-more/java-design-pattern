package compositeDiscussionGroupsWithID;
/*
 * Created on 28/09/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author clsd1
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Driver {

	/**
	 * 
	 */
	public static void main(String[] args) {
		Message m1 = new Message("Important Message","Michal","This is the message body which is very important");
		Message m2 = new Message("Hello","Yosef","Hi there all you java lovers");
		
		Discussion disc1 = new Discussion("disc1");
		disc1.add(m1);
		disc1.add(m2);
		disc1.add(disc1); // should not agree to do so
		//disc1.display();
		
		Group g1 = new Group("g1");
		g1.add(disc1);
		//g1.display();
		Group g2 = new Group("g2");
		g2.add(g1);
		g2.add(g1);
		g2.add(disc1);
		//g2.display();
		
		Group g3 = new Group("g3");
		g3.add(g2);
		g3.display();
	}
}
