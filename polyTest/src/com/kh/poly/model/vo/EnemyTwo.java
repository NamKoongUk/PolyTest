package com.kh.poly.model.vo;

public class EnemyTwo extends Enemy implements EnemyCry{

	public EnemyTwo(){}
	
	public EnemyTwo(int hp, int killPoint, String shape) {
		super(hp, killPoint, shape);
	}
	
	
	@Override
	public void cry() {
		System.out.println("----2줄을 노니는 욱이 등장----");
		
	}

	@Override
	public String shapeSel() {
		// TODO Auto-generated method stub
		return super.getShape();
	}

}
