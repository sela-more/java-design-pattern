package objectPool.cmdWrapper;
/*
 * Created on 23/02/2004
 * Examples for Java Design Patterns course
 * (c) Sela-YouNiversity
 */

/**
 * @author didi
 */
public class PooledCmd implements ICmd {
	ICmd m_RealObject;
	PooledCmd() throws CmdException
	{
		m_RealObject = CmdPool.getInstance().aquireCmd();
	}

	public String dir(String sDirectory) throws CmdException {
		return m_RealObject.dir(sDirectory);
	}

	public String tree(String sDirectory) throws CmdException {
		return m_RealObject.tree(sDirectory);
	}

	public String tree() throws CmdException {
		return m_RealObject.tree();
	}

	public String dir() throws CmdException {
		return m_RealObject.dir();
	}

	public String cd(String sNewDirectory) throws CmdException {
		return m_RealObject.cd(sNewDirectory);
	}

	public String copy(String sSourceFile, String sDestFile)
		throws CmdException {
		return m_RealObject.copy(sSourceFile, sDestFile);
	}
	
	public String setActiveDrive(char cDrive) throws CmdException
	{
		return m_RealObject.setActiveDrive(cDrive);
	}


	public void close() {
		CmdPool.getInstance().releaseCmd(m_RealObject);
		m_RealObject = null;
	}
	
	public void finalize()
	{
		if (m_RealObject != null)
			close();
	}

}
