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
	
	public Damagochi () {
		
	}
	
	// 생성자 및 getter setter
	
	
}
