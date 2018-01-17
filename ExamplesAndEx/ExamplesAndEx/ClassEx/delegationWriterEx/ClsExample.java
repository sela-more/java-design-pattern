package delegationWriterEx;
import java.lang.reflect.*;
class LogException extends Exception
{
};
interface IWriter 
{
	public void writeLine(String sLine) throws LogException;
	public void close() throws LogException; // could also use Closeable from 1.7
}

class ConsoleWriter implements IWriter
{
	public void writeLine(String sLine)
	{
		System.out.println(sLine);
	}
	public void close() {}
};

class FileSystemWriter implements IWriter
{
	private java.io.BufferedWriter m_Writer;
	FileSystemWriter(String sFileName) throws LogException
	{
		try {
			m_Writer = new java.io.BufferedWriter(new java.io.FileWriter(sFileName));
		}
		catch(java.io.IOException e)
		{
			e.printStackTrace();
			throw new LogException();
		}
	}
	public void writeLine(String sLine) throws LogException
	{
		try
		{
			m_Writer.write(sLine);
			m_Writer.newLine();
		}
		catch (java.io.IOException e)
		{
			e.printStackTrace();
			throw new LogException();
		}
	}
	public void close() throws LogException
	{
		try {
			m_Writer.close();
		}
		catch(java.io.IOException e)
		{
			e.printStackTrace();
			throw new LogException();
		}
	}
};




class TextObjectWriter
{
	private IWriter m_Writer;

	TextObjectWriter(IWriter writer)
	{
		m_Writer=writer;
	}

	public void setWriter(IWriter newWriter) {
			m_Writer = newWriter;
	}
	

	protected String getPrivilage(int nMod)
	{
		if (Modifier.isPublic(nMod)) return "Public";
		if (Modifier.isPrivate(nMod)) return "Private";
		if (Modifier.isProtected(nMod)) return "Protected";
		return "Package";
	}
	public void print(String str) throws LogException {
		m_Writer.writeLine(str);
	}
	public void writeObject(Class<?> c) throws LogException
	{

			Field fields[] = c.getDeclaredFields();
			m_Writer.writeLine(c.getName() + ": ");
			for (int i = 0 ; i < fields.length ; ++i)
			{
				fields[i].setAccessible(true);
				m_Writer.writeLine("\tName = " + fields[i].getName());
				m_Writer.writeLine("\t\ttype = " + fields[i].getType().getName());
				m_Writer.writeLine("\t\tstatic = " + Modifier.isStatic(fields[i].getModifiers()));
				m_Writer.writeLine("\t\tAccessPrivilage = " + getPrivilage(fields[i].getModifiers()));
			}
	}

	public void close() throws LogException
	{
		m_Writer.close();
	}
};


class Main
{
	public int field1;
	
	public static void main(String args[]) throws Exception
	{
//		if (args.length<1) {
//			System.out.println("Please indicate a class name");
//			return;
//		}
		TextObjectWriter ow = new TextObjectWriter(new FileSystemWriter("temp.txt"));
		ow.print("hi there");
		//ow.writeObject(Class.forName(args[0]));
		ow.close();
		ow.setWriter(new ConsoleWriter());
		//ow.writeObject(Class.forName(args[0]));
		ow.print("hi there again");

	}
};