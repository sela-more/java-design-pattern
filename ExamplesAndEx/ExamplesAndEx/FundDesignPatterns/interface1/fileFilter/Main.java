package interface1.fileFilter;
import java.io.File;
class Main
{
	public static void main(String args[])
	{
		try
		{
			String sDirPath = args[0];
			int nMinSize = Integer.parseInt(args[1]);
			int nMaxSize = Integer.parseInt(args[2]);	

			File fDir = new File(sDirPath);
			FileSizeFilter filter = new FileSizeFilter(nMinSize, nMaxSize);
			String sFiles[] = fDir.list(filter);

			System.out.println(filter);
			for (int i = 0 ; i < sFiles.length ; ++i)
			{
				System.out.print(i + 1);
				System.out.print(" ");
				System.out.println(sFiles[i]);
			}
		}
		catch (Exception any)
		{
			System.err.println("Invalid Output");
			any.printStackTrace();
		}	
	}
};