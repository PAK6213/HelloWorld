package co.edu.variable;

public class VarExample5 {

	public static void main(String[] args) {
		int val = 10; // 4 * 1byte  -> 4 * 8bit  = 32bit; 값이 on / off
		long val1 = 10;
		long val2 = 123123123123123L;
		int val3 = (int)213141234L;

		int result;
		
		long val5 = 10000000000L;
		long val6 = 10L;
		result = (int)(val5 - val6);
		System.out.println(result);
		
		char charLit = 97;
		System.out.println(charLit);
		charLit = 44032;
		
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println(charLit++);
		}
		System.out.println(charLit);
	
	}

}
