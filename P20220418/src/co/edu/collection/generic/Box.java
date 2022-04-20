package co.edu.collection.generic;

// 클래스의 타입들을 클래스를 정의할때는 정하지않고
// 인스턴스를 생성하고 사용할 시점에 정한다.
public class Box<T> {
	T field; // 모든 클래스의 부모클래스
	
	public void setField(T field) {
		this.field = field;
	}
	
	public T getField() {
		return field;
	}
}
