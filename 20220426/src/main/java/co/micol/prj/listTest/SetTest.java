package co.micol.prj.listTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	public void setTest() {
		Set<String> name = new HashSet<String>();
		name.add("홍길동");
		name.add("박길동");
		name.add("이길동");
		name.remove("박길동");
		
		Iterator<String> iterator = name.iterator(); // 집합안에 있는 데이터를 읽기좋게 나열함.
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
