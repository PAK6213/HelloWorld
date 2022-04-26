package co.micol.prj;

import co.micol.prj.listTest.MapTest;

public class MainApp {

	public static void main(String[] args) {
//		ListTest list = new ListTest();
//		list.listTest();
//		System.out.println("==================");
//		list.studentList();
		
//		SetTest setTest = new SetTest();
//		setTest.setTest(); // 순서대로 나오진않음. 인덱스로 관리하지않기 때문.
		
		MapTest mapTest = new MapTest();
//		mapTest.mapTest();
		mapTest.studentMap();
	}
}
