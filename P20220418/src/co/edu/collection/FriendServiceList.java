package co.edu.collection;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.friend.Friend;
import co.edu.friend.Gender;

public class FriendServiceList implements FriendService {
	ArrayList<Friend> friends = new ArrayList<Friend>();
	Scanner scn = new Scanner(System.in);

	@Override
	public void addFriend(Friend friend) {
		friends.add(friend);
		// ArrayList에 객체추가

	}
	@Override
	public void modFriend(Friend friend) {
		for(int i = 0; i <friends.size(); i++) {
			// 제너릭을 사용하면 다음과 같이 형변환 없이 구현이 가능하다.
			if(friends.get(i).getName().equals(friend.getName())) {
				friends.get(i).setPhoneNumber(friend.getPhoneNumber());
				break;
			}
			/*
			Friend fr = (Friend) friends.get(i); // arrayList의 첫번째 인덱스값의 객체를 fr참조변수에 저장.
			if(fr.getName().equals(friend.getName())) {
				fr.setPhoneNumber(friend.getPhoneNumber());
				break;
			 */
		}
	}


	@Override
	public void remFriend(String name) {
		for(int i = 0; i < friends.size(); i++) {
			// 제너릭을 이용하여 형변환 없이 구현			
			if(friends.get(i).getName().equals(name)) {
				friends.remove(i);
				i--;
			}
					
			/*
			Friend fr = (Friend) friends.get(i); // arrayList의 첫번째 인덱스값의 객체를 fr참조변수에 저장.
			if(fr.getName().equals(name)) {
				friends.remove(i);
				break;
			}*/
		}
	}

	@Override
	// 같은걸 여러번 출력하려면? ArrayList타입으로 바꾸어야하는가?
	public Friend findFriend(String name) {
		for(int i = 0; i <friends.size(); i++) {
			// 제너릭을 이용하여 형변환 없이 구현			
			if(friends.get(i).getName().equals(name)) {
				return friends.get(i);
			}
		}
		return null;
	}
	
	
	public ArrayList<Friend> findGender(Gender gender) {
		ArrayList<Friend> list = new ArrayList<Friend>();
		for(int i = 0; i < friends.size(); i++) {
			if(friends.get(i).getGender() == gender) {
				// 참조타입 equals
				// 기본타입 == 비교연산자
				// 열거형 == 비교연산자
				list.add(friends.get(i));
			}
		}
		return list;
	}
}
