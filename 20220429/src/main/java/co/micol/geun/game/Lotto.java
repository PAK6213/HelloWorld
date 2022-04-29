package co.micol.geun.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lotto {
	private Scanner sc = new Scanner(System.in);
	private int[] gameLottoNumber = new int[6];
	private List<int[]> list = new ArrayList<int[]> ();
	private int[] userLottoNumber = new int[6];



	// 게임로또번호
	public void gameLottoNumberInit() {
		for(int i = 0; i < gameLottoNumber.length; i++) {
			gameLottoNumber[i] = (int)(Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (gameLottoNumber[i] == gameLottoNumber[j]) {
					i--;
				}
			}
		}
	}
	// 입력받은 금액만큼 사용자 로또 번호 생성하여 
	public void userLottoNumber(int money) {
		System.out.print("이번 게임의 로또번호는 : ");
		System.out.println(Arrays.toString(gameLottoNumber));
		money = money / 1000;
		for(int k = 0 ; k < money; k++) {
			for(int i = 0; i < userLottoNumber.length; i++) {
				userLottoNumber[i] = (int)(Math.random() * 45) + 1;
				for (int j = 0; j < i; j++) {
					if (userLottoNumber[i] == userLottoNumber[j]) {
						i--;
					}
				}
			}
			sort(userLottoNumber);
			int result = compare(userLottoNumber,gameLottoNumber);

			result(result);
		}

	}


	public int[] sort(int arr[]) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) { // +1을 하는 이유는 자기와 비교할 필요가 없기 때문
				if(arr[i] > arr[j]) { // '>' 일 경우 오름차순 '<' 일 경우 내림차순
					int temp = arr[i]; // 값 변경해야 하기에 임시 저장
					arr[i] = arr[j]; // j를 i로 변경
					arr[j] = temp;  // i를 j로 변경
				}
			}
		}
		return arr;
	}
	//arr user  arr2 game
	public int compare(int[] arr , int[] arr2) {
		int count = 0;
		for(int i = 0 ; i < arr2.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr2[i] == arr[j]) {
					count++;
				}
			}
		}
		return count;
	}

	public void result(int num1) {

		System.out.print("사용자의 게임의 로또번호는 : ");
		System.out.print(Arrays.toString(userLottoNumber));
		System.out.println("입니다.");
		if(num1 == 6) {
			System.out.println("1등입니다 축하드립니다. 상금은 1,000,000,000원입니다.");
		} else if(num1 == 5) {
			System.out.println("2등입니다 축하드립니다. 상금은 40,000,000원입니다.");
		} else if(num1 == 4) {
			System.out.println("3등입니다 축하드립니다. 상금은 1,000,000원입니다.");
		} else if(num1 == 3) {
			System.out.println("4등입니다 축하드립니다. 상금은 5,000원입니다.");
		} else {

		}
	}


	public void run() {
		int money;
		//로또게임 구현
		System.out.println("로또게임");
		System.out.println("금액을 입력하세요.");
		money = sc.nextInt();

		gameLottoNumberInit();
		userLottoNumber(money);

	}
}
