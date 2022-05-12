package Minigame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import Miniproject.Damagochi.StatePrint;

public class Minigame {
	int break1;
	Scanner sc = new Scanner(System.in);
	StatePrint sp = new StatePrint();
	public void UpDown () {
		int randomNumber = (int)(Math.random()*10000) + 1;
		int answerNumber;
		boolean b = true;
		System.out.println("숫자 맞추기 게임을시작합니다(범위는 1 ~ 10000)");
		while(b) {
			System.out.print("정답 숫자를 입력하세요 : ");
			answerNumber = sc.nextInt();
			sc.nextLine();

			if(answerNumber > 10000 || answerNumber < 0) {
				System.out.println("범위 밖의 숫자를 입력하였습니다.");
				continue;
			}
			if(randomNumber == answerNumber) {
				sp.clearScreen();
				System.out.println("정답입니다. iq_exe가 15증가하였습니다.");
				break;
			} else if(randomNumber > answerNumber) {
				System.out.println("입력한 수는 정답보다 작습니다.");
			} else if(randomNumber < answerNumber) {
				System.out.println("입력한 수는 정답보다 큽니다.");
			}
		}
	}

	public void word() {
		break1 = 3;
		String[] words = new String[55];
		int num = 0;
		// 파일을 읽어와서 words배열 각 값을 저장.
		try {
			Scanner scanner = new Scanner(new File("C:\\Users\\admin\\Desktop\\word.txt"));
			while (scanner.hasNext()) {
				String str = scanner.next();
				words[num] = str;
				num++;
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int i = (int)(Math.random() * 54) + 1;   // 0 ~ 54
		String answerWords = words[i];
		char temp;
		boolean b = true;
		char[] word = new char[answerWords.length()];

		//메뉴
		while(b) {
			try {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("               1.단어 학습하기");
				System.out.println("               2.단어 맞추기");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.print("메뉴를 선택하세요 : ");
				int menu = Integer.parseInt(sc.nextLine());

				if(menu == 1) {
					System.out.println("단어 학습을 시작합니다.");
					for(int j = 0; j < words.length; j++) {
						System.out.println(j+1 + "번째 단어 : " + words[j]);
						try {
							Thread.sleep(400);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else if(menu == 2) {

					//단어 한자씩 배열에 넣기
					for(int j = 0 ; j < answerWords.length(); j++) {
						// 정답의 단어길이 만큼을 담을 배열 생성
						word[j] = answerWords.charAt(j);// 정답단어를 한자씩 잘라서7 넣음.
					}
					//단어 섞기
					for(int j = 0; j < answerWords.length(); j++) {
						int randomNumber = (int)(Math.random()*answerWords.length());
						temp = word[j];
						word[j] = word[randomNumber];
						word[randomNumber] = temp;
					}




					int hintcount = 1;
					// 문제안 메뉴
					while(b) {
						int menu2 = 0;
						try {
							System.out.println("문제" + Arrays.toString(word) + "입니다.");
							System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
							System.out.println("               1.정답입력 ");
							System.out.println("               2.힌트");
							System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
							System.out.print("메뉴를 선택하세요 : ");

							menu2 = Integer.parseInt(sc.nextLine());
						} catch(InputMismatchException e) {
							System.out.println("숫자를 입력하세요!!");
						}

						if(menu2 == 2) {
							//힌트 
							System.out.print("힌트 : ");
							for(int j = 0 ; j < hintcount ; j++ ) {
								char hint;
								hint = answerWords.charAt(j);
								System.out.print(hint);
							}
							System.out.println();
							hintcount++;

						} else if(menu2 == 1) {

							System.out.print("정답을 입력하세요 : ");
							String myWord = sc.nextLine();
							if(myWord.equals(answerWords)) {
								sp.clearScreen();
								System.out.println("정답입니다. iq_exe가 30증가하였습니다.");
								break1 = 1;
								break;
							} else {
								System.out.println("틀렸습니다. 다시입력하세요!");
							}
						}


					}
				}
			}catch (Exception e) {
				sp.clearScreen();
				sp.warning();
				System.out.println("숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! ");
			}
			if(break1 == 1) {
				break;
			}
		}
	}


	//HashMap 이용
	public void Capital() {
		// 해쉬맵 생성
		HashMap<String,String> map = new HashMap<String, String>();
		try {
			//파일 내용을 읽어 key , value를 map에 매핑.
			Scanner scanner = new Scanner(new File("C:\\Users\\admin\\Desktop\\capital.txt"));
			while (scanner.hasNext()) {
				String country = scanner.next();
				String capital = scanner.next();
				map.put(country, capital);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//메뉴
		boolean b = true;
		int menu;
		break1 = 3;
		while(b) {
			try {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("                1.학습하기");
				System.out.println("                2.수도 맞추기");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.print("메뉴를 선택하세요 : ");
				menu = Integer.parseInt(sc.nextLine());

				if(menu == 1) {
					// map.entrySet()은 Entry (key, value)를 가지는 Set객체를 리턴
					for(Entry<String,String> entrySet : map.entrySet()) {
						System.out.println("나라이름 : " + entrySet.getKey() + "  수도이름 : " + entrySet.getValue());
					}


				} else if(menu == 2) {
					Set<String> set = map.keySet();  // map의 모든 key값을 Set에 저장 순서가 없음.
					Object[] problem = set.toArray();  // set(key)을 배열형태로 저장.

					int random = (int)(Math.random() * problem.length) + 1;
					String answer = map.get(problem[random]); // 랜덤으로 뽑힌 key에 대응하는 value를 저장
					System.out.println("문제 : " + problem[random] + "의 수도는?");
					while(true) {


						System.out.print("정답 : ");
						String input = sc.nextLine();
						if(input.equals(answer)) {
							sp.clearScreen();
							System.out.println("정답입니다. iq_exe가 30증가하였습니다.");
							break1 = 1;
							break;
						} else {
							System.out.println("오답입니다.");
						}
					}
				}

			}catch (Exception e) {
				sp.clearScreen();
				sp.warning();
				System.out.println("숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! ");
			}
			if(break1 == 1) {
				break;
			}
		}
	}
}




