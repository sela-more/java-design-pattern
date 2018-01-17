package iterator.tableCreator;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		PhoneBook book = new PhoneBook(10);
		TableCreator table = new TableCreator(book);
		FileWriter writer = new FileWriter("out.html");
		writer.write(table.toString());
		writer.close();
	}
}