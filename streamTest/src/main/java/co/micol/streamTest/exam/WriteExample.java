package co.micol.streamTest.exam;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {
	
	//멤버변수 정의
	//생성자 정의
	//멤버 메소드(필요한 메소드)
	
	public void run() {
		try {
			OutputStream os = new FileOutputStream("c:\\Temp\\test1.txt");
			
//			byte[] arr = {40, 41, 42};
			byte[] arr = {'A', 'B', 'C'};	//
			os.write(arr);
			os.flush();
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
