package co.micol.fileCopy.test;

import java.io.FileReader;
import java.io.Reader;

public class fileCopyExample {
	
	private String  reader = new FileReader("c:\\Temp\\source.txt");
	
	public void run() {
		
		try {
			reader = new FileReader(source);
			writer = new 
			
			while(true) {
				int data = reader.read();
				if(data == -1) break;
				writer.append((char)data);
				System.out.print("File Copy");
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
