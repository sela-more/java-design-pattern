package compositeDiscussionGroups;

public class Driver {

	public static void main(String[] args) {
		Message m1 = new Message("Important Message","Michal","This is the message body which is very important");
		Message m2 = new Message("Hello","Yosef","Hi there all you java lovers");
		
		Discussion disc1 = new Discussion("disc1");
		disc1.addMessage(m1);
		disc1.addMessage(m2);
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
