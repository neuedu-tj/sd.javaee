package com.model;

public class Moments {

	private int mid;
	private String mcontent;
	private String imgs;

	public Moments(String mcontent, String imgs) {

		this.mcontent = mcontent;
		this.imgs = imgs;
	}

	public Moments(String mcontent) {
		this.mcontent = mcontent;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	@Override
	public String toString() {
		return "Moments [mid=" + mid + ", mcontent=" + mcontent + ", imgs=" + imgs + "]";
	}

}
