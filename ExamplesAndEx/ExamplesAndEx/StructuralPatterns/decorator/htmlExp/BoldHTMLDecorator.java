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
public class BoldHTMLDecorator extends AbstractHTMLExpression {

	/**
	 * @param exp
	 */
	public BoldHTMLDecorator(IHTMLExp exp) {
		super(exp);
		// TODO Auto-generated constructor stub
	}
	public String getExpression() {
			return " <B>" + super.getExpression() + "</B>";
	}

}
