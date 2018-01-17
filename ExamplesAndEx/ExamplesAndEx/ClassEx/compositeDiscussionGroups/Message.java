package compositeDiscussionGroups;

public class Message implements IDisplayable  {

	private String m_body;
	private String m_subject;
	private String m_author;
	
	public Message(String subject, String author, String text){
		this.m_subject = subject;
		this.m_author = author;
		this.m_body = text;
	}

	
	public void display() {
		display("");
	}
	public void display(String ident){
		
		System.out.println(ident + "Displaying a message:\n " + 
				ident + "\tSuject: " + this.m_subject + "\n" +
				ident + "\tAuthor: " + this.m_author + "\n" +
				ident + "\tBody: " + this.m_body + "\n");
		
	}

	public String toString() {
		return("Message:\n" + 
				"\tSuject: " + this.m_subject + "\n" +
				"\tAuthor: " + this.m_author + "\n" +
				"\tBody: " + this.m_body + "\n");
	}
}
