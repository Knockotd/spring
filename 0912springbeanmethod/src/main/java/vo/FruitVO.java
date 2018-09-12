package vo;

public class FruitVO {

	private String name;
	private int price;
	private int count;
	
	public FruitVO() {
		System.out.println("FruitVO의 생성자");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "FruitVO [name=" + name + ", price=" + price + ", count=" + count + "]";
	}
}
