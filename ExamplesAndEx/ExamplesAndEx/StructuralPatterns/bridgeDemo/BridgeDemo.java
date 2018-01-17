
package bridgeDemo;
import java.io.*;

public class BridgeDemo {

	public static void main(String[] args) throws Exception {
		
		// the following example shows how BefferedReader works against
		// an abstract buffer, which it gets during construaction.
		// first example: BufferedReader that works with a file buffer
		// Second example: BufferedReader that works with a  InputStreamReader from System.in
		
		BufferedReader br;
		FileReader fis;
		
		fis = new FileReader("BridgeDemo.java");
		br = new BufferedReader(fis); // buffered reader from file
		String str=null;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
		fis.close();
		
		
		br = new BufferedReader(new InputStreamReader(System.in)); //bufferef Reader
																   // from InputStreamReader
																	// from System.in which is binary
		System.out.println(br.readLine());
	}
}
