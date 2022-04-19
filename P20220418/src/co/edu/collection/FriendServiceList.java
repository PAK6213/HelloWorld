package co.edu.collection;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.friend.Friend;

public class FriendServiceList implements FriendService {
	ArrayList friends = new ArrayList();
	Scanner scn = new Scanner(System.in);
	@Override
	public void addFriend(Friend friend) {
		friends.add(friend);
		 // ArrayList에 객체추가

	}

	@Override
	public void modFriend(Friend friend) {
		
		for(int i = 0; i <friends.size(); i++) {
			Friend fr = (Friend) friends.get(i); // arrayList의 첫번째 인덱스값의 객체를 fr참조변수에 저장.
			if(fr.getName().equals(friend.getName())) {
				System.out.print("수정할 연락처를 입력하세요 :");
				String modphone = scn.nextLine();
				friends.set(i, modphone);
			}
		}
		
		
		
//		if(friends.contains(findName)) {
//			int index = friends.indexOf(findName);  // 해당이름이 위치한 index값 반환
//			System.out.print("수정할 연락처를 입력하세요 :");
//			String modPhone = scn.nextLine();
//			friends.set(index, modPhone);
//		}
		
	
	}
	

	@Override
	public void remFriend(String name) {
		for(int i = 0; i <friends.size(); i++) {
			Friend fr = (Friend) friends.get(i); // arrayList의 첫번째 인덱스값의 객체를 fr참조변수에 저장.
			if(fr.getName().equals(name)) {
				friends.remove(i);
			}
		}

	}

	@Override
	public Friend findFriend(String name) {
		for(int i = 0; i <friends.size(); i++) {
			Friend fr = (Friend) friends.get(i); // arrayList의 첫번째 인덱스값의 객체를 fr참조변수에 저장.
			if(fr.getName().equals(name)) {
				return fr;
			}
		}
		return null;
	}
	
	public void showFriend() {
		for(int i = 0; i < friends.size(); i++) {
			Friend fr = (Friend) friends.get(i);
			System.out.printf("이름 : %s  연락처 : %s \n", fr.getName(), fr.getPhoneNumber());
		}
	}

}
