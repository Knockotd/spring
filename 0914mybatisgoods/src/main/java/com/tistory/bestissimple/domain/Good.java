package com.tistory.bestissimple.domain;

public class Good {

	private Integer code;
	private String name;
	private Integer price;
	private String description;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Good [code=" + code + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}
}
