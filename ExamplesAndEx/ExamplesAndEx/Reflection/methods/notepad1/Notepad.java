package methods.notepad1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
class Notepad extends JFrame
{
	private String m_sFileName;
	private JTextArea m_TextArea;

	Notepad()
	{
		super("Notepad");
		setSize(400, 400);
		initMenu();
		m_TextArea = new JTextArea();
		getContentPane().add(m_TextArea);
		setVisible(true); 
	}

	private void initMenu()
	{
		JMenuBar mb = new JMenuBar();
		JMenu FileMenu = new JMenu("File");
		JMenuItem fileOpen = new JMenuItem("Open...");
		fileOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				openFile();
			}
		});

		JMenuItem fileSave = new JMenuItem("Save");
		fileSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				saveFile();
			}
		});

		JMenuItem fileSaveAs = new JMenuItem("Save As...");
		fileSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				saveFileAs();
			}
		});

		JMenuItem fileExit = new JMenuItem("Exit");
		fileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});

		FileMenu.add(fileOpen);
		FileMenu.add(fileSave);
		FileMenu.add(fileSaveAs);
		FileMenu.add(fileExit);

		mb.add(FileMenu);
		setJMenuBar(mb);
	}

	private void openFile()
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

	private void saveFileAs()
	{
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showSaveDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) 
		{
			m_sFileName = chooser.getSelectedFile().getPath();
			saveFile();
		}
    }

	private void saveFile()
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