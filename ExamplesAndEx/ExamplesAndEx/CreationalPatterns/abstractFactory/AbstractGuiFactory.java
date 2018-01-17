package abstractFactory;
interface AbstractGuiFactory
{
	public PushButton createButton(String sTitle);
	public TextLine createTextLine(String sTitle);
}