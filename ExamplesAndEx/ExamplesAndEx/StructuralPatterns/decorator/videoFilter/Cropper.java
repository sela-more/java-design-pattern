package decorator.videoFilter;
class Cropper extends AbstractFilter
{
	String m_sNewDimensions;
	Cropper(AbstractConverter VideoDevice, String sNewDimensions)
	{
		super(VideoDevice);
		m_sNewDimensions = sNewDimensions;
	}

	public VideoData getVideoData()
	{
		VideoData retVal = super.getVideoData();
		retVal.setDimensions(m_sNewDimensions);
		return retVal;
	}
};