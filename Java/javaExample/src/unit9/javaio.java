package unit9;

import java.io.*;

public class javaio {
	@SuppressWarnings("unused")
	public static void main(String[] args){
		File f = new File("/","run.bat");
		DataInputStream d = new DataInputStream(System.in);
		OutputStreamWriter o = new OutputStreamWriter(System.out);
		if(f.mkdir())
			System.out.print("1");
		if(f.delete())
			System.out.print("2");
		
	}
}
