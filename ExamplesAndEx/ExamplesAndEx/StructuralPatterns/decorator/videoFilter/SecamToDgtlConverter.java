package decorator.videoFilter;
class SecamToDgtlConverter extends AbstractConverter
{
	public SecamToDgtlConverter()
	{
		System.out.println("Connected to SECAM device");
	}

	public VideoData getVideoData()
	{
		return new VideoData("Colored", "1024 x 768");
	}
}