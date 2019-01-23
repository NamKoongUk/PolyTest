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
		System.out.print("플레이할 플레이어의 이름을 입력하세요 : ");
		String name = sc.nextLine();
		Player p = new Player(name);

		do {
			System.out.println("---- GAME LIST ----");
			System.out.println("1. 2줄 욱이와 상대하기");
			System.out.println("2. 4줄 욱이와 상대하기");
			System.out.println("3. 캐릭터 상태 출력");
			System.out.println("4. 프로그램 종료");
			System.out.println("5. 체력회복");
			System.out.print("메뉴 선택 : ");
			int num = sc.nextInt();

			switch(num){

			case 1 : StartGame1(p);break;
			case 2 : startGame2(p);break;
			case 3 : System.out.println(p.toString());break;
			case 4 : return;
			case 5 : System.out.println("그런건 없습니다. 다시 도전하세요");return;
			}



		}while(true);


	}

	public void StartGame1(Player p) {

		Enemy e2 =new EnemyTwo(150, 2, "●");

		if(e2 instanceof EnemyTwo) {
			((EnemyTwo) e2).cry();
		}
		label:
		do {
			
			System.out.print("자리를 선택 하시오(0~1) : ");
			int num = sc.nextInt();
			int random = new Random().nextInt(2);
			
			if(num >=2) {
				System.out.println("잘못된 입력입니다 다시 입력해주세요");
				continue label;
			}

			for(int i=0; i<str.length; i++) {
				for(int j=0; j<str[i].length; j++) {
					if(i<2) {
						str[i][j] = "○";
					}else {
						str[i][j] = " ";
					}
				}
			}
			
			str[num][0] = "●";
			str[random][3] = e2.shapeSel();  //동적 바인딩
			if(num == random) {
				viewGame();
				System.out.println("직선의 적에게 총을 맞췄습니다. 적 hp50 감소"); 
				e2.setHp(e2.getHp() - 50);
			}else{
				viewGame();
				System.out.println(random + "줄에 사수에게 총을 맞았습니다. hp50 감소");
				p.setHp(p.getHp() -50);
			}

			if(e2.getHp() <=0) {
				p.setKillPoint(p.getKillPoint() + e2.getKillPoint());
				System.out.println(e2.getKillPoint() + "만큼 킬포인트를 획득했습니다.");
				upGrade(p);
				return;
			}else if(p.getHp() <=0) {
				System.out.println("플레이어가 사망했습니다. 다시 시작하세요 ");
				return;
			}




		}while(true);

	}


	public void startGame2(Player p) {


		Enemy e4 = new EnemyFour(100 ,4, "●");

		if(e4 instanceof EnemyFour) {
			((EnemyFour)e4).cry();
		}

		do {

			System.out.print("자리를 선택 하시오(0~3) : ");
			int num = sc.nextInt();
			int random = new Random().nextInt(4);

			for(int i=0; i<str.length; i++) {
				for(int j=0; j<str[i].length; j++) {
					str[i][j] = "○";
				}
			}

			/*if(num == 0) {
			str[0][0] = "●";
			if(random !=0) {
				str[random][3] = e4.getShape();
				viewGame();
				System.out.println(random + "줄에 사수에게 총을 맞았습니다. hp50 감소");
				p.setHp(p.getHp() -50);
			}else if(random == 0) {
				str[random][3] = e4.getShape();
				viewGame();
				System.out.println("직선의 적에게 총을 맞췄습니다. 적hp50 감소"); 
				e4.setHp(e4.getHp() - 50);

				if(e4.getHp() <=0) {
					p.setKillPoint(p.getKillPoint() + e4.getKillPoint());
					System.out.println(e4.getKillPoint() + "만큼 킬포인트를 획득했습니다.");
					return;
				}else if(p.getHp() <=0) {
					System.out.println("플레이어가 사망했습니다. 다시 시작하세요 ");
					return;
				}			
			}
		}*/

			str[num][0] = "●";
			str[random][3] = e4.shapeSel();  //동적 바인딩
			if(num == random) {
				viewGame();
				System.out.println("직선의 적에게 총을 맞췄습니다. 적 hp50 감소"); 
				e4.setHp(e4.getHp() - 50);
			}else{
				viewGame();
				System.out.println(random + "줄에 사수에게 총을 맞았습니다. hp50 감소");
				p.setHp(p.getHp() -50);
			}

			if(e4.getHp() <=0) {
				p.setKillPoint(p.getKillPoint() + e4.getKillPoint());
				System.out.println(e4.getKillPoint() + "만큼 킬포인트를 획득했습니다.");
				upGrade(p);
				return;
			}else if(p.getHp() <=0) {
				System.out.println("플레이어가 사망했습니다. 다시 시작하세요 ");
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
			System.out.println(p.getName() + "님의 등급이 " + p.getGrade() + "로 상승하고 HP200 추가획득! 현재HP: " + p.getHp());
		}else if(p.getKillPoint() >12) {
			p.setGrade("PlATENUM");
			p.setHp(p.getHp() + 150);
			System.out.println(p.getName() + "님의 등급이 " + p.getGrade() + "로 상승하고 HP150 추가획득! 현재HP: " + p.getHp());
		}else if(p.getKillPoint() > 8) {
			p.setGrade("GOLD");
			p.setHp(p.getHp() + 100);
			System.out.println(p.getName() + "님의 등급이 " + p.getGrade() + "로 상승하고 HP100 추가획득! 현재HP: " + p.getHp());
		}else if(p.getKillPoint() >4) {
			p.setGrade("SILVER");
			p.setHp(p.getHp() + 50);
			System.out.println(p.getName() + "님의 등급이 " + p.getGrade() + "로 상승하고 HP50 추가획득! 현재HP: " + p.getHp());
		}
	}



}
