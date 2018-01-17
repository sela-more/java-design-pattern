package proxy.imageBrowser.phase2;
import javax.swing.ImageIcon;

class MyImageImpl implements IMyImage
{
	ImageIcon m_Icon;

	MyImageImpl(String sPath, String sFileName)
	{
		m_Icon = new ImageIcon(sPath + sFileName);
	}

	public ImageIcon getImage()
	{
		return m_Icon;
	}
};