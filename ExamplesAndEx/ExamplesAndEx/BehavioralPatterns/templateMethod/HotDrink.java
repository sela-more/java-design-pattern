package templateMethod;
abstract class HotDrink {
	public void prepareDrink() {
		boilWater();
		addFlavors();
		stir();
	}

	public void boilWater() {
		System.out.println("Boiling water...");
	}
	
	abstract void addFlavors();
	
	public void stir() {
		System.out.println("Stirring...");
	}
}

class Coffee extends HotDrink {

	public void addFlavors() {
		System.out.println("Adding coffee beans...");
		System.out.println("Adding sugar...");
		System.out.println("Pouring milk...");
	}
}

class Tea extends HotDrink {

	public void addFlavors() {
		System.out.println("Soaking teabag...");
		System.out.println("Waiting a minute...");
	}
}

class Main {
	public static void main (String args[]) {
		System.out.println("preparing a cup of coffee:");
		HotDrink coffee = new Coffee();
		coffee.prepareDrink();

		System.out.println("\npreparing a cup of tea:");
		HotDrink tea = new Tea();
		tea.prepareDrink();
	}

}