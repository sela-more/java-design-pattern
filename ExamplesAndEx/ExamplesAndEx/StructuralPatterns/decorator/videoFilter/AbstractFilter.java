package decorator.videoFilter;
abstract class AbstractFilter extends AbstractConverter
{
	private AbstractConverter m_VideoDevice;

	protected AbstractFilter(AbstractConverter VideoDevice)
	{
		m_VideoDevice = VideoDevice;
	}

	public VideoData getVideoData()
	{
		return m_VideoDevice.getVideoData();
	}
};