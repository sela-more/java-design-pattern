package objectPool.cmdWrapper;
/*
 * Created on 23/02/2004
 * Examples for Java Design Patterns course
 * (c) Sela-YouNiversity
 */

/**
 * @author didi
 */
public interface ICmd 
{
	public String dir(String sDirectory) throws CmdException;
	public String tree(String sDirectory) throws CmdException;
	public String tree() throws CmdException;
	public String dir() throws CmdException;
	public String cd(String sNewDirectory) throws CmdException;
	public String copy(String sSourceFile, String sDestFile) throws CmdException;
	public String setActiveDrive(char cDrive) throws CmdException;
	public void close() throws CmdException;
	
}