package tistory.simpleisbest.view.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

//이 클래스를 xml로 출력하기 위한 설정
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder= {"kind", "name", "price"})

public class DataStructure {
	private String kind;
	private String name;
	private int price;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
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
	@Override
	public String toString() {
		return "DataStructure [kind=" + kind + ", name=" + name + ", price=" + price + "]";
	}
}
