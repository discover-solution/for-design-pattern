package lecture_03.classroom.creational.signleton;

public class NullCheckSingleton {

	private NullCheckSingleton() {
		
	}
	
	public NullCheckSingleton getInstance() {
		return null;
	}
}