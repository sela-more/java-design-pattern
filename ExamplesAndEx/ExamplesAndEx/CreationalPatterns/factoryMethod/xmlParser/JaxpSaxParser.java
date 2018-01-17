package factoryMethod.xmlParser;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;


/**
*	Parsing an XML file using JAXP SAX
**/
public class JaxpSaxParser {

    public static void main(String arg[])
    {
        if (arg.length != 1) {
            System.err.println("Usage: JaxpSaxParser xml_file");
            System.exit(1);
        }
        DefaultHandler handler = new PrintHandler();

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse( arg[0], handler );
		}
		catch (Exception e) {
			System.out.println("General exception");
				e.printStackTrace();
		}
    }


	static class PrintHandler extends DefaultHandler {

		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException	{
			System.out.println(qName);
		}

		public void fatalError(SAXParseException e) throws SAXParseException {
				System.out.println("Error");
				//e.printStackTrace();
		}

	}

}