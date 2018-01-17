package decorator.videoFilter;
class BWFilter extends AbstractFilter
{
	BWFilter(AbstractConverter VideoDevice)
	{
		super(VideoDevice);
	}

	public VideoData getVideoData()
	{
		VideoData retVal = super.getVideoData();
		retVal.setColorMode("Black & White");
		return retVal;
	}
};