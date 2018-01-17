package modifiers;
public class Main
{
    public static void main(String args[])
    {
        if (args.length == 0)
        {
            usage();
            System.exit(1);
        }
        PrintClassData d = new PrintClassData(args[0]);
    }
    
    private static void usage()
    {
        System.out.println("This application must get a legal class name as parameter");
    } 
}
