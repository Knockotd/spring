package vo;

public class Sample {
	
	
	private String name;
	private int age;
	private boolean women;
	private float eyes;
	
	
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isWomen() {
		return women;
	}
	public void setWomen(boolean women) {
		this.women = women;
	}
	public float getEyes() {
		return eyes;
	}
	public void setEyes(float eyes) {
		this.eyes = eyes;
	}
	@Override
	public String toString() {
		return "Sample [name=" + name + ", age=" + age + ", women=" + women + ", eyes=" + eyes + "]";
	}

}
