package abstractFactory;
class AWTFactory implements AbstractGuiFactory
{
	public PushButton createButton(String sTitle)
	{
		return new AWTPushButton(sTitle);
	}

	public TextLine createTextLine(String sTitle)
	{
		return new AWTTextLine(sTitle);
	}
};