package part_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class VehicleLogger {
	
	//Yarin Ackerman 318666443
	//Rami Abu Rabia 314820135
	
	private FileWriter fw;
	private PrintWriter pw;

	public VehicleLogger() throws IOException {
		
		fw = new FileWriter("Log.txt");
		pw = new PrintWriter(fw);
	}

	public void close() throws IOException {
		
		pw.close();
		fw.close();
	}

	public PrintWriter getPw() {
		return pw;
	}

	public void read() throws IOException {
		
		FileReader fr = new FileReader("Log.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String s1 = br.readLine();
		
		while (s1 != null) {
			System.out.println(s1);
			s1 = br.readLine();
		}
		br.close();
		fr.close();
	}

}
