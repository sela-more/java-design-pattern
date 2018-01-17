package decorator.videoFilter;
class PalToDgtlConverter extends AbstractConverter
{
	public PalToDgtlConverter()
	{
		System.out.println("Connected to PAL device");
	}

	public VideoData getVideoData()
	{
		return new VideoData("Colored", "1024 x 768");
	}
}