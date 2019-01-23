package com.kh.poly.model.vo;

public class Player {

	private String name;
	private int hp = 500;
	private String grade = "bronze";
	private int killPoint;
	
	public Player() {}
	public Player(String name) {
		this.name = name;
	}
	
	public int getKillPoint() {
		return killPoint;
	}
	public void setKillPoint(int killPoint) {
		this.killPoint = killPoint;
	}
	
	public String getName() {
		return name;
	}
	public int getHp() {
		return hp;
	}
	public String getGrade() {
		return grade;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return name + "님의 hp는 " + hp + "이며 현재 등급은 " + grade + "이며 킬 포인트는 " + killPoint + "입니다.";
	}
}
