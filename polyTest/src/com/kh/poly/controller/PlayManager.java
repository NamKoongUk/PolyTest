package com.kh.poly.controller;

import java.util.Random;
import java.util.Scanner;

import com.kh.poly.model.vo.Enemy;
import com.kh.poly.model.vo.EnemyFour;
import com.kh.poly.model.vo.EnemyTwo;
import com.kh.poly.model.vo.Player;

public class PlayManager {
	String[][] str = new String[4][4];
	Scanner sc = new Scanner(System.in);

	public void createPlayer() {
		System.out.print("�÷����� �÷��̾��� �̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();
		Player p = new Player(name);

		do {
			System.out.println("---- GAME LIST ----");
			System.out.println("1. 2�� ���̿� ����ϱ�");
			System.out.println("2. 4�� ���̿� ����ϱ�");
			System.out.println("3. ĳ���� ���� ���");
			System.out.println("4. ���α׷� ����");
			System.out.println("5. ü��ȸ��");
			System.out.print("�޴� ���� : ");
			int num = sc.nextInt();

			switch(num){

			case 1 : StartGame1(p);break;
			case 2 : startGame2(p);break;
			case 3 : System.out.println(p.toString());break;
			case 4 : return;
			case 5 : System.out.println("�׷��� �����ϴ�. �ٽ� �����ϼ���");return;
			}



		}while(true);


	}

	public void StartGame1(Player p) {

		Enemy e2 =new EnemyTwo(150, 2, "��");

		if(e2 instanceof EnemyTwo) {
			((EnemyTwo) e2).cry();
		}
		label:
		do {
			
			System.out.print("�ڸ��� ���� �Ͻÿ�(0~1) : ");
			int num = sc.nextInt();
			int random = new Random().nextInt(2);
			
			if(num >=2) {
				System.out.println("�߸��� �Է��Դϴ� �ٽ� �Է����ּ���");
				continue label;
			}

			for(int i=0; i<str.length; i++) {
				for(int j=0; j<str[i].length; j++) {
					if(i<2) {
						str[i][j] = "��";
					}else {
						str[i][j] = " ";
					}
				}
			}
			
			str[num][0] = "��";
			str[random][3] = e2.shapeSel();  //���� ���ε�
			if(num == random) {
				viewGame();
				System.out.println("������ ������ ���� ������ϴ�. �� hp50 ����"); 
				e2.setHp(e2.getHp() - 50);
			}else{
				viewGame();
				System.out.println(random + "�ٿ� ������� ���� �¾ҽ��ϴ�. hp50 ����");
				p.setHp(p.getHp() -50);
			}

			if(e2.getHp() <=0) {
				p.setKillPoint(p.getKillPoint() + e2.getKillPoint());
				System.out.println(e2.getKillPoint() + "��ŭ ų����Ʈ�� ȹ���߽��ϴ�.");
				upGrade(p);
				return;
			}else if(p.getHp() <=0) {
				System.out.println("�÷��̾ ����߽��ϴ�. �ٽ� �����ϼ��� ");
				return;
			}




		}while(true);

	}


	public void startGame2(Player p) {


		Enemy e4 = new EnemyFour(100 ,4, "��");

		if(e4 instanceof EnemyFour) {
			((EnemyFour)e4).cry();
		}

		do {

			System.out.print("�ڸ��� ���� �Ͻÿ�(0~3) : ");
			int num = sc.nextInt();
			int random = new Random().nextInt(4);

			for(int i=0; i<str.length; i++) {
				for(int j=0; j<str[i].length; j++) {
					str[i][j] = "��";
				}
			}

			/*if(num == 0) {
			str[0][0] = "��";
			if(random !=0) {
				str[random][3] = e4.getShape();
				viewGame();
				System.out.println(random + "�ٿ� ������� ���� �¾ҽ��ϴ�. hp50 ����");
				p.setHp(p.getHp() -50);
			}else if(random == 0) {
				str[random][3] = e4.getShape();
				viewGame();
				System.out.println("������ ������ ���� ������ϴ�. ��hp50 ����"); 
				e4.setHp(e4.getHp() - 50);

				if(e4.getHp() <=0) {
					p.setKillPoint(p.getKillPoint() + e4.getKillPoint());
					System.out.println(e4.getKillPoint() + "��ŭ ų����Ʈ�� ȹ���߽��ϴ�.");
					return;
				}else if(p.getHp() <=0) {
					System.out.println("�÷��̾ ����߽��ϴ�. �ٽ� �����ϼ��� ");
					return;
				}			
			}
		}*/

			str[num][0] = "��";
			str[random][3] = e4.shapeSel();  //���� ���ε�
			if(num == random) {
				viewGame();
				System.out.println("������ ������ ���� ������ϴ�. �� hp50 ����"); 
				e4.setHp(e4.getHp() - 50);
			}else{
				viewGame();
				System.out.println(random + "�ٿ� ������� ���� �¾ҽ��ϴ�. hp50 ����");
				p.setHp(p.getHp() -50);
			}

			if(e4.getHp() <=0) {
				p.setKillPoint(p.getKillPoint() + e4.getKillPoint());
				System.out.println(e4.getKillPoint() + "��ŭ ų����Ʈ�� ȹ���߽��ϴ�.");
				upGrade(p);
				return;
			}else if(p.getHp() <=0) {
				System.out.println("�÷��̾ ����߽��ϴ�. �ٽ� �����ϼ��� ");
				return;
			}	

		}while(true);


	}

	public void viewGame() {	
		for(int i = 0; i<str.length; i++) {
			for(int j=0; j<str[i].length; j++) {
				if(j != str.length -1) {
					System.out.print(str[i][j] + " ");
				}else {
					System.out.print(str[i][j]);
				}
			}
			System.out.println();
		}
	}

	public void upGrade(Player p) {

		if(p.getKillPoint() >16) {
			p.setGrade("MASTER");
			p.setHp(p.getHp() + 200);
			System.out.println(p.getName() + "���� ����� " + p.getGrade() + "�� ����ϰ� HP200 �߰�ȹ��! ����HP: " + p.getHp());
		}else if(p.getKillPoint() >12) {
			p.setGrade("PlATENUM");
			p.setHp(p.getHp() + 150);
			System.out.println(p.getName() + "���� ����� " + p.getGrade() + "�� ����ϰ� HP150 �߰�ȹ��! ����HP: " + p.getHp());
		}else if(p.getKillPoint() > 8) {
			p.setGrade("GOLD");
			p.setHp(p.getHp() + 100);
			System.out.println(p.getName() + "���� ����� " + p.getGrade() + "�� ����ϰ� HP100 �߰�ȹ��! ����HP: " + p.getHp());
		}else if(p.getKillPoint() >4) {
			p.setGrade("SILVER");
			p.setHp(p.getHp() + 50);
			System.out.println(p.getName() + "���� ����� " + p.getGrade() + "�� ����ϰ� HP50 �߰�ȹ��! ����HP: " + p.getHp());
		}
	}



}
