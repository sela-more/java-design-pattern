package observer.processorMonitor;
interface ProcessorInterest
{
	public void registerObserver(ProcessorObserver PO);
	public int getSize();
	public int getValueAt(int index);
	public int getMaxValue();
}