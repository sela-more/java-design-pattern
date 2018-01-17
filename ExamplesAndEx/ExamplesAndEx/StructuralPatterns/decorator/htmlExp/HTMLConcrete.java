/*
 * Created on 06/10/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package decorator.htmlExp;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HTMLConcrete implements IHTMLExp {

	/* (non-Javadoc)
	 * @see decorator.htmlExp.IHTMLExp#getExpression()
	 */
	private String m_htmlData;
	public HTMLConcrete(String data){
		m_htmlData = data;
	}
	 
	public String getExpression() {
		// TODO Auto-generated method stub
		return m_htmlData;
	}
	

}
