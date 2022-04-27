package co.micol.streamTest.exam;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample {
	
	public void run() {
//		try {
//			InputStream is = new FileInputStream("c:\\Temp\\test1.txt");		//InputStream은 byte로 
//			while(true) {
//				int data = is.read();
//				if(data == -1) break;			//
//				System.out.println(data);
//			}
//			is.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			InputStream is = new FileInputStream("c:\\Temp\\test1.txt");		//InputStream은 byte로 
			byte[] buffer = new byte[100];
			
			while(true) {
				int data = is.read(buffer);
				if(data == -1) break;
				for(int i=0; i<data; i++) {
					System.out.println(buffer[i]);
				}
			}
			is.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
