package command.graphicEditor;
import javax.swing.JFrame;
import java.awt.BorderLayout;

class GraphicEditor extends JFrame
{
	GraphicEditor()
	{
		super("Graphic Editor");
		setSize(400, 400);

		CommandManager Manager = new CommandManager();
		getContentPane().add(new UndoViewer(Manager), BorderLayout.WEST);
		getContentPane().add(new Editor(Manager));

		setVisible(true);
	}

	public static void main(String args[])
	{
		new GraphicEditor();
	}
};