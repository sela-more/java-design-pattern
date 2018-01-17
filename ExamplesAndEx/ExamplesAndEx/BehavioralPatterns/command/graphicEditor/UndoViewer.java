package command.graphicEditor;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class UndoViewer extends JPanel
{
	private CommandManager m_Manager;
	private JList m_List;
	private JButton m_btnUndo;

	UndoViewer(CommandManager Manager)
	{
		m_Manager = Manager;
		setLayout(new BorderLayout());
		m_List = new JList(Manager);
		add(m_List);
		m_btnUndo = new JButton("Undo!");
		m_btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				m_Manager.undoIt(m_List.getSelectedIndex());
			}
		});

		add(m_btnUndo, BorderLayout.SOUTH);

	}
};