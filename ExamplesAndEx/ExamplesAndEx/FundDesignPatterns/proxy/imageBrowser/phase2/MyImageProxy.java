package proxy.imageBrowser.phase2;
import javax.swing.ImageIcon;
import java.lang.ref.SoftReference;
class MyImageProxy implements IMyImage
{
	IMyImage m_Impl;

	private String m_sName;
	private String m_sPath;

	MyImageProxy(String sPath, String sFileName)
	{
		m_sName = sFileName;
		m_sPath = sPath;
	}

	public String toString()
	{
		return m_sName;
	}

	public ImageIcon getImage()
	{	
		if (m_Impl == null)
			m_Impl = new MyImageImpl(m_sPath, m_sName);
		return m_Impl.getImage();
	}
};

















	/*	Object o;
		if ((m_Impl == null) || ((o = m_Impl.get()) == null))
			m_Impl = new SoftReference((o = new MyImageImpl(m_sPath, m_sName)));

	
		return ((IMyImage)o).getImage();
	*/
