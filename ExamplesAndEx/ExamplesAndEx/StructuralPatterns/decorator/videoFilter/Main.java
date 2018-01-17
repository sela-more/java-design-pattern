package decorator.videoFilter;
class Main
{
	public static void main(String args[])
	{
		AbstractConverter converter = new Cropper(/*new BWFilter(*/new PalToDgtlConverter()/*)*/, "600 X 400");
		System.out.println(converter.getVideoData());
	}
};