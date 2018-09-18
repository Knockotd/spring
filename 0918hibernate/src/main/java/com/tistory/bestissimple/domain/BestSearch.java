package com.tistory.bestissimple.domain;

public class BestSearch {

	private int num;
	private String keyword;
	private String story;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return "BestSearch [num=" + num + ", keyword=" + keyword + ", story=" + story + "]";
	}

}
