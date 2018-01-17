package adapter.talker;
class DogAdapter implements ITalker {
	Dog m_dog;

	public DogAdapter(Dog dog) {
		m_dog=dog;
	}
	
	public void talk() {
		m_dog.bark();
	}

}