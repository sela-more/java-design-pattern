package proxy.imageBrowser.phase1;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

class ImageListModel extends AbstractListModel 
{
	private ArrayList m_Images = new ArrayList();

	ImageListModel(String sPath) throws InstantiationException
	{
		File f = new File(sPath);
		if ((!(f.exists())) || (!f.isDirectory()))
			throw new InstantiationException("Bad Image Directory Name!");

		String sFiles[] = f.list(new ImageFileFilter());

		for (int i = 0 ; i < sFiles.length ; ++i )
			m_Images.add(new MyImage(sPath, sFiles[i]));

	}
	/********************************************/
	/* JList Model								*/
	/********************************************/

	public Object getElementAt(int index)
	{
		return (MyImage)m_Images.get(index);
	}

	public int getSize()
	{
		return m_Images.size();
	}

	/********************************************/
	/* Images FilenameFilter
	/********************************************/

	static class ImageFileFilter implements FilenameFilter
	{
		public boolean accept(File dir, String name)
		{
			return (name.endsWith(".jpg")||name.endsWith(".gif") || name.endsWith(".jpg") || name.endsWith(".bmp") || name.endsWith(".jepg"));
		}
	};
};