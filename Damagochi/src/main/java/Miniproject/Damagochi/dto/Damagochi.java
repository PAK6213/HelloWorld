package Miniproject.Damagochi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Damagochi {
	//멤버변수
	private String userId;
	private String damagochiName;
	private int satiety ;
	private int thirst ;
	private int iqLevel ;
	private int socialLevel ;
	private int healthLevel ;
	private int iqExp ;
	private int socialExp ;
	private int healthExp ;
	private int hp;
	private int depressionCount; 
	private int score;
	
	public Damagochi () {
		
	}
	

	@Override
	public String toString() {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(this.getDamagochiName() + "의 현재 상태입니다. 유의해서 진행해주세요!!!!!");
		System.out.println("다마고치 이름 : " + this.getDamagochiName() + "  HP: " + this.getHp() 
					+ "  포만감 : " + this.getSatiety() + "  목마름 : " 
					+ this.getThirst() + "\n지능경험치 : " + this.getIqExp() + "  지능레벨 : " 
					+ this.getIqLevel() + "\n사회성경험치 : " + this.getSocialExp() 
					+ "  사회성레벨 : " + this.getSocialLevel() + "\n건강경험치 : " 
					+ this.getHealthExp() + "  건강레벨 : " + this.getHealthLevel() 
					+ "\n우울증수치 : " + this.getDepressionCount() + "  점수 : " 
					+ this.getScore());
		return "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■"; 
	}
	
	
	
	
	// 생성자 및 getter setter
	
	
}
