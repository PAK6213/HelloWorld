package co.micol.prj.listTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import co.micol.prj.dto.StudentVO;

public class MapTest {
	Scanner scn = new Scanner(System.in);
	public void mapTest() {
		// MAP은 KEY, VALUE의 쌍으로 저장된다.
		Map<String, String> map = new HashMap<String,String>();
		map.put("name", "홍길동");
		map.put("address", "대구광역시");
		
		System.out.println(map.get("name"));
		System.out.println(map.get("address"));
		
	}
	
	public void studentMap() {
		Map<StudentVO, Integer> map = new HashMap<StudentVO, Integer>();
		String name ="";
		StudentVO s1 = new StudentVO(name);
		for(int i = 0; i < 5; i++) {
			System.out.println("이름을 입력하세요");
			name = scn.nextLine();
			System.out.println("점수을 입력하세요");
			int score = scn.nextInt();
			scn.nextLine();
			map.put(s1, score);
		}
		
		
	
		System.out.printf("%s의점수는 : %d" ,s1.getName(),map.get(s1));

}


}
