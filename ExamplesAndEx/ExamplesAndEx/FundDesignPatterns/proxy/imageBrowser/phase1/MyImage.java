package proxy.imageBrowser.phase1;
import javax.swing.ImageIcon;



class MyImage implements IMyImage
{
	private ImageIcon m_Image;
	private String m_sName;

	MyImage(String sPath, String sFileName)
	{
		m_sName = sFileName;
		m_Image = new ImageIcon(sPath + sFileName);
	}

	public String toString()
	{
		return m_sName;
	}

	public ImageIcon getImage()
	{
		return m_Image;
	}
};