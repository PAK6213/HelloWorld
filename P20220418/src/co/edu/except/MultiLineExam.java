package co.edu.except;

import java.util.Scanner;

public class MultiLineExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = "";
		while (true) {
			String temp = scn.nextLine();
			if (temp.equals("")) {
				break;
			}
			str += temp + "\n";
		}
	}
}
