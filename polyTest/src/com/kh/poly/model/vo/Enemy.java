package com.kh.poly.model.vo;

public abstract class Enemy {

	private int hp;
	private int killPoint;
	private String shape;
	
	public Enemy() {}
	public Enemy(int hp, int killPoint, String shape) {
		this.hp =hp;
		this.killPoint =killPoint;
		this.shape = shape;
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}
	
	public int getKillPoint() {
		return killPoint;
	}

	public void setKillPoint(int killPoint) {
		this.killPoint = killPoint;
	}
	
	public abstract String shapeSel();
	
	
}
