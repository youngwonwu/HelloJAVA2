package co.micol.prj.stream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutStreamTest {
	
	public void run() {
		
		try {
			OutputStream outputStream = new FileOutputStream("c:\\Temp\\test.txt");		//Temp폴더먼저 생성해야함(c드라이브에)
			byte a = 40;		// 아스키 코드 40번
			byte b = 41;
			byte c = 42;
			outputStream.write(a);
			outputStream.write(b);
			outputStream.write(c);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
