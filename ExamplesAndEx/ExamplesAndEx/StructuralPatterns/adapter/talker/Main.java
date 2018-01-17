package adapter.talker;
class Main {



		public static void main (String args[]) {
			ITalker[] talkers = new ITalker[4];
			int i=0;
			talkers[i++] = new Person("Jerry");
			talkers[i++] = new Person("George");
			talkers[i++] = new Parrot("Polly");
			
			Dog d = new Dog("shuky");
			DogAdapter da = new DogAdapter(d);
			talkers[i++] = da;

			for (int j=0; j<talkers.length; j++) 
				talkers[j].talk();
		}


}