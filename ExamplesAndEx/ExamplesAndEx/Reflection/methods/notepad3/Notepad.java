package methods.notepad3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.StringTokenizer;
class Notepad extends JFrame
{
	private String m_sFileName;
	private JTextArea m_TextArea;
	private JMenuItem fileOpen;
	private JMenuItem fileSave;
	private JMenuItem fileSaveAs;
	private JMenuItem fileExit;

	Notepad()
	{
		super("Notepad");
		setSize(400, 400);
		initMenu();
		m_TextArea = new JTextArea();
		getContentPane().add(m_TextArea);
		setVisible(true);
	}

	class MethodInvoker implements ActionListener
	{
		private Method m_Method;
		MethodInvoker(String sMethod) throws Exception
		{
			m_Method = Notepad.class.getDeclaredMethod(sMethod, null);
		}

		public void actionPerformed(ActionEvent e)
		{
			try
			{
				m_Method.invoke(Notepad.this,null);
			}
			catch (Exception error)
			{
				error.printStackTrace();
				JOptionPane.showMessageDialog(null, "Internal Error", "Notepad", JOptionPane.ERROR_MESSAGE); 
			}
		}
	};

	private void initMenu()
	{
		try
		{
			JMenuBar mb = new JMenuBar();
			JMenu FileMenu = new JMenu("File");
			fileOpen = new JMenuItem("Open...");
			fileOpen.addActionListener(new MethodInvoker("openFile"));
			fileSave = new JMenuItem("Save");
			fileSave.addActionListener(new MethodInvoker("saveFile"));
			fileSaveAs = new JMenuItem("Save As...");
			fileSaveAs.addActionListener(new MethodInvoker("saveFileAs"));
			fileExit = new JMenuItem("Exit");
			fileExit.addActionListener(new MethodInvoker("exit"));

			FileMenu.add(fileOpen);
			FileMenu.add(fileSave);
			FileMenu.add(fileSaveAs);
			FileMenu.add(fileExit);

			mb.add(FileMenu);
			setJMenuBar(mb);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Internal Error", "Notepad", JOptionPane.ERROR_MESSAGE); 
		}
	}

	public void exit()
	{
		System.exit(0);
	}

	public void openFile()
	{
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			m_sFileName = chooser.getSelectedFile().getPath();
			try
			{
				String sData = getFileData(m_sFileName);
				m_TextArea.setText(sData);
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "Error reading file", "Notepad", JOptionPane.ERROR_MESSAGE); 
			}
		}
    }

	public void saveFileAs()
	{
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showSaveDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) 
		{
			m_sFileName = chooser.getSelectedFile().getPath();
			saveFile();
		}
    }

	public void saveFile()
	{
		if (m_sFileName == null)
		{
			saveFileAs();
		}
		else
		{
			try
			{
				writeDataToFile(m_sFileName, m_TextArea.getText());	
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "Error Saving File", "Notepad", JOptionPane.ERROR_MESSAGE); 
			}
			
		}
	}

	private String getFileData(String sFileName) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(sFileName));
		StringBuffer sb = new StringBuffer();
		String sLine;
		while ((sLine = br.readLine()) != null)
		{
			sb.append(sLine);
			sb.append("\n");
		}
		br.close();
		return sb.toString();

	}

	private void writeDataToFile(String sFileName, String sData) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(sFileName));
		StringTokenizer tok = new StringTokenizer(sData, "\n");
		while (tok.hasMoreTokens())
		{
			bw.write(tok.nextToken());
			bw.newLine();
		}
		bw.close();
	}

	public static void main(String args[])
	{
		new Notepad();
	}
};