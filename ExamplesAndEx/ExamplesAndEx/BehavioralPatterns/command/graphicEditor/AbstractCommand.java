package command.graphicEditor;
abstract class AbstractCommand
{
	public abstract void doIt(IDocument document);
	public abstract void undoIt(IDocument document);
};