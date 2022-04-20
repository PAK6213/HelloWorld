package co.edu.collection.generic;

import java.util.ArrayList;

import co.edu.friend.Friend;

public class BoxExample {

	class Orange {
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box = new Box();
		box.setField("Orange");
		// return 타입이 Object이므로 String으로 형변환
		String result = (String) box.getField(); 
		
		Box<Integer> box2 = new Box<Integer>();
		box2.setField(null);
		Integer result2 = box2.getField();
		
		// String 타입만 받는 ArrayList 인스턴스를 생성
		ArrayList<String> list = new ArrayList<String>();
		// list.add(10); String 타입이 아니라 에러가남.
		list.add("길동");
		
		
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("박길동","010-2222"));
	
		
		
		System.out.println("end of prog.");
	}

}
