package cache.imageCacheFirstVersion;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

class View extends JFrame
{
	private JLabel m_ImageViewer;
	private JTextField m_sURLEditor;
	private JLabel m_LoadingTimeViewer;

	private CacheManager m_Manager;
	View()
	{
		super("Image Viewer");
		m_Manager = new CacheManager();
		setSize(400, 400);
		JPanel PnlCtrl = new JPanel();
		PnlCtrl.setLayout(new BorderLayout());
		m_LoadingTimeViewer = new JLabel("Loading Time =    (ms)");
		m_sURLEditor = new JTextField();
		JButton btnFetch = new JButton("Fetch Image!");
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					long lStartTime = System.currentTimeMillis();
					m_ImageViewer.setText("");
					m_ImageViewer.setIcon(m_Manager.fetchImage(m_sURLEditor.getText()));
					long lEndTime = System.currentTimeMillis();
					int nTime = (int)(lEndTime  - lStartTime);
					m_LoadingTimeViewer.setText("Loading Time =" + nTime + "(ms)");
				}
				catch (ImageCreationException error)
				{
					JOptionPane.showMessageDialog(View.this	, error.toString(), "Error!", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		PnlCtrl.add(m_LoadingTimeViewer, BorderLayout.WEST);
		PnlCtrl.add(m_sURLEditor);
		PnlCtrl.add(btnFetch, BorderLayout.EAST);
		getContentPane().add(PnlCtrl, BorderLayout.NORTH);

		m_ImageViewer = new JLabel("Image will be displayed here");
		m_ImageViewer.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(m_ImageViewer);

		setVisible(true);
	}

	public static void main(String args[])
	{
		new View();
	}
};