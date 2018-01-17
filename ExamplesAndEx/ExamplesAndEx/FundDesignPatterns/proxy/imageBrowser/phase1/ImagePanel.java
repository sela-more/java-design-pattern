package proxy.imageBrowser.phase1;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.GridLayout;
class ImagePanel extends JPanel
{
	private ImageListModel	m_ListModel;
	private JLabel			m_ImageLabel;
	private JList			m_ImageList;

	ImagePanel(String sPath) throws InstantiationException 
	{
		setLayout(new GridLayout(1, 2));
		m_ListModel = new ImageListModel(sPath);
		m_ImageList = new JList(m_ListModel);

		m_ImageLabel = new JLabel();
		m_ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		m_ImageLabel.setVerticalAlignment(SwingConstants.CENTER);

		m_ImageList.addListSelectionListener(new ImageListSelectionListener());
		m_ImageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(m_ImageList));
		add(new JScrollPane(m_ImageLabel));
	}

	class ImageListSelectionListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent e)
		{
			
			m_ImageLabel.setIcon(((MyImage)m_ListModel.getElementAt(m_ImageList.getSelectedIndex())).getImage());
		}
	};

	public static void main(String args[])
	{
		try
		{
			long lStart = System.currentTimeMillis();
			ImagePanel MyPanel = new ImagePanel("graphics\\");
			long lEnd = System.currentTimeMillis();
			JFrame frame = new JFrame("Image Browser Version 1.0 - Loading time = " + (lEnd - lStart) + "ms");
			frame.getContentPane().add(MyPanel);
			frame.setSize(500, 200);
			frame.setVisible(true);
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
	}
};