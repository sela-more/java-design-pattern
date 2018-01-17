package methods.notepad4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

class Notepad extends JFrame implements Viewer, ActionListener
{
	private JTextArea m_TextArea;
	private Object m_Doc;


	Notepad()
	{
		super("Notepad");
		setSize(400, 400);
		m_TextArea = new JTextArea();
		getContentPane().add(m_TextArea);
	}

	public void showViewer()
	{
		setVisible(true);
	}

	public void setText(String sText)
	{
		m_TextArea.setText(sText);
	}
	public String getText()
	{
		return m_TextArea.getText();
	}

	public void setDocument(Object doc)
	{
		HashMap m_Menus = new HashMap(); //Holds main menus 
		m_Doc = doc;
		Method arr[] = doc.getClass().getDeclaredMethods();
		for (int i = 0 ; i < arr.length ; ++i )
			if (arr[i].getName().startsWith("menu_"))
				addMenuItem(m_Menus, arr[i]);

		JMenuBar mb = new JMenuBar();
		Iterator iter = m_Menus.values().iterator();
		while(iter.hasNext())
		{
			JMenu m = (JMenu)iter.next();
			mb.add(m);
		}
		setJMenuBar(mb);
	}

	private void addMenuItem(Map m_Menus, Method m)
	{
		String sMethodName = m.getName();
		StringTokenizer st = new StringTokenizer(sMethodName, "_");
		st.nextToken();
		String sMenuName = st.nextToken();
		String sOption = st.nextToken();
		JMenu mCurrentMenu;
		if ((mCurrentMenu = (JMenu)m_Menus.get(sMenuName)) == null) //This menu was not created yet
		{
			mCurrentMenu = new JMenu(sMenuName);
			m_Menus.put(sMenuName, mCurrentMenu);
		}
		JMenuItem mi = new JMenuItem(sOption);
		mi.addActionListener(this);
		mCurrentMenu.add(mi);
	}

	public void actionPerformed(ActionEvent e)
	{
		JMenuItem item = (JMenuItem)e.getSource();
		JMenu parent = (JMenu)((JPopupMenu)item.getParent()).getInvoker();
		String sMethodName = "menu_" + parent.getLabel() + "_" + item.getText();
		System.out.println(sMethodName);
		try
		{
			m_Doc.getClass().getMethod(sMethodName, null).invoke(m_Doc, null);	
		}
		catch (Exception err)
		{
			err.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		Viewer v = new Notepad();
		v.setDocument(new MyDocument(v));
		v.showViewer();
	}
};