package methods.notepad4;
import java.io.*;
import java.util.*;
import javax.swing.*;
class MyDocument
{
	private String m_sFileName;
	private Viewer m_Viewer;

	public MyDocument(Viewer v)
	{
		m_Viewer = v;
		v.setDocument(this);
	}
	   
	public void menu_IBM_OtherTest(){}
	public void menu_IBM_test(){}	
	public void menu_testing_test(){}	
	public void menu_amdocs_test(){}
	public void menu_amdocs_test2(){}
	public void menu_amdocs_testTooLate(){}
	public void menu_format_font(){}
	public void menu_format_color(){}
	public void menu_edit_cut(){}
	public void menu_edit_copy(){}
	public void menu_edit_paste2(){}
	public void menu_window_close(){}	
	public void menu_tools_check(){}	  
	 
	public void menu_file_open()
	{
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			m_sFileName = chooser.getSelectedFile().getPath();
			try
			{
				String sData = getFileData(m_sFileName);
				m_Viewer.setText(sData);
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "Error reading file", "Notepad", JOptionPane.ERROR_MESSAGE); 
			}
		}
    }

	public void menu_file_saveasToDisk()
	{
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showSaveDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) 
		{
			m_sFileName = chooser.getSelectedFile().getPath();
			menu_file_save();
		}
    }

	public void menu_file_save()
	{
		if (m_sFileName == null)
		{
			menu_file_saveasToDisk();
		}
		else
		{
			try
			{
				writeDataToFile(m_sFileName, m_Viewer.getText());	
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "Error Saving File", "Notepad", JOptionPane.ERROR_MESSAGE); 
			}
			
		}
	}
public void menu_file_exit()
	{
		System.exit(0);
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
}