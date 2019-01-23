package com.kh.poly.model.vo;

public class EnemyFour extends Enemy implements EnemyCry {

	public EnemyFour() {}
	public EnemyFour(int hp ,int killPoint, String shape) {
		super(hp, killPoint, shape);
	}
	
	
	
	
	@Override
	public void cry() {
		System.out.println("----4���� ��ϴ� ���� ����----");
		
	}

	@Override
	public String shapeSel() {
		return super.getShape();
	}

}
