package methods.notepad4;
interface Viewer
{
	public void setText(String sText);
	public String getText();
	public void setDocument(Object oDoc);
	public void showViewer();
}