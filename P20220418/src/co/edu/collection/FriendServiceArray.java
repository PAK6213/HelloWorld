/*package co.edu.collection;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.friend.Friend;
import co.edu.friend.Gender;
// 배열활용
public class FriendServiceArray implements FriendService {

	Friend[] friends = new Friend[10];
	Scanner scn = new Scanner(System.in);
	
	@Override
	// friend 인스턴스를 매개변수로 넘겨받아 객체배열이 비어있는곳을 확인하여 add
	public void addFriend(Friend friend) {
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
		
	
	}

	@Override
	// 매개변수로 friend 인스턴스를 넘겨받아 name을 비교후 phonenumber 수정
	public void modFriend(Friend friend) {
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(friend.getName())) {
				friends[i].setPhoneNumber(friend.getPhoneNumber());
				break;
			}
		}
	}

	@Override
	public void remFriend(String name) {
		for(int i = 0; i < friends.length; i++) {
			if(friends[i].getName().equals(name)) {
				friends[i] = null;
				break;
			}
		}
	}

	@Override
	public Friend findFriend(String name) {
		Friend friend = new Friend();
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				friend = friends[i];
				return friend;
			}
		}
		return friend;
	}

	
	
//	public ArrayList<Friend> findGender(Gender gender) {
//		ArrayList<Friend> list = new ArrayList<Friend>();
//		for(int i = 0; i < friends.length; i++) {
//			if()
//		}
//		return list;
//	}

}*/
