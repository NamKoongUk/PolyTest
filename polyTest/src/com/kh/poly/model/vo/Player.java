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
		return name + "���� hp�� " + hp + "�̸� ���� ����� " + grade + "�̸� ų ����Ʈ�� " + killPoint + "�Դϴ�.";
	}
}
