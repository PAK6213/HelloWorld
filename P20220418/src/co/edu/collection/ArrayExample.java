package co.edu.collection;
import java.util.ArrayList;
import co.edu.friend.Friend;

// 배열 vs 컬렉션
// 배열활용한 프로그램, 컬렉션을 활용한 프로그램
// 인터페이스 선언 -> 구현하는 클래스.
public class ArrayExample {
	public static void main(String[] args) {
		// 배열은 크기 변경 불가. vs 크기 
		Friend[] friendAry = new Friend[10];
		friendAry[0] = new Friend("홍길동", "010-1111");
		friendAry[1] = new Friend("김길동", "010-2222");
		friendAry[0] = null;
		for(int i = 0; i < friendAry.length; i++) {
			if(friendAry[i] != null) { 
				System.out.println(friendAry[i].toString());

			}
		}
		
		// 컬렉션을 활용. 인터페이스 -> List : 컬렉션 -> ArrayList
		// 삭제를 해도 null에 대한 값을 자동으로 처리함.
		ArrayList friendList = new ArrayList();
		friendList.add(new Friend("박길동","010-3333"));
		friendList.add(new Friend("김길동","010-4444"));
		friendList.remove(0);
		
		for(int i = 0; i < friendList.size(); i++) {
			System.out.println(friendList.get(i));
		}
		// get사용시 Object타입으로 리턴되므로 형변환이 필요
		Friend f2 = (Friend) friendList.get(0); 
		
	}
}
