package co.edu.collection;

import java.util.Scanner;

import co.edu.friend.Friend;
// 배열활용
public class FriendServiceArray implements FriendService {

	Friend[] friends = new Friend[10];
	Scanner scn = new Scanner(System.in);
	@Override
	public void addFriend(Friend friend) {
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
		
	
	}

	@Override
	public void modFriend(Friend friend) {
		System.out.print("찾을 이름을 입력하세요 :");
		String findName = scn.nextLine();
		for(int i = 0; i < friends.length; i++) {
			if(friends[i].getName().equals(findName)) {
				System.out.print("수정할 연락처를 입력하세요 :");
				String modPhone = scn.nextLine();
				friends[i].setPhoneNumber(modPhone);
				break;
			}
		}
	}

	@Override
	public void remFriend(String name) {
		System.out.print("삭제할 이름을 입력하세요 :");
		String delName = scn.nextLine();
		for(int i = 0; i < friends.length; i++) {
			if(friends[i].getName().equals(delName)) {
				friends[i] = null;
				break;
			}
		}
	}

	@Override
	public Friend findFriend(String name) {
		Friend friend = new Friend();
		System.out.print("조회할 이름을 입력하세요 :");
		String findName = scn.nextLine();
		for(int i = 0; i < friends.length; i++) {
			if(friends[i].getName().equals(findName)) {
				friend = friends[i];
				break;
			}
		}
		return friend;
	}
	
	public void showFriend() {
		for(Friend friend : friends) {
			if(friend != null) {
				System.out.println("친구정보: " + friend.toString());
			}
		}
	}

}
