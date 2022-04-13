package co.edu.array;

public class ForExample {

	public static void main(String[] args) {
		// 주사위 게임 2개 던짐.
		// 2개의 숫자의 합이 6이 되는 경우를 출력

		int dice1, dice2;
		dice1 = (int)(Math.random()*6) + 1;
		dice2 = (int)(Math.random()*6) + 1;
		boolean isTrue = true;

		for(int i = 1; i <= 6 ; i++) {
			for( int j = 1; j <=6 ; j++) {
				if((i+j)==6) {
					System.out.printf("합이 6이 되는 주사위는 (%d,%d)입니다.\n", i,j);
				}
			}
		}

		while(isTrue) {
			if((dice1 + dice2) == 6) {
				System.out.printf("합이 6이 되었습니다. 첫번째 주사위와 두번째 주사위의 값은 (%d,%d) 입니다.", dice1, dice2);
				isTrue = !isTrue;
			}
		}
	}
}
