package co.micol.prj.CopyExam;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class CopyExam {
	private String source ="C:/Temp/Source.txt";
	private String destination = "C:/Temp/result.txt";
	private Reader read;
	private Writer writer;
	
	public void copy () {
		try {
			read = new FileReader(source); // Source.txt를 출발지로하는 문자 기반 파일 입력 스트림 생성
			char[] buffer = new char[100];
			read.read(buffer); //문자 기반 파일의 내용을 buffer에 읽어옴.
			read.close(); // 입력스트림을 닫음.
			
			writer = new FileWriter(destination); //result.txt를 도착지로하는 문자 기반 파일 출력 스트림 생성
			writer.write(buffer); //buffer의 내용을 출력함
			writer.flush(); // 출력 버퍼에 잔류하는 모든문자 출력
			writer.close(); // 출력스트림을 닫음.
			
			System.out.println("filecopy complete.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
