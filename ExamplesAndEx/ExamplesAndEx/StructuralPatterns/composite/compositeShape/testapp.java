package composite.compositeShape;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class TestApp extends JFrame implements ListSelectionListener, ActionListener
{
	private Viewer m_Viewer;
	private Catalogue m_Catalogue;
	JList CatalogueViewer;
	TestApp()
	{
		CatalogueViewer = new JList(m_Catalogue = new Catalogue());
		CatalogueViewer.setCellRenderer(new PrototypeRenderer());
		CatalogueViewer.addListSelectionListener(this);
		getContentPane().add(new JScrollPane(CatalogueViewer), BorderLayout.WEST);
		JButton btn = new JButton("Create");
		btn.addActionListener(this);
		getContentPane().add(btn, BorderLayout.EAST);
		m_Viewer = new Viewer();
		getContentPane().add(m_Viewer);
		setSize(400, 400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		m_Catalogue.addShape(m_Viewer.createPicture());
	}
	public static void main(String args[])
	{
		new TestApp();
	}

	public void valueChanged(ListSelectionEvent e)
	{
		 m_Viewer.setShape(m_Catalogue.getShape(CatalogueViewer.getSelectedIndex()));
	}
};