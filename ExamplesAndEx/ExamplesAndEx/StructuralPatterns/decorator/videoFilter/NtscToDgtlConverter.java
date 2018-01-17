package decorator.videoFilter;
class NtscToDgtlConverter extends AbstractConverter
{
	public NtscToDgtlConverter()
	{
		System.out.println("Connected to NTSC device");
	}

	public VideoData getVideoData()
	{
		return new VideoData("Colored", "1024 x 768");
	}
}