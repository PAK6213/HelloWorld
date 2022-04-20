package co.edu.collection;

import java.util.ArrayList;

import co.edu.friend.Friend;
import co.edu.friend.Gender;

public interface FriendService {
	
	public int ADD = 1;
	public int MOD = 2;
	public int REM = 3;
	public int FIND = 4;
	public int MEN = 5;
	public int WOMEN = 6;
	
	// 추가, 수정, 삭제, 조회
	public void addFriend(Friend friend);
	public void modFriend(Friend friend);
	public void remFriend(String name);
	public Friend findFriend(String name);
	public ArrayList<Friend> findGender(Gender gender);
	
	//public void showFriend();
	
}
