package Builder;

public class CarFactory {

	public void buildCar(ICarCreator creator) {
		System.out.println("In factory");
		creator.buildEngine();
		creator.buildSkeleton();
		creator.paint();
	}
	public static void main(String[] args) {
		
		MiniMinor mini = new MiniMinor();
		BigTrack bt = new BigTrack();
		
		CarFactory carF = new CarFactory();
		carF.buildCar(mini);
		carF.buildCar(bt);

	}

}
