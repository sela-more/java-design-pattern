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
public class Message extends AbstractGroupElement  {

	
	private String m_body;
	private String m_subject;
	private String m_author;
	
	public Message(String subject, String author, String text){
		super("A Message",2);
		this.m_subject = subject;
		this.m_author = author;
		this.m_body = text;
	}

	/* (non-Javadoc)
	 * @see IMessage#display()
	 */
	
	public void display() {
		display("");
	}
	public void display(String ident){
		
		System.out.println(ident + "Displaying a message:\n " + 
				ident + "\tSuject: " + this.m_subject + "\n" +
				ident + "\tAuthor: " + this.m_author + "\n" +
				ident + "\tBody: " + this.m_body + "\n");
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return("Message:\n" + 
				"\tSuject: " + this.m_subject + "\n" +
				"\tAuthor: " + this.m_author + "\n" +
				"\tBody: " + this.m_body + "\n");
	}
}
