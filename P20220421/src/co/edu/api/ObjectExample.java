package co.edu.api;

import java.util.HashSet;

class Member {
	String name;
	int age;
	Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//HashSet , HashMap, Hashtable에서는 
	// 1. hashcode값을 비교하여 먼저 1차적으로 분류를 한다.
	// 2. equals값을 비교하여 1,2과정이 모두 같으면 동등한 객체이고 하나라도 다르면 다른 객체로 처리한다.
	
	@Override
	
	public int hashCode() {  
		//return super.hashCode();
		return this.age;
		
	}

	@Override
	public boolean equals(Object obj) {
		//return super.equals(obj);
		if(obj instanceof Member) { // obj가 Member로 형변환 될수 있는지 확인
			Member member = (Member) obj;
			return this.name.equals(member.name);
		}
		return false;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}

}

public class ObjectExample {

	public static void main(String[] args) {
		// ArrayList 인덱스 요소를 구분. => 중복된 값 저장.
		// Set (집합) : 요소값으로 구분 => 중복된 값 X

		HashSet<Integer> set = new HashSet<Integer>();
		set.add(100);
		set.add(200);
		set.add(300);
		set.add(200);

		System.out.println(set.size()); // 결과는 3 중복된값(200)을 add하지 않음.

		HashSet<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동",20));
		members.add(new Member("김길동",20));
		members.add(new Member("홍길동",20));

		System.out.println(members.size());  // 결과는 3 중복된 홍길동의 값도 add함.
		System.out.println(members.toString());

	}

}
