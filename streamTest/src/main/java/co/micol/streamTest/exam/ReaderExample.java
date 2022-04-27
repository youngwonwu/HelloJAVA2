package co.micol.streamTest.exam;

import java.io.FileReader;
import java.io.Reader;

public class ReaderExample {
	
	public void run() {
		
		try {
			Reader reader = new FileReader("c:\\temp\\test1.txt");
			while(true) {
				int data = reader.read();
				if(data == -1) break;
				System.out.println((char)data);		//문자로 보여준다
			}
			reader.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
